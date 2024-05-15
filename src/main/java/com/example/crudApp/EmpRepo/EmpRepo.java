package com.example.crudApp.EmpRepo;

import com.example.crudApp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {
    public Optional<Employee> findByEmpName(String name);
}
