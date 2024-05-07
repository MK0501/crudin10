package com.example.crudin10.Controller;

import com.example.crudin10.DTO.EmployeeDto;
import com.example.crudin10.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmpById(@PathVariable Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Info", "getting student by id");
        httpHeaders.add("description", "fetching from db");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(empService.getEmpById(id));
    }

    @GetMapping("/getAll")
    public List<EmployeeDto> getAllEmp(){
        return empService.getAllEmp();
    }

    @PutMapping("/update/{id}")
    public void updateEmpById(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        empService.updateEmp(id, employeeDto);
    }

    @GetMapping("/login")
    //use form data in post man to set empName and empPassword
    public ResponseEntity<String> validateLoginCredentials(String empName, String empPassword){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Info","Validating Login Credentials");
        httpHeaders.add("description","validating employee name and password");
        empService.getLoginCredentials(empName, empPassword);
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body("login validated!");

    }

    @PostMapping("/addEmp")
    public ResponseEntity<String> addEmp(@RequestBody EmployeeDto employeeDto){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Info","Adding Employee");
        httpHeaders.add("description","inserting new Employee to the database");
        empService.addEmp(employeeDto);
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body("Employee Added Successfully");

    }
}
