package com.example.crudApp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    //here mapped by refers to the object of Address entity created in the Employee entity
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "addressObj")
    private Employee employee;

    //if you want the employee table's primary key to be in the address table then
    //@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JoinColumn(name = "emp_id")
    //private Employee employee

    //if you need emp primary in address entity and address primary key in employee
    //then specify @JOinColumn in both entity

}
