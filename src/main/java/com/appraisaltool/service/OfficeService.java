package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.model.Office;

public interface OfficeService {

    public Office getOfficeByName(String name);

    public List<Office> getAllOffices();

    public Office getOfficeById(Integer employeeId);

    public Office createNewOffice(Office office);

    public Office createNewOffice(String office);



}
