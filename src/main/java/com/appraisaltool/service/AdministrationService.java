package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.dto.EmployeeDto;
import com.appraisaltool.dto.domain.LookupType;
import com.appraisaltool.request.EmployeeRequest;
import com.appraisaltool.response.GGResponse;
import com.appraisaltool.response.LookupDataResults;

public interface AdministrationService {

    public LookupDataResults getLookupDataResult(LookupType lookupType);

    public LookupDataResults getLookupDataResult(LookupType lookupType, Integer id);

    public EmployeeDto getEmployeeById(Integer id);

    public EmployeeDto getEmployeeSummaryById(Integer id);

    public EmployeeDto createEmployee(EmployeeRequest employeeRequest);

    public EmployeeDto updateEmployee(EmployeeRequest employeeRequest);

    public List<EmployeeDto> getEmployeeSummaryByOfficeId(Integer officeId);

    public GGResponse<EmployeeDto> login(String email, String password);
}
