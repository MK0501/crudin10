package com.example.crudin10.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "Login")
public class EmpLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_pass")
    private String password;
}
