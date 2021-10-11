package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.dto.EmployeeDto;
import com.appraisaltool.dto.EmployeeFullDetailsDto;
import com.appraisaltool.dto.domain.EmployeeFilterListType;
import com.appraisaltool.dto.domain.LookupType;
import com.appraisaltool.request.EmployeeRequest;
import com.appraisaltool.response.GGResponse;
import com.appraisaltool.response.LookupDataResults;

public interface AdministrationService {

    public LookupDataResults getLookupDataResult(LookupType lookupType);

    public LookupDataResults getLookupDataResult(LookupType lookupType, Integer id);

    public EmployeeFullDetailsDto getEmployeeById(Integer id);

    public EmployeeDto getEmployeeSummaryById(Integer id);

    public List<EmployeeDto> getAllEmployee();

    public EmployeeFullDetailsDto createEmployee(EmployeeRequest employeeRequest);

    public EmployeeFullDetailsDto updateEmployee(EmployeeRequest employeeRequest);

    public List<EmployeeDto> getEmployeeSummaryByOfficeId(Integer officeId);

    public List<EmployeeDto> getEmployeeByFilter(EmployeeFilterListType employeeFilterList);

    public GGResponse<EmployeeFullDetailsDto> login(String email, String password);

    public Boolean encrypt(boolean encrypt);

}
