package com.appraisaltool.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.appraisaltool.model.Office;
import com.appraisaltool.repository.OfficeRepository;
import com.appraisaltool.service.OfficeService;

@Service
public class OfficeServiceImp implements OfficeService {

	private static final Logger logger = LogManager.getLogger(OfficeServiceImp.class);

	@Autowired
	OfficeRepository officeRepository;

	/**
	 * Get one office by its id
	 */
	@Override
    public Office getOfficeById(Integer officeId) {
		logger.debug("[OfficeServiceImp] calling getOfficeById");
		Office office = officeRepository.getOne(officeId);
		return office;
	}

	/**
	 * Get one office by its ID
	 */
	@Override
	public Office getOfficeByName(@PathVariable(value = "name") String name) {

		Office office = officeRepository.getOfficeByOfficeName(name);
		return office;
	}

	/**
	 * Get all the offices 
	 */
	@Override
	public List<Office> getAllOffices() {
		logger.debug("[OfficeServiceImp] calling getAllOffices");
		return officeRepository.findAll();
	}

	/**
	 * Creates a new Office
	 */
	
	public Office createNewOffice(Office office) {
		logger.debug("[OfficeServiceImp] calling createNewOffice");
		return officeRepository.save(office);
	}
	

	public Office createNewOffice(String office) {
		Office off = new Office();
		off.setOfficeName(office);
		return createNewOffice(off);
	}
	
	
	
	/**
	 * Deletes a office by its ID
	 * @param officeId
	 */
	public void deleteOffice(Long officeId) {
	}


}
