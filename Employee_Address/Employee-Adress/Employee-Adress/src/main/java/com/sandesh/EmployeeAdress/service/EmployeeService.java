package com.sandesh.EmployeeAdress.service;

import com.sandesh.EmployeeAdress.model.Address;
import com.sandesh.EmployeeAdress.model.Employee;
import com.sandesh.EmployeeAdress.repository.IAddressRepo;
import com.sandesh.EmployeeAdress.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;
    @Autowired
    IAddressRepo iAddressRepo;

    public String addEmployees(List<Employee> newEmployees) {
        for(Employee emp : newEmployees){
            Address add = emp.getAddress();
            iAddressRepo.save(add);
            iEmployeeRepo.save(emp);
        }
        return "emply added!!!";

    }

    public List<Employee> getEmployees() {
        return (List<Employee>) iEmployeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return iEmployeeRepo.findById(id).orElse(null);
    }


    public String updateEmployById(Long id, Employee updateEmployee) {
        Employee ExistingEmployee = iEmployeeRepo.findById(id).orElse(null);
        ExistingEmployee.setEmployeeAddress(updateEmployee.getEmployeeAddress());
        ExistingEmployee.setEmployeeFirstName(updateEmployee.getEmployeeFirstName());
        ExistingEmployee.setEmployeeLastName(updateEmployee.getEmployeeLastName());
        iEmployeeRepo.save(ExistingEmployee);
        return "employee details updated!!!";
    }

    public String removeEmployeeById(Long id) {
        iEmployeeRepo.deleteById(id);
        return "employee removed";
    }
}

