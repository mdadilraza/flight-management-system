package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.flight.flight_management_system.dao.PassengerDao;
import com.flight.flight_management_system.dto.Food;
import com.flight.flight_management_system.dto.Passenger;
import com.flight.flight_management_system.dto.Passport;
import com.flight.flight_management_system.dto.Ticket;
import com.flight.flight_management_system.exception.PassengerIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;

@Service
public class PassengerService {
	@Autowired
	PassengerDao passengerDao;
	public ResponseEntity<ResponseStructure<Passenger>> savePassenger (Passenger passenger) {
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Passenger into DataBase");
		responseStructure.setData(passengerDao.savePassenger(passenger));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Passenger>> fetchPassenger(int id) {
		Passenger passenger=passengerDao.fetchPassenger(id);
		if(passenger != null) {
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched  Passenger from DataBase");
		responseStructure.setData(passengerDao.fetchPassenger(id));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.FOUND);
		}else
			throw new PassengerIdNotFoundException();
		
	
	}
	
	public ResponseEntity<ResponseStructure< List<Passenger>>> fetchAllPassenger(){
		ResponseStructure<List<Passenger>> responseStructure= new ResponseStructure<List<Passenger>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched All Passenger from DataBase");
		responseStructure.setData(passengerDao.fetchAllPassenger());
		
		return new ResponseEntity<ResponseStructure<List<Passenger>>>(responseStructure,HttpStatus.FOUND);
		
		
	}

	public ResponseEntity<ResponseStructure<Passenger>> updatePassenger(int oldId, Passenger newPassenger) {
		Passenger passenger=passengerDao.fetchPassenger(oldId);
		if(passenger != null) {
		
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated Passenger into DataBase");
		responseStructure.setData(passengerDao.updatePassenger(oldId, newPassenger));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);
		}else
		throw new PassengerIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Passenger>> deletePassenger(int id) {
		Passenger passenger=passengerDao.fetchPassenger(id);
		if(passenger != null) {
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  Passenger from DataBase");
		responseStructure.setData(passengerDao.deletePassenger(id));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);
		}else {
			throw new PassengerIdNotFoundException();
		}
	}
	
	
	public   ResponseEntity<ResponseStructure<Passenger>> addExistingPassengerToExistingTicket(int passengerId, int ticketId) {
		
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully AddedExisting  Passenger With Existing Ticket");
		responseStructure.setData(passengerDao.addExistingPassengerToExistingTicket(passengerId, ticketId));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Passenger>> addNewTicketToExistingPassenger( Ticket newTicket,int  passengerId) {
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully addedNew Ticket to existing Passenger ");
		responseStructure.setData(passengerDao.addNewTicketToExistingPassenger(newTicket, passengerId));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);
	}
	
	
	public   ResponseEntity<ResponseStructure<Passenger>> addExistingPassengerToExistingPassport(int passengerId, int passportId) {
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added Existing Passport to Existing  Passenger ");
		responseStructure.setData(passengerDao.addExistingPassengerToExistingPassport(passengerId, passportId));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Passenger>> addNewPassportToExistingPassenger( Passport newPassport,int  passengerId) {
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added New Passport to Existing  Passenger");
		responseStructure.setData(passengerDao.addNewPassportToExistingPassenger(newPassport, passengerId));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Passenger>> addExistingPassengerToExistingFood(int passengerId, int foodId) {
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added Existing  Passenger to Existing food");
		responseStructure.setData(passengerDao.addExistingPassengerToExistingFood(passengerId, foodId));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Passenger>> addNewFoodToExistingPassenger(Food newFood , int passengerId) {
		ResponseStructure<Passenger> responseStructure= new ResponseStructure<Passenger>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added New Food to Existing  ");
		responseStructure.setData(passengerDao.addNewFoodToExistingPassenger(newFood, passengerId));
		
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);
	}
	
	
	}


