package com.example.crudin10.Impl;

import com.example.crudin10.CustomException;
import com.example.crudin10.DTO.EmployeeDto;
import com.example.crudin10.EmpRepo.EmpRepo;
import com.example.crudin10.Model.Employee;
import com.example.crudin10.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

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

    @Override
    public void addEmp(EmployeeDto employeeDto) {
        EmployeeDto employeeDto1 = employeeDto;
        employeeDto1.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Employee emp = modelMapper.map(employeeDto1,Employee.class);
        empRepo.save(emp);
    }

    @Override
    public void getLoginCredentials(String empName, String empPassword) {
        log.info("validating login credentials");
        Employee emp = empRepo.findByEmpName(empName).orElseThrow(()-> new CustomException("no employee with name :"+empName));
                    if (passwordEncoder.matches(empPassword, emp.getEmpPassword())) {
                        log.info("Login Success");
                    } else {
                        log.warn("Invalid Password");
                    }

//                    or we can do like thi
        /* emp.ifPresentOrElse(
//                (e)->{
                    if (passwordEncoder.matches(empPassword, emp.getEmpPassword())) {
                        System.out.println("success");
                    } else {
                        System.out.println("noo..");
                    }
//                },
//                ()->{
//                    new CustomException("")
//                }
//        );*/

    }
}
