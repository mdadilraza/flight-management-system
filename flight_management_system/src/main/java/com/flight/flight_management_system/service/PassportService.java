package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.PassportDao;

import com.flight.flight_management_system.dto.Passport;
import com.flight.flight_management_system.exception.PassengerIdNotFoundException;
import com.flight.flight_management_system.exception.PassportIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;


@Service
public class PassportService {
	@Autowired
	PassportDao passportDao;
	
	public ResponseEntity<ResponseStructure<Passport>> savePassport(Passport passport) {
		ResponseStructure<Passport> responseStructure= new ResponseStructure<Passport>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Passport into DataBase");
		responseStructure.setData(passportDao.savePassport(passport));
		
		return new ResponseEntity<ResponseStructure<Passport>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Passport>> fetchPassport(int id) {
		Passport passport=passportDao.fetchPassport(id);
		if(passport != null) {
		ResponseStructure<Passport> responseStructure= new ResponseStructure<Passport>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched Passport from DataBase");
		responseStructure.setData(passportDao.fetchPassport(id));
		
		return new ResponseEntity<ResponseStructure<Passport>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new PassengerIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Passport>>> fetchAllPassport() {
		ResponseStructure<List<Passport>> responseStructure= new ResponseStructure<List<Passport>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched All Passport from DataBase");
		responseStructure.setData(passportDao.fetchAllPassport());
		
		return new ResponseEntity<ResponseStructure<List<Passport>>>(responseStructure,HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<Passport>> updatePassport(int oldId, Passport newPassport) {
		Passport passport=passportDao.fetchPassport(oldId);
		if(passport != null) {
		
		ResponseStructure<Passport> responseStructure= new ResponseStructure<Passport>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated  Passport into DataBase");
		responseStructure.setData(passportDao.updatePassport(oldId, newPassport));
		
		return new ResponseEntity<ResponseStructure<Passport>>(responseStructure,HttpStatus.OK);
		}else
			throw new PassportIdNotFoundException();
	}
	

	public ResponseEntity<ResponseStructure<Passport>> deletePassport(int id) {
		Passport passport=passportDao.fetchPassport(id);
		if(passport != null) {
		ResponseStructure<Passport> responseStructure= new ResponseStructure<Passport>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  Passport from DataBase");
		responseStructure.setData(passportDao.deletePassport(id));
		
		return new ResponseEntity<ResponseStructure<Passport>>(responseStructure,HttpStatus.OK);
		}else
			throw new PassportIdNotFoundException();
		
	}


}
