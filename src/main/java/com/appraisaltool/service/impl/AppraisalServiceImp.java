package com.appraisaltool.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appraisaltool.dto.AppItemDTO;
import com.appraisaltool.dto.AppraisalDTO;
import com.appraisaltool.dto.AppraisalHeaderDTO;
import com.appraisaltool.dto.AppraiserAssignementDto;
import com.appraisaltool.dto.AppraiserCountDTO;
import com.appraisaltool.dto.domain.AppraisalTypeType;
import com.appraisaltool.mapper.AppraisalMapper;
import com.appraisaltool.model.ApplicationRole;
import com.appraisaltool.model.Appraisal;
import com.appraisaltool.model.AppraisalAverage;
import com.appraisaltool.model.AppraisalAverageId;
import com.appraisaltool.model.AppraisalItem;
import com.appraisaltool.model.AppraisalType;
import com.appraisaltool.model.CriteriaName;
import com.appraisaltool.model.GlobalAppraisalType;
import com.appraisaltool.model.InternalCriteriaSubtype;
import com.appraisaltool.model.InternalCriteriaType;
import com.appraisaltool.model.InternalSpecificAppType;
import com.appraisaltool.model.SpecificAppraisalType;
import com.appraisaltool.model.User;
import com.appraisaltool.repository.AppraisalAverageRepository;
import com.appraisaltool.repository.AppraisalItemRepository;
import com.appraisaltool.repository.AppraisalRepository;
import com.appraisaltool.repository.AppraisalTypeRepository;
import com.appraisaltool.repository.AppraiserAssignementRepository;
import com.appraisaltool.repository.CriteriaNameRepository;
import com.appraisaltool.repository.GlobalAppraisalTypeRepository;
import com.appraisaltool.repository.InternalCriteriaSubtypeRepository;
import com.appraisaltool.repository.InternalCriteriaTypeRepository;
import com.appraisaltool.repository.InternalSpecificAppTypeRepository;
import com.appraisaltool.repository.SpecificAppraisalTypeRepository;
import com.appraisaltool.service.AppraisalService;
import com.appraisaltool.service.TeamService;
import com.appraisaltool.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppraisalServiceImp implements AppraisalService {

    @Autowired
    private AppraisalRepository appraisalRepo;
    @Autowired
    private AppraiserAssignementRepository appraiserAssignementRepository;

    @Autowired
    private AppraisalItemRepository appItemRepo;
    @Autowired
    private SpecificAppraisalTypeRepository specificAppTypeRepo;
    @Autowired
    private GlobalAppraisalTypeRepository globalAppTypeRepo;
    @Autowired
    private InternalSpecificAppTypeRepository intSpecRepo;
    @Autowired
    private AppraisalAverageRepository appAverageRepo;
    @Autowired
    private CriteriaNameRepository criteriaRepo;
    @Autowired
    private AppraisalTypeRepository appTypeRepo;
    @Autowired
    private InternalCriteriaSubtypeRepository intCritSubtypeNameRepo;
    @Autowired
    private InternalCriteriaTypeRepository intCritTypeNameRepo;

    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;


    private final Integer INDIVIDUAL = 0;
    private final Integer TEAM = 1;
    private final Integer JOB = 2;
    private final Integer MOTIVATIONAL = 3;
    private final Integer CULTURE = 4;
    private final Integer ORGANIZATIONAL = 5;
    private final Integer MANAGEMENT = 6;
    private final Integer RELATIONAL = 7;
    private final Integer PROFESSIONAL_IMPACT = 8;
    private final Integer POTENCIAL = 9;

    @Deprecated
    public DozerBeanMapper mapper = new DozerBeanMapper();

    private final Integer MANAGER = 1;
    private final Integer SCRUM_MASTER_ROLE = 2;

    @Override
    public Appraisal getAppraisalById(Integer id) {

        Appraisal appraisal = appraisalRepo.getAppraisalByAppraisalId(id);
        return appraisal;
    }



    @Override
    public Appraisal createOrUpdateAppraisal(Appraisal appraisal) {

        return appraisalRepo.save(appraisal);

    }


    /**
     * Assigns appraisers for a whole office
     * 
     * @param officeId
     */
    @Deprecated
    public void assignAppraisers(@Valid Integer officeId) {

        // We get the list of all the user in an office
        List<User> userList = userService.getUserSByOfficeId(officeId);

        // For each user me call the service that assigns appraiser
        for (User currentUser : userList) {
            if (currentUser != null) {
                assignAppraiserToUserAsEvaluated(currentUser, new Integer(2021));
            }
        }
    }

    @Override
    public Integer assignAppraiserToEmployee(Integer userId, Integer evalDate) {
        User user = userService.getUserByUserId(userId);

        return assignAppraiserToUserAsEvaluated(user, evalDate).size();
    }

    @Override
    public Integer assignAppraiserToEmployeeFromOffice(Integer officeId, Integer evalDate) {
        List<Appraisal> result = new ArrayList<>();
        // We get the list of all the user in an office
        List<User> userList = userService.getUserSByOfficeId(officeId);

        log.info("Init to assign Appraiser to the office " + officeId);

        Collections.shuffle(userList);

        // For each user me call the service that assigns appraiser
        for (User user : userList) {
            result.addAll(assignAppraiserToUserAsEvaluated(user, evalDate));
        }
        log.info("Finish to assign Appraiser to the office " + officeId + " Created " + result);
        return result.size();
    }

    /**
     * Assigns the appraisers for a particular user
     * 
     * Only it creates the assignAppraiser if the user doesn't have some appraisal
     * 
     * @param user
     */
    private List<Appraisal> assignAppraiserToUserAsEvaluated(User user, Integer evalDate) {

        List<Appraisal> result = new ArrayList<>();
        if (appraisalRepo.countAppraisalEvaluatedPersonAndEvalDate(user.getUserId(), evalDate) > 0) {
            log.warn("The user " + user.getUserId() + " has aprraisal created previously");
            return result;
        }

        Boolean alreadyIncluded;

        // 1. First appraiser: YOURSELF
        result.add(createNewAppraisal(user, user, evalDate, AppraisalTypeType.YOURSELF, 0, null));

        // 2-3. Line Manager
        if (user.getLineManager() != null && user.getUserId().compareTo(user.getLineManager().getUserId()) != 0) {
            result.add(createNewAppraisal(user, user.getLineManager(), evalDate, AppraisalTypeType.LINE_MANAGER_2_EVALUATED, 0, null));
            result.add(createNewAppraisal(user.getLineManager(), user, evalDate, AppraisalTypeType.EVALUATED_2_LINE_MANAGER, 0, null));
        }


        // 3-4: Team Lead
        if (user.getTeamLead() != null && user.getUserId().compareTo(user.getTeamLead().getUserId()) != 0) {
            result.add(createNewAppraisal(user, user.getTeamLead(), evalDate, AppraisalTypeType.TEAM_LEAD_2_EVALUATED, 0, null));
            result.add(createNewAppraisal(user.getTeamLead(), user, evalDate, AppraisalTypeType.EVALUATED_2_TEAM_LEAD, 0, null));
        }

        // 5-6: Mentor
        if (user.getMentor() != null && user.getUserId().compareTo(user.getMentor().getUserId()) != 0) {
            result.add(createNewAppraisal(user, user.getMentor(), evalDate, AppraisalTypeType.MENTOR_2_EVALUATED, 0, null));
            result.add(createNewAppraisal(user.getMentor(), user, evalDate, AppraisalTypeType.EVALUATED_2_MENTOR, 0, null));
        }


        // 7. Fourth appraiser: TEAMMATE
        if (!user.getEmployedTeam().isEmpty()) {
            List<User> teamMateList = userService.findTeamMatesNoAppraiserBy(user);

            if (teamMateList.size() > 0) {
                Random rand = new Random();
                User teamUser = teamMateList.get(rand.nextInt(teamMateList.size()));
                result.add(createNewAppraisal(teamUser, user, evalDate, AppraisalTypeType.TEAMMATE, 0, null));
            }
        }

        // 8. Fourth appraiser: GROUP MATE
        if (!user.getEmployedGroup().isEmpty()) {
            List<User> groupMateList = userService.findGroupMatesNoAppraiserBy(user);

            if (groupMateList.size() > 0) {
                Random rand = new Random();
                User groupUser = groupMateList.get(rand.nextInt(groupMateList.size()));
                result.add(createNewAppraisal(groupUser, user, evalDate, AppraisalTypeType.GROUPMATE, 0, null));
            }
        }

        return result;
    }

    private Integer chooseAppraiserFromList(List<Integer> teamMateList, List<Integer> totalAppraisersList) {

        List<AppraiserCountDTO> appraisalsPerAppraiser = appraisalRepo.getNumberOfAppraisalPerAppraiser(teamMateList);
        Boolean alreadyIncluded = false;

        AppraiserCountDTO minAppraiser = null;
        for (AppraiserCountDTO currentAppraiser : appraisalsPerAppraiser) {

            alreadyIncluded = !totalAppraisersList.stream().filter(currId -> currId == currentAppraiser.getAppraiserId()).collect(Collectors.toList()).isEmpty();

            if (minAppraiser == null && !alreadyIncluded) {
                minAppraiser = currentAppraiser;
            } else if (!alreadyIncluded && minAppraiser != null && currentAppraiser.getCount() < minAppraiser.getCount()) {
                minAppraiser = currentAppraiser;
            }
        }

        if (minAppraiser == null) {
            return null;
        } else {
            return minAppraiser.getAppraiserId();
        }
    }



    /**
     * 
     * @param appraiserId
     * @return
     */
    public List<Appraisal> getRemainingAppraisalsForAUserAndStatus(@Valid Integer appraiserId, Integer status) {
        List<Appraisal> appraisalList = appraisalRepo.findAllByAppraiserIdAndStatus(appraiserId, status);
        return appraisalList;

    }

    /**
     * Gets the appraisal items by appraisal and type
     * 
     * @param appId
     * @param appItemTypeId
     * @return
     */
    public List<AppraisalItem> findAppItemsByAppraisalIdAndAppItemType(Integer appId, Integer appItemTypeId) {
        return appItemRepo.findAppItemsByAppraisalIdAndAppItemType(appId, appItemTypeId);

    }


    // Ninguna referencia en el código
    @Deprecated
    public AppItemDTO newOrUpdateAppraisalItem(AppItemDTO appItem) {

        List<AppraisalItem> appItemList = findAppItemsByAppraisalIdAndAppItemType(appItem.getAppraisalId(), appItem.getCurrentPage());

        AppraisalItem app01 = appItemList.stream().filter(indApp -> indApp.getSubtypeId() == 1).collect(Collectors.toList()).get(0);
        app01.setParamValue(appItem.getParamValue01());
        appItemRepo.save(app01);

        AppraisalItem app02 = appItemList.stream().filter(indApp -> indApp.getSubtypeId() == 2).collect(Collectors.toList()).get(0);
        app02.setParamValue(appItem.getParamValue02());
        appItemRepo.save(app02);

        AppraisalItem app03 = appItemList.stream().filter(indApp -> indApp.getSubtypeId() == 3).collect(Collectors.toList()).get(0);
        app03.setParamValue(appItem.getParamValue03());
        appItemRepo.save(app03);

        AppraisalItem app04 = appItemList.stream().filter(indApp -> indApp.getSubtypeId() == 4).collect(Collectors.toList()).get(0);
        app04.setParamValue(appItem.getParamValue04());
        appItemRepo.save(app04);

        AppraisalItem app05 = appItemList.stream().filter(indApp -> indApp.getSubtypeId() == 5).collect(Collectors.toList()).get(0);
        app05.setParamValue(appItem.getParamValue05());
        appItemRepo.save(app05);

        return appItem;
    }

    /**
     * 
     * @param userId
     * @param appraiserId
     * @return
     */
    public Appraisal createNewAppraisal(User evaluatedPerson, User apprasier, Integer evalDate, AppraisalTypeType type, Integer status, List<AppraisalItem> apprItemList) {
        Appraisal app = new Appraisal(null, evaluatedPerson, apprasier, evalDate, type, status, apprItemList);
        app.setApprItemList(initializeApprList(app));
        app = appraisalRepo.save(app);
        // Set<AppraisalItem> appItemSet = ;
        // appItemRepo.saveAll(appItemSet);
        return app;
    }


    private List<AppraisalItem> initializeApprList(Appraisal app) {
        List<AppraisalItem> appraisalItemList = new ArrayList<AppraisalItem>();

        // I va a ser el SUBTYPE_ID y va de 1 a 5 todo el rato.
        // Z va a ser el APPRAISAL_TYPE_ID. 00000,11111,22222,33333 ...hasta 99999
        // 0 as PARAM_VALUE nota por defecto

        for (int appType = 0; appType <= 9; appType++) {
            for (int subType = 1; subType <= 5; subType++) {
                appraisalItemList.add(new AppraisalItem(appType, subType, 0, app));
            }
        }

        return appraisalItemList;
    }


    public List<Appraisal> getAppraisalByEvaluatedPersonId(Integer userId, Integer status) {
        return appraisalRepo.getAppraisalByEvaluatedPersonIdAndStatus(userId, status);
    }

    /**
     * 
     * @param officeId
     * @return
     */
    public Integer setRemainingAppraisalsToExpired(@Valid Integer officeId) {

        // Get all the remaining appraisals
        List<Appraisal> appraisalList = getAppraisalsByOfficeAndStatus(officeId, 0);
        Integer recordsChanged = 0;

        // Setear los appraisals a estado 3 (Caducado)
        for (Appraisal currentAppraisal : appraisalList) {
            currentAppraisal.setStatus(3);
            appraisalRepo.save(currentAppraisal);
            recordsChanged++;
        }

        return recordsChanged;

    }

    public List<Appraisal> getAppraisalsByOfficeAndStatus(Integer officeId, Integer statusId) {

        return appraisalRepo.getAppraisalsByOfficeIdAndStatusId(officeId, statusId);
    }



    /**
     * @param userId
     * @return
     */
    public List<User> getUserAppraisalsToDisplay(@Valid Integer userId) {
        User u = userService.getUserByUserId(userId);

        // Is the user a mentor
        List<User> userToDisplay = null;

        if (u.getAppRole() == ApplicationRole.ADMIN) {
            userToDisplay = userService.getUserSByOfficeId(u.getOffice().getOfficeId());
        } else if (u.getRole().getRoleId() == SCRUM_MASTER_ROLE) {
            List<Integer> listIdUser = userService.findTeamMates(userId);
            userToDisplay = userService.getUsersInList(listIdUser);
        }

        List<User> mentorized = userService.getMentorized(userId);

        if (mentorized != null && u.getAppRole() != ApplicationRole.ADMIN) {
            if (userToDisplay == null) {
                userToDisplay = mentorized;
            } else {
                userToDisplay.addAll(userService.getMentorized(userId));
            }
        }

        return userToDisplay;

    }



    public Double getTotalAverageForAnAppraisal(Integer appraisalId) {
        Double totalAverage = 0D;
        Double sumTotal = 0D;

        Integer roleId = getEvaluatePersonRoleByAppraisalId(appraisalId);
        // Obtener PESO ESPECIFICOS
        List<SpecificAppraisalType> specificAppType = specificAppTypeRepo.findAllBySpecificAppraisalTypeIdRoleId(roleId);
        // Obtener PESO GLOBALES
        List<GlobalAppraisalType> globalAppType = globalAppTypeRepo.findAllByGlobalAppraisalTypeIdRoleId(roleId);


        // Para cada appraisal, recuperamos los 50 appraisal items (Notas).
        AppraisalItem[][] appItems = getAppItemsByAppraisalId(appraisalId);

        if (specificAppType != null && specificAppType.size() > 0) {
            for (int i = 0; i < 10; i++) {
                int[] iArray = {
                        i};

                for (int j = 0; j < 5; j++) {

                    int[] jArray = {
                            j + 1};

                    // Seleccionamos dentro de la lista de pesos, los que se corresponden con el typo y subtypo por el que vamos.
                    Integer specificWeight = specificAppType.stream().filter(specificApp -> specificApp.getSpecificAppraisalTypeId().getAppraisalTypeId() == iArray[0]
                            && specificApp.getSpecificAppraisalTypeId().getSubtypeId() == jArray[0]).collect(Collectors.toList()).get(0).getWeight();

                    if (appItems[i][j] != null) {
                        // Multiplicamos cada criterio especifico por su peso.
                        sumTotal = sumTotal + (appItems[i][j].getParamValue() * (specificWeight / (1D * 100)));
                    }
                }
                // Cada grupo de criterios especificos, se multiplica por el peso global de ellos sobre el total.
                Integer currGlobalWeight = globalAppType.stream().filter(globalW -> globalW.getGlobalAppraisalTypeId().getAppraisalTypeId() == iArray[0]).collect(Collectors
                        .toList()).get(0).getWeight();
                totalAverage = totalAverage + (sumTotal * (currGlobalWeight / (1D * 100)));
                sumTotal = 0D;
            }
        }

        return totalAverage;

    }


    /**
     * Creates the headers to be displayed with the total average,
     * 
     * @param appraisalList
     * @return
     */
    public List<AppraisalHeaderDTO> getAppraisalheaders(List<Appraisal> appraisalList, Integer evaluatedPersonId, Integer currentUserId) {

        if (appraisalList == null) {
            return null;
        } else {

            // Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User currentUser = userService.getUserByUserId(currentUserId);

            List<AppraisalHeaderDTO> appraisalHeaderDto = new ArrayList<AppraisalHeaderDTO>();
            AppraisalHeaderDTO appraisalHeader;


            for (Appraisal currApp : appraisalList) {
                appraisalHeader = new AppraisalHeaderDTO();

                User evaluatedPerson = userService.getUserByUserId(currApp.getEvaluatedPerson().getUserId());
                User appraiser = userService.getUserByUserId(currApp.getAppraiser().getUserId());

                appraisalHeader.setAppraisalId(currApp.getAppraisalId());
                appraisalHeader.setEvaluatedPersonName(evaluatedPerson.getName() + " " + evaluatedPerson.getSurname());

                if (ApplicationRole.ADMIN == (currentUser).getAppRole()) {
                    appraisalHeader.setAppraiserName(appraiser.getName() + " " + appraiser.getSurname());
                } else {
                    appraisalHeader.setAppraiserName("?¿??¿?¿?¿?¿?¿?¿?¿");
                }

                appraisalHeader.setAverage(getTotalAverageForAnAppraisal(currApp.getAppraisalId()));
                appraisalHeaderDto.add(appraisalHeader);
            }

            return appraisalHeaderDto;
        }

    }


    /**
     * This method returns the appItems associated to an appraisal ordered by type and subtype
     * 
     * @param appraisalId
     * @return
     */
    public AppraisalItem[][] getAppItemsByAppraisalId(Integer appraisalId) {

        AppraisalItem[][] appItemListGroup = new AppraisalItem[10][5];
        List<AppraisalItem> appItemList = appItemRepo.findAllByAppraisalOrderByAppraisalTypeIdAscSubtypeIdAsc(appraisalId);

        // Pasamos los items a una matriz para tenerlos en orden y recuperarlo en la pantalla como model["appItems"][0] etc.
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                appItemListGroup[i][j] = appItemList.get(k);
                k++;
            }
        }


        return appItemListGroup;

    }


    /**
     * Calculates the average for each group type (Individual, Job, motivational...) for an appraisal
     * 
     * @param appItems
     * @return
     */
    public Double[] calculateSpecificAppAverages(AppraisalItem[][] appItems) {

        // Integer appraisalId = appItems[0][0].getAppraisalId();
        Integer appraisalId = appItems[0][0].getAppraisal().getAppraisalId();
        Integer roleId = getEvaluatePersonRoleByAppraisalId(appraisalId);

        Double[] average = new Double[10];
        Double sumaTotal = 0D;
        int j = 0, i = 0;

        // Obtener los pesos especificos para multiplicar cada uno de las evaluaciones por el coeficiente
        List<SpecificAppraisalType> specificAppType = specificAppTypeRepo.findAllBySpecificAppraisalTypeIdRoleId(roleId);


        for (i = 0; i < 10; i++) {
            for (j = 0; j < 5; j++) {
                // We need to create these arrays so we don't need to use a final variable in the lambda expression
                // I add 1 to jArray cause in the lambda expression we look for values, not positions, and subtypes (Criteries "j") starts with 1 rather than 0.
                // appraisalTypes (Individuals...) start with 0, so we don't need to add anything, value and position matches.
                int[] iArray = {
                        i};
                int[] jArray = {
                        j + 1};

                Integer specificWeight = specificAppType.stream().filter(specificApp -> specificApp.getSpecificAppraisalTypeId().getAppraisalTypeId() == iArray[0] && specificApp
                        .getSpecificAppraisalTypeId().getSubtypeId() == jArray[0]).collect(Collectors.toList()).get(0).getWeight();
                sumaTotal = sumaTotal + (appItems[i][j].getParamValue()) * ((specificWeight * 1D / 100));
            }

            average[i] = sumaTotal;
            sumaTotal = 0D;
        }

        return average;
    }

    /**
     * Returns the person evaluated by appraisalId
     * 
     * @param appraisalId
     * @return
     */
    public Integer getEvaluatePersonRoleByAppraisalId(Integer appraisalId) {

        Integer evaluatedPersonId = appraisalRepo.getAppraisalByAppraisalId(appraisalId).getEvaluatedPerson().getUserId();
        User evaluatedPerson = userService.getUserByUserId(evaluatedPersonId);

        if (evaluatedPerson != null) {
            return evaluatedPerson.getRole().getRoleId();
        } else {
            return null;
        }

    }


    /**
     * Returns all the appraisals associated to a person
     * 
     * @param evalPersonId
     * @return
     */
    public List<Appraisal> findAllAppraisalsByEvalPersonId(Integer evalPersonId) {
        return appraisalRepo.findAllByEvaluatedPersonId(evalPersonId);
    }


    /**
     * Gets the averages to show for the internal criteria
     * 
     * @param userId
     * @return
     */
    public Double[][] getInternalCriteriaResults(Integer userId) {

        List<Integer> appraisalList = appraisalRepo.findAllIdsByEvaluatedPersonIdAndStatus(userId, 1);
        Double[][] averagesToShow = new Double[4][5];

        Integer role = userService.getUserByUserId(userId).getRole().getRoleId();

        // Gets the averages for the 4 grouper specific criterias
        averagesToShow[0] = getGroupedCompetitiveAverages(appraisalList);
        averagesToShow[1] = getGroupedImpactAverages(appraisalList);
        averagesToShow[2] = getGroupedContImprovementAverages(appraisalList, role);
        averagesToShow[3] = getGroupedValueAverages(appraisalList);

        return averagesToShow;
    }

    /**
     * Competitive averages (1)
     * 
     * @param appraisalList
     * @return
     */
    private Double[] getGroupedCompetitiveAverages(List<Integer> appraisalList) {

        Double[] result = new Double[] {
                0D, 0D, 0D, 0D, 0D};


        List<AppraisalAverage> appAvgIndList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, INDIVIDUAL);
        List<AppraisalAverage> appAvgJobList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, JOB);
        List<AppraisalAverage> appAvgPotencialList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, POTENCIAL);
        List<AppraisalAverage> appAvgManList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, MANAGEMENT);
        List<AppraisalItem> appComunEnglish = appItemRepo.findAllByAppraisalIdListAppraisalTypeAndSubtype(appraisalList, 7, 5);


        for (int i = 0; i < appAvgIndList.size(); i++) {
            result[0] = result[0] + appAvgIndList.get(i).getAverage();
            result[1] = result[1] + appAvgJobList.get(i).getAverage();
            result[2] = result[2] + appAvgPotencialList.get(i).getAverage();
            result[3] = result[3] + appAvgManList.get(i).getAverage();
            result[4] = result[4] + appComunEnglish.get(i).getParamValue();
        }

        result[0] = result[0] / appAvgIndList.size();
        result[1] = result[1] / appAvgIndList.size();
        result[2] = result[2] / appAvgIndList.size();
        result[3] = result[3] / appAvgIndList.size();
        result[4] = result[4] / appAvgIndList.size();


        return result;
    }



    /**
     * IMPACT AVERAGES (2)
     * 
     * @param appraisalList
     * @return
     */
    private Double[] getGroupedImpactAverages(List<Integer> appraisalList) {

        Double[] result = new Double[] {
                0D, 0D, 0D, 0D, 0D};

        List<AppraisalItem> behavImpact = appItemRepo.findAllByAppraisalIdListAppraisalTypeAndSubtype(appraisalList, 8, 4);
        List<AppraisalItem> decisionsAttitude = appItemRepo.findAllByAppraisalIdListAppraisalTypeAndSubtype(appraisalList, 1, 1);
        List<AppraisalItem> manageOrganTeam = appItemRepo.findAllByAppraisalIdListAppraisalTypeAndSubtype(appraisalList, 1, 4);
        List<AppraisalItem> dailyImpact = appItemRepo.findAllByAppraisalIdListAppraisalTypeAndSubtype(appraisalList, 8, 2);
        List<AppraisalItem> leadership = appItemRepo.findAllByAppraisalIdListAppraisalTypeAndSubtype(appraisalList, 1, 5);


        for (int i = 0; i < behavImpact.size(); i++) {
            result[0] = result[0] + behavImpact.get(i).getParamValue();
            result[1] = result[1] + decisionsAttitude.get(i).getParamValue();
            result[2] = result[2] + manageOrganTeam.get(i).getParamValue();
            result[3] = result[3] + dailyImpact.get(i).getParamValue();
            result[4] = result[4] + leadership.get(i).getParamValue();
        }

        result[0] = result[0] / behavImpact.size();
        result[1] = result[1] / behavImpact.size();
        result[2] = result[2] / behavImpact.size();
        result[3] = result[3] / behavImpact.size();
        result[4] = result[4] / behavImpact.size();

        return result;
    }



    /**
     * CONTINUOUS IMPROVEMENT (3)
     * 
     * @param appraisalList
     * @param role
     * @return
     */
    private Double[] getGroupedContImprovementAverages(List<Integer> appraisalList, Integer role) {

        Double[] result = new Double[] {
                0D, 0D, 0D, 0D, 0D};


        List<AppraisalAverage> appAvgMotivationList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, MOTIVATIONAL);
        List<AppraisalAverage> appAvgPotencialList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, POTENCIAL);
        List<AppraisalAverage> appAvgImpactList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, PROFESSIONAL_IMPACT);
        List<AppraisalAverage> appAvgManagementList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, MANAGEMENT);;
        List<AppraisalAverage> appAvgTeamList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, TEAM);


        for (int i = 0; i < appAvgMotivationList.size(); i++) {
            result[0] = result[0] + appAvgMotivationList.get(i).getAverage();
            result[1] = result[1] + appAvgPotencialList.get(i).getAverage();
            result[2] = result[2] + appAvgImpactList.get(i).getAverage();

            if (SCRUM_MASTER_ROLE == role || MANAGER == role) {
                result[3] = result[3] + appAvgManagementList.get(i).getAverage();

            } else {
                result[4] = result[4] + appAvgTeamList.get(i).getAverage();
            }
        }

        result[0] = result[0] / appAvgMotivationList.size();
        result[1] = result[1] / appAvgMotivationList.size();
        result[2] = result[2] / appAvgMotivationList.size();
        result[3] = result[3] / appAvgMotivationList.size();
        result[4] = result[4] / appAvgMotivationList.size();

        return result;
    }


    /**
     * INDIVIDUAL VALUE (4)
     * 
     * @param appraisalList
     * @return
     */
    private Double[] getGroupedValueAverages(List<Integer> appraisalList) {

        Double[] result = new Double[] {
                0D, 0D, 0D, 0D, 0D};

        List<AppraisalAverage> appAvgJobList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, JOB);
        List<AppraisalAverage> appAvgIndList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, INDIVIDUAL);
        List<AppraisalAverage> appAvgPotencialList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, POTENCIAL);
        List<AppraisalAverage> appMotivList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, MOTIVATIONAL);
        List<AppraisalAverage> appOrganizList = appAverageRepo.findAllByAppIdListAndAppraisalType(appraisalList, ORGANIZATIONAL);

        for (int i = 0; i < appAvgIndList.size(); i++) {
            result[0] = result[0] + appAvgJobList.get(i).getAverage();
            result[1] = result[1] + appAvgIndList.get(i).getAverage();
            result[2] = result[2] + appAvgPotencialList.get(i).getAverage();
            result[3] = result[3] + appMotivList.get(i).getAverage();
            result[4] = result[4] + appOrganizList.get(i).getAverage();
        }


        result[0] = result[0] / appAvgJobList.size();
        result[1] = result[1] / appAvgJobList.size();
        result[2] = result[2] / appAvgJobList.size();
        result[3] = result[3] / appAvgJobList.size();
        result[4] = result[4] / appAvgJobList.size();

        return result;
    }


    /**
     * When an appraisal is finished, calculate the averages and save it in the database
     * 
     * @param appraisalId
     */
    public void calculateAndInsertAverages(@Valid Integer appraisalId) {

        AppraisalItem[][] appItems = getAppItemsByAppraisalId(appraisalId);
        Double[] averages = calculateSpecificAppAverages(appItems);

        AppraisalAverage appAverage;
        AppraisalAverageId appAverId;

        for (int i = 0; i < averages.length; i++) {
            appAverage = new AppraisalAverage();
            appAverId = new AppraisalAverageId();

            appAverId.setAppraisalId(appraisalId);
            appAverId.setAppraisalTypeId(i);

            appAverage.setAppAverageId(appAverId);
            appAverage.setAverage(averages[i]);


            appAverageRepo.save(appAverage);

        }

    }

    public CriteriaName[][] findAllCriterias(Integer language) {

        List<CriteriaName> criteriaNameList = criteriaRepo.findAllByLanguageOrderByCriteriaNameId(language);
        CriteriaName[][] criteriasName = new CriteriaName[10][5];

        // Pasamos los items a una matriz para tenerlos en orden y recuperarlo en la pantalla como model["appItems"][0] etc.
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                criteriasName[i][j] = criteriaNameList.get(k);
                k++;
            }
        }
        return criteriasName;
    }


    public AppraisalType[] findAllAppraisalTypes() {

        List<AppraisalType> appType = appTypeRepo.findByOrderByAppraisalTypeIdAsc();
        AppraisalType[] appraisalType = new AppraisalType[10];

        // Pasamos los items a una matriz para tenerlos en orden y recuperarlo en la pantalla como model["appItems"][0] etc.
        int k = 0;
        for (int i = 0; i < 10; i++) {
            appraisalType[i] = appType.get(k);
            k++;
        }

        return appraisalType;

    }


    /**
     * Save all the app items for an appraisal
     * 
     * @param paramValue
     */
    public void saveAndFinishAppraisal(@Valid AppraisalItem[][] paramValue) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                appItemRepo.save(paramValue[i][j]);
            }
        }


    }


    public List<InternalCriteriaType> getInternalCriteriaTypes(Integer language) {
        String[] internalCriteriaTitle = new String[] {
                "Competitivo en el sector", "Impacto en el clima laboral", "Mejora continua", "Valor individual del trabajador"};

        return intCritTypeNameRepo.getInternalCriteriaTypeByLanguage(language);


        // return internalCriteriaTitle;
    }



    public Double[] getAverages(Double[][] internalCriteriaResultsInteger, Integer userId) {

        Integer roleId = userService.getUserByUserId(userId).getRole().getRoleId();
        Double[] averages = new Double[4];
        Double result = 0D;
        List<InternalSpecificAppType> currentWeight;


        List<InternalSpecificAppType> weightList = intSpecRepo.findAllByInternalSpecificAppTypeIdRoleId(roleId);


        for (int i = 0; i < internalCriteriaResultsInteger.length; i++) {
            int[] iArray = {
                    i};
            result = 0D;
            for (int j = 0; j < internalCriteriaResultsInteger[i].length; j++) {
                int[] jArray = {
                        j};

                currentWeight = weightList.stream().filter(currWeight -> currWeight.getInternalSpecificAppTypeId().getGroupId() == iArray[0] && currWeight
                        .getInternalSpecificAppTypeId().getSubtypeId() == jArray[0]).collect(Collectors.toList());

                if (currentWeight != null && currentWeight.size() > 0) {
                    result = result + (internalCriteriaResultsInteger[i][j] * currentWeight.get(0).getWeight());
                }


            }
            averages[i] = result / (100);

        }

        return averages;
    }



    public List<InternalCriteriaSubtype> getGroupCriteriaSubtitles(Integer language) {

        String[][] internalCriteria = {
                {
                        "Individuales", "Inherente al cargo", "Potencial", "Gestión", "Comunicacion en ingles"}, {
                                "Impacto en el comportamiento de los compañeros", "Actitud ante decisiones y adaptación al cambio",
                                "Contribuye a la gestión y organización del trabajo del equipo", "Impacto en el ambiente laboral diario",
                                "Habilidades de liderazgo demostradas a lo largo del año"}, {
                                        "Motivación y logros", "Potencial ", "Impacto general en IG", "Gestion (Manager/SM)", "Trabajo en equipo (Dev/QA)"}, {
                                                "Inherentes al cargo", "Individuales", "Potencial", "Motivación y logros", "Organizacion personal"}};

        return intCritSubtypeNameRepo.getInternalCriteriaSubypeByLanguage(language);

    }


    public List<Integer> findAllIdsByEvaluatedPersonIdAndStatus(Integer evalPersonId, Integer status) {
        return appraisalRepo.findAllIdsByEvaluatedPersonIdAndStatus(evalPersonId, status);
    }


    public List<Integer> getAppraiserIdByEvaluatedPersonId(Integer evalPersonId) {
        return appraisalRepo.getAppraiserIdByEvaluatedPersonId(evalPersonId);
    }



    public Appraisal convertFromDtoToAppraisal(@Valid AppraisalDTO appraisalDto) {

        Appraisal app = appraisalRepo.getAppraisalByAppraisalId(appraisalDto.getAppraisalId());

        List<AppraisalItem> appItemList = app.getApprItemList();


        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 0 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue00());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 0 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue01());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 0 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue02());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 0 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue03());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 0 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue04());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 1 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue10());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 1 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue11());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 1 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue12());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 1 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue13());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 1 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue14());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 2 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue20());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 2 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue21());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 2 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue22());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 2 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue23());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 2 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue24());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 3 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue30());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 3 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue31());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 3 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue32());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 3 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue33());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 3 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue34());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 4 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue40());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 4 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue41());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 4 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue42());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 4 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue43());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 4 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue44());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 5 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue50());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 5 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue51());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 5 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue52());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 5 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue53());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 5 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue54());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 6 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue60());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 6 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue61());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 6 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue62());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 6 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue63());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 6 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue64());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 7 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue70());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 7 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue71());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 7 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue72());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 7 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue73());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 7 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue74());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 8 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue80());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 8 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue81());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 8 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue82());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 8 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue83());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 8 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue84());



        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 9 && appItem.getSubtypeId() == 1).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue90());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 9 && appItem.getSubtypeId() == 2).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue91());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 9 && appItem.getSubtypeId() == 3).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue92());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 9 && appItem.getSubtypeId() == 4).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue93());

        appItemList.stream().filter(appItem -> appItem.getAppraisalTypeId() == 9 && appItem.getSubtypeId() == 5).collect(Collectors.toList()).get(0).setParamValue(appraisalDto
                .getParamValue94());


        app.setApprItemList(appItemList);


        return app;
    }


    /**
     * 
     * @return A list with all the appraisalTypes
     */
    public List<AppraisalType> getAppraisalTypes() {

        return appTypeRepo.findAll();

    }


    /**
     * 
     * @return A list with all the criterias
     */
    public List<CriteriaName> getCriteriaNames() {

        return criteriaRepo.findAll();

    }

    @Override
    public List<AppraiserAssignementDto> getAppraiserAssignement() {
        return AppraisalMapper.INSTANCE.map(appraiserAssignementRepository.findAll());
    }

}
