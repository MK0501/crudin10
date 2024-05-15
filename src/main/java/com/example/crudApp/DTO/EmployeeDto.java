package com.example.crudApp.DTO;

import com.example.crudApp.Model.Address;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

@Data
public class EmployeeDto {
    @NotNull(message = "employee name is mandatory")
    @NotBlank(message = "employee name cannot be blank")
    private String name;
    @Positive(message = "Invalid age")
    private int age;
    private String password;
    private Address address;
}
