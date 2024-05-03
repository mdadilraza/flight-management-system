package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.flight.flight_management_system.dto.Passport;
import com.flight.flight_management_system.repo.PassportRepo;

@Repository
public class PassportDao {
	@Autowired
	PassportRepo passportRepo;
	
	public Passport savePassport(Passport passport) {
		return passportRepo.save(passport);
	}
	
	public Passport fetchPassport(int id) {
	Optional<Passport> optional	= passportRepo.findById(id); 
	if(optional.isPresent()) {
		return optional.get();
	}
	return null;
	}
	
	public List<Passport> fetchAllPassport() {
		return passportRepo.findAll();
	}

	public Passport updatePassport(int oldId, Passport newPassport) {
		Passport passport=fetchPassport(oldId);
		if(passport !=null)
		newPassport.setPassportId(oldId);
		return passportRepo.save(newPassport);
	}

	public Passport deletePassport(int id) {
		Passport passport = fetchPassport(id);
		if(passport != null)
		passportRepo.delete(passport);;
		return passport;
	}

}
