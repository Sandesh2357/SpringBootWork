package com.sandesh.EmployeeAdress.controller;

import com.sandesh.EmployeeAdress.model.Address;
import com.sandesh.EmployeeAdress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("addresses")
    public String addAddresses(@RequestBody List<Address> newAddresses){
        return addressService.addAddresses(newAddresses);
    }

    @GetMapping("addresses")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("address/id/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PutMapping("addresses/id/{id}")
    public String updateAddressById(@PathVariable Long id, @RequestBody Address updateAddress){
        return addressService.updateAddressById(id,updateAddress);
    }

    @DeleteMapping("address/id/{id}")
    public String removeAddressById(@PathVariable Long id){
        return addressService.removeAddressById(id);
    }
}
