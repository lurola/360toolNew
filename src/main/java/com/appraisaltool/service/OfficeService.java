package com.appraisaltool.service;

import java.util.List;

import com.appraisaltool.model.Office;

public interface OfficeService {
	

	Office getOfficeByName(String name);

	List<Office> getAllOffices();

	Office getOfficeById(Long employeeId);

	Office createNewOffice(Office office);


}
