package com.example.crudin10.Service;

import com.example.crudin10.DTO.EmployeeDto;

import java.util.List;

public interface EmpService {
    public EmployeeDto getEmpById(Long id);
    public List<EmployeeDto> getAllEmp();
    public void updateEmp(Long id, EmployeeDto employeeDto);
    public void addEmp(EmployeeDto employeeDto);
    public String getLoginCredentials(String empName, String empPassword);
}
