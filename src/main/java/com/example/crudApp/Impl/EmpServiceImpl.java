package com.example.crudApp.Impl;

import com.example.crudApp.CustomException;
import com.example.crudApp.DTO.EmployeeDto;
import com.example.crudApp.EmpRepo.EmpRepo;
import com.example.crudApp.Model.Address;
import com.example.crudApp.Model.Employee;
import com.example.crudApp.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
//        EmployeeDto employeeDto1 = employeeDto;
        //encoding the passward before saving into the db
//        employeeDto1.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        Address address = employeeDto.getAddress();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Employee emp = new Employee();
        emp.setEmpName(employeeDto.getName());
        emp.setEmpPassword(employeeDto.getPassword());
        emp.setEmpAge(employeeDto.getAge());
        emp.setAddressObj(address);
        //setting emp of address only makes the primary key of employee inserted to foriegn key in address table
        address.setEmployee(emp);
        empRepo.save(emp);
    }

    @Override
    public String getLoginCredentials(String empName, String empPassword) {
        log.info("validating login credentials");
        Employee emp = empRepo.findByEmpName(empName).orElseThrow(()-> new CustomException("no employee with name :"+empName));
                    if (passwordEncoder.matches(empPassword, emp.getEmpPassword())) {
                        log.info("Login Success");
                        return "Login Success!";
                    } else {
                        log.warn("Invalid Password");
                        return "Invalid Password!";
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
