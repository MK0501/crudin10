package com.example.crudin10.Impl;

import com.example.crudin10.EmpRepo.EmpLoginRepo;
import com.example.crudin10.Model.EmpLogin;
import com.example.crudin10.Service.EmpLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmpLoginServiceImpl implements EmpLoginService {

    @Autowired
    private EmpLoginRepo empLoginRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void getLoginCredentials(EmpLogin empLogin) {
        EmpLogin empLogin1 = empLoginRepo.findByName(empLogin.getName());
//        String encodedPass = passwordEncoder.encode(empLogin.getPassword());
        if(passwordEncoder.matches(empLogin.getPassword(),empLogin1.getPassword())){
            System.out.println("success");
        }
        else{
            System.out.println("noo..");
        }

    }

    @Override
    public void addEmp() {
        EmpLogin empLogin = new EmpLogin();
        empLogin.setName("koks");
        empLogin.setPassword(passwordEncoder.encode("koksMyLove"));
        empLoginRepo.save(empLogin);
    }
}
