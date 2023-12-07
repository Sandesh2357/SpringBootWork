package com.sandesh.EmployeeAdress.service;

import com.sandesh.EmployeeAdress.model.Address;
import com.sandesh.EmployeeAdress.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepo iAddressRepo;

    public String addAddresses(List<Address> newAddresses) {
        iAddressRepo.saveAll(newAddresses);
        return "addresses added!!!";
    }

    public List<Address> getAllAddresses() {
        return (List<Address>) iAddressRepo.findAll();
    }

    public Address getAddressById(Long id) {
        return iAddressRepo.findById(id).orElse(null);
    }

    public String updateAddressById(Long id, Address updateAddress) {
        Address existingAddress = iAddressRepo.findById(id).orElse(null);
        existingAddress.setCity(updateAddress.getCity());
        existingAddress.setState(updateAddress.getState());
        existingAddress.setCity(updateAddress.getStreet());
        iAddressRepo.save(existingAddress);
        return "address updated";
    }

    public String removeAddressById(Long id) {
        iAddressRepo.deleteById(id);
        return "Address deleted";
    }
}
