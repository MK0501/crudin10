package com.example.crudin10.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_age")
    private int empAge;

    @Column(name = "emp_password")
    private String empPassword;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    //here we are using join column so the address table primary key will be placed in the employee table
    private Address addressObj;
}
