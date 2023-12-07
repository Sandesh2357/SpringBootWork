package com.sandesh.EmployeeAdress.controller;

import com.sandesh.EmployeeAdress.model.Employee;
import com.sandesh.EmployeeAdress.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("employees")
    public String addEmployees(@RequestBody List<Employee> newEmployees){
        return employeeService.addEmployees(newEmployees);
    }

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("employee/id/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("employee/id/{id}")
    public String updateEmployById(@PathVariable Long id, @RequestBody Employee updateEmployee){
        return employeeService.updateEmployById(id,updateEmployee);
    }
       @DeleteMapping("employee/id/{id}")
    public String removeEmployeeById(Long id){
        return employeeService.removeEmployeeById(id);
    }
}
