package com.example.crudin10.Controller;

import com.example.crudin10.Model.EmpLogin;
import com.example.crudin10.Service.EmpLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class EmpLoginContoller {

    @Autowired
    private EmpLoginService empLoginService;

    @GetMapping("/hit")
    public void getLoginCredentials(@RequestBody EmpLogin empLogin){
        empLoginService.getLoginCredentials(empLogin);
    }

    @PostMapping("/save")
    public void addEmp(){
        empLoginService.addEmp();
    }
}
