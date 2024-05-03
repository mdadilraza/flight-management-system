package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.flight.flight_management_system.dto.Address;

import com.flight.flight_management_system.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	public Address fetchAddress(int id) {
		Optional<Address> address =addressRepo.findById(id); 
		if(address.isPresent()) {
			return address.get();
		}
		else {
			return null;
		}
	}

	public List<Address> fetchAll() {
		return addressRepo.findAll();
	}

	

	public Address deleteAddress(int id) {
		Address address = fetchAddress(id);
		if(address!=null)
		addressRepo.delete(address);
		
		return address;
	}

	public Address updateAddress(int oldId, Address newAddress) {
		Address address=fetchAddress(oldId);
		
			newAddress.setAddressId(oldId);
		 addressRepo.save(newAddress);
		return address;
		
	}

}
