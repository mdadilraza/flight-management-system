package com.flight.flight_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.flight_management_system.dto.Address;
import com.flight.flight_management_system.service.AddressService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@GetMapping("/fetchAddress")
	public ResponseEntity<ResponseStructure<Address>> fetchAddress(int id) {
		return addressService.fetchAddress(id);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Address>>> fetchAll() {
		return addressService.fetchAll();
	}

	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int oldId, @RequestBody Address newAddress) {
		//newAddress.setAddressId(oldId);
		return addressService.updateAddress(oldId, newAddress);
	}

	@DeleteMapping("/deleteAddress")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {

		return addressService.deleteAddress(id);
	}

	
}
