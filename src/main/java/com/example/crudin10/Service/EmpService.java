package com.example.crudin10.Service;

import com.example.crudin10.DTO.EmployeeDto;
import com.example.crudin10.Model.Employee;

import java.util.List;

public interface EmpService {
    public EmployeeDto getEmpById(Long id);
    public List<EmployeeDto> getAllEmp();
    public void updateEmp(Long id, EmployeeDto employeeDto);
}
