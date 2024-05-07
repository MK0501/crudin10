package com.example.crudin10.Impl;

import com.example.crudin10.CustomException;
import com.example.crudin10.DTO.EmployeeDto;
import com.example.crudin10.EmpRepo.EmpRepo;
import com.example.crudin10.Model.Employee;
import com.example.crudin10.Service.EmpService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto getEmpById(Long id) {
        Employee employee = empRepo.findById(id).orElseThrow(
                ()-> new CustomException("no "+id));
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);
        System.out.println(employee);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmp() {
        List<Employee> employees = empRepo.findAll().stream().toList();
        return  Arrays.asList(this.modelMapper.map(employees,EmployeeDto[].class));

    }

    @Override
    public void updateEmp(Long id, EmployeeDto employeeDto) {
        Employee employee = empRepo.findById(id).get();
        empRepo.save(this.modelMapper.map(employeeDto,Employee.class));
    }
}
