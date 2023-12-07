package com.sandesh.EmployeeAdress.repository;

import com.sandesh.EmployeeAdress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<Address, Long> {
}
