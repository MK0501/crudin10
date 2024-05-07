package com.example.crudin10.EmpRepo;

import com.example.crudin10.Model.EmpLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpLoginRepo extends JpaRepository<EmpLogin,Long> {

    public EmpLogin findByName(String name);
}
