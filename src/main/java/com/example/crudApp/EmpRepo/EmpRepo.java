package com.example.crudin10.EmpRepo;

import com.example.crudin10.DTO.EmployeeDto;
import com.example.crudin10.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {
    public Optional<Employee> findByEmpName(String name);
}
