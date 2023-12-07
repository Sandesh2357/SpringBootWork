package com.sandesh.EmployeeAdress.repository;

import com.sandesh.EmployeeAdress.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Long> {
}
