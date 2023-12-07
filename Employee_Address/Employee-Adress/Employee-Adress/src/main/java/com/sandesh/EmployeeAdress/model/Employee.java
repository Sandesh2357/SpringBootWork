package com.sandesh.EmployeeAdress.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotBlank(message = "first name is required")
    @Size(min = 2, max = 50,message = "First name length must be between 2 and 50 characters")
    private String employeeFirstName;
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name length must be between 2 and 50 characters")
    private String employeeLastName;
    @NotBlank(message = "Address is required")
    private String employeeAddress;

    @OneToOne
    @JoinColumn(name = "fk_addressId")
    Address address;
}
