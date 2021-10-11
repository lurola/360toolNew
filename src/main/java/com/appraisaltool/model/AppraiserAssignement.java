package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "APPRAISER_ASSIGNEMENT")
public class AppraiserAssignement {

    // Info related with the appraiser
    @Column
    private Integer userId;
    @Column
    private String name;
    @Column
    private String surname;

    @Column
    private Integer evalDate;

    // Youself appraisal references
    @Id
    @Column(name = "yourselfId")
    private Integer yourselfAppraisalfId;
    @Column(name = "status")
    private Integer yourselfStatus;

    // Line Manager appraisal references
    @Column (name ="lmId")
    private Integer lineManagerAppraisalId;
    @Column(name = "lmStatus")
    private Integer lineManagerStatus;
    @Column(name = "lmUserId")
    private Integer lineManagerEvaluatedPersonId;
    @Column(name = "lmName")
    private String lineManagerName;
    @Column(name = "lmSurname")
    private String lineManagerSurname;

    // Team lead appraisal references
    @Column(name = "tlId")
    private Integer teamLeadAppraisalId;
    @Column(name = "tlStatus")
    private Integer teamLeadStatus;
    @Column(name = "tlUserId")
    private Integer teamLeadEvaluatedPersonId;
    @Column(name = "tlName")
    private String teamLeadName;
    @Column(name = "tlSurname")
    private String teamLeadSurname;

    // Mentor appraisal references
    @Column(name = "mtId")
    private Integer mentorAppraisalId;
    @Column(name = "mtStatus")
    private Integer mentorStatus;
    @Column(name = "mtUserId")
    private Integer mentorEvaluatedPersonId;
    @Column(name = "mtName")
    private String mentorName;
    @Column(name = "mtSurname")
    private String mentorSurname;

    // Team mate appraisal references
    @Column(name = "tmId")
    private Integer teamAppraisalId;
    @Column(name = "tmStatus")
    private Integer teamStatus;
    @Column(name = "tmUserId")
    private Integer teamEvaluatedPersonId;
    @Column(name = "tmName")
    private String teamName;
    @Column(name = "tmSurname")
    private String teamSurname;

    // Group mate appraisal references
    @Column(name = "gmId")
    private Integer groupAppraisalId;
    @Column(name = "gmStatus")
    private Integer groupStatus;
    @Column(name = "gmUserId")
    private Integer groupEvaluatedPersonId;
    @Column(name = "gmName")
    private String groupName;
    @Column(name = "gmSurname")
    private String groupSurname;
}
