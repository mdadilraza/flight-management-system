package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.FlightDao;
import com.flight.flight_management_system.dto.Airhosters;
import com.flight.flight_management_system.dto.Flight;
import com.flight.flight_management_system.dto.Passenger;
import com.flight.flight_management_system.dto.Pilot;
import com.flight.flight_management_system.dto.Seat;
import com.flight.flight_management_system.exception.FlightIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;


@Service
public class FlightService {
	
	@Autowired
	FlightDao flightDao;
	
	public ResponseEntity<ResponseStructure<Flight>> saveFlight(Flight flight) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Flight into DataBase");
		responseStructure.setData(flightDao.saveFlight(flight));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.CREATED);
	}

	

	public ResponseEntity<ResponseStructure<Flight>> fetchFlight(int id) {
		Flight flight=flightDao.fetchFlight(id);
		
		if(flight != null) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Fetched  Flight from  DataBase");
		responseStructure.setData(flightDao.fetchFlight(id));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new FlightIdNotFoundException();
		}
		
	}
	
	public ResponseEntity<ResponseStructure< List<Flight>>> fetchAllFlight() {
		ResponseStructure<List<Flight>> responseStructure= new ResponseStructure<List<Flight>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Fetched All Flight from  DataBase");
		responseStructure.setData(flightDao.fetchAllFlight());
		
		return new ResponseEntity<ResponseStructure<List<Flight>>>(responseStructure,HttpStatus.FOUND);
		
		
	}

	public ResponseEntity<ResponseStructure<Flight>> updateFlight(int oldId, Flight newFlight) {
		Flight flight=flightDao. fetchFlight(oldId);
		if(flight != null) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Updated  Flight into  DataBase");
		responseStructure.setData(flightDao.updateFlight(oldId, newFlight));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
		}else {
			throw new FlightIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Flight>> deleteFlight(int id) {
		Flight flight=flightDao. fetchFlight(id);
		if(flight != null) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  Flight from  DataBase");
		responseStructure.setData(flightDao.deleteFlight(id));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
		}else {
			throw new FlightIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingPilot(int flightId, int pilotId) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added   ExitingFlight to Existing Pilot");
		responseStructure.setData(flightDao.addExistingFlightToExistingPilot( flightId,pilotId));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Flight>> addNewFlightToExistingPilot(Pilot newPilot, int flightId) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added   Pilot to Existing Flight");
		responseStructure.setData(flightDao.addNewFlightToExistingPilot(newPilot, flightId));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingSeat(int flightId, int seatId) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added   ExitingFlight to Existing Seat");
		responseStructure.setData(flightDao.addExistingFlightToExistingSeat(flightId, seatId));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Flight>> addNewSeatToExistingFlight(Seat newSeat, int flightId) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added NewSeat to Existing Flight");
		responseStructure.setData(flightDao.addNewSeatToExistingFlight(newSeat, flightId));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingPassenger(int passengerId, int flightId) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added   ExitingPassenger  to Existing Flight");
		responseStructure.setData(flightDao.addExistingFlightToExistingPassenger(passengerId, flightId));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Flight>> addNewPassengerToExistingFlight(Passenger newPassenger, int flightId) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added   new Passenger to Existing Flight");
		responseStructure.setData(flightDao.addNewPassengerToExistingFlight(newPassenger, flightId));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingAirhosters(int flightId, int airhostersId) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added   ExitingFlight to Existing Airhosters");
		responseStructure.setData(flightDao.addExistingFlightToExistingAirhosters(flightId, airhostersId));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Flight>> addNewAirhostersToExistingFlight(Airhosters newAirhosters, int flightId) {
		ResponseStructure<Flight> responseStructure= new ResponseStructure<Flight>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added   New Airhosters to Existing Flight");
		responseStructure.setData(flightDao.addNewAirhostersToExistingFlight(newAirhosters, flightId));
		
		return new ResponseEntity<ResponseStructure<Flight>>(responseStructure,HttpStatus.OK);
	}
	
}
