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


import com.flight.flight_management_system.dto.Passport;
import com.flight.flight_management_system.service.PassportService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class PassportController {

	@Autowired
	PassportService passportService;
	@PostMapping("/savePassport")
	public ResponseEntity<ResponseStructure<Passport>> savePassport( @RequestBody Passport passport) {
		return passportService.savePassport(passport);
	}
	@GetMapping("/fetchPassport")
	public ResponseEntity<ResponseStructure<Passport>> fetchPassport(int id) {
		return passportService.fetchPassport(id);
	}
	@GetMapping("/fetchAllPassport")
	public ResponseEntity<ResponseStructure<List<Passport>>> fetchAllPassport() {
		return passportService.fetchAllPassport();
	}
	
    @PutMapping("/updatePassport")
	public ResponseEntity<ResponseStructure<Passport>> updatePassport(int oldId,@RequestBody Passport newPassport) {
	return passportService.updatePassport(oldId, newPassport);
	}
	
   @DeleteMapping("/deletePassport")
	public ResponseEntity<ResponseStructure<Passport>> deletePassport(int id) {
	return passportService.deletePassport(id);
		
	}
}
