package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.AirportDao;
import com.flight.flight_management_system.dto.Address;
import com.flight.flight_management_system.dto.Airport;
import com.flight.flight_management_system.dto.Flight;
import com.flight.flight_management_system.exception.AirportIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;

@Service
public class AirportService {
	@Autowired
	AirportDao airportDao;
	
	public ResponseEntity<ResponseStructure<Airport>> saveAirport(Airport airport) {
		ResponseStructure<Airport> responseStructure= new ResponseStructure<Airport>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Airport into DataBase");
		responseStructure.setData(airportDao.saveAirport(airport));
		
		return new ResponseEntity<ResponseStructure<Airport>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Airport>> fetchAirport(int id) {
		Airport airport= airportDao.fetchAirport(id);
		
		if(airport != null) {
		ResponseStructure<Airport> responseStructure= new ResponseStructure<Airport>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Fetched  Airport from DataBase");
		responseStructure.setData(airportDao.fetchAirport(id));
		
		return new ResponseEntity<ResponseStructure<Airport>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new AirportIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure< List<Airport>>> fetchAllAirport(){
		ResponseStructure<List<Airport>> responseStructure= new ResponseStructure<List<Airport>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Fetched All Airport from DataBase");
		responseStructure.setData(airportDao.fetchAllAirport());
		
		return new ResponseEntity<ResponseStructure<List<Airport>>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Airport>> updateAirport(int oldId , Airport newAirport) {
		Airport airport=airportDao.fetchAirport(oldId);
		if(airport !=null) {
		ResponseStructure<Airport> responseStructure= new ResponseStructure<Airport>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Updated  Airport into DataBase");
		responseStructure.setData(airportDao.updateAirport(oldId, newAirport));
		
		return new ResponseEntity<ResponseStructure<Airport>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new AirportIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Airport>> deleteAirport(int id) {
		Airport airport=airportDao.fetchAirport(id);
		if(airport !=null) {
		ResponseStructure<Airport> responseStructure= new ResponseStructure<Airport>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  Airport from DataBase");
		responseStructure.setData(airportDao.deleteAirport(id));
		
		return new ResponseEntity<ResponseStructure<Airport>>(responseStructure,HttpStatus.OK);
		}else {
			throw new AirportIdNotFoundException();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Airport>> addExistingAddressToExistingAirpot(int addressId, int airpotId) {
		ResponseStructure<Airport> responseStructure= new ResponseStructure<Airport>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added Address to  Airport into DataBase");
		responseStructure.setData(airportDao.addExistingAddressToExistingAirpot(addressId, airpotId));
		
		return new ResponseEntity<ResponseStructure<Airport>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Airport>> addNewAddressToExistingAirport(Address newAddress, int airpotId) {
		ResponseStructure<Airport> responseStructure= new ResponseStructure<Airport>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added new  Address to Existing  Airport ");
		responseStructure.setData(airportDao.addNewAddressToExistingAirport(newAddress, airpotId)); 
		
		return new ResponseEntity<ResponseStructure<Airport>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Airport>> addExistingAirportToExistingFlight(int airpotId, int flightId) {
		ResponseStructure<Airport> responseStructure= new ResponseStructure<Airport>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added Existing Address to Existing  Airport ");
		responseStructure.setData(airportDao.addExistingAirportToExistingFlight(airpotId, flightId));
		
		return new ResponseEntity<ResponseStructure<Airport>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Airport>> addNewFlightToExistingAirport(Flight newFlight, int airpotId) {
		ResponseStructure<Airport> responseStructure= new ResponseStructure<Airport>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added New Flight to  Airport ");
		responseStructure.setData(airportDao.addNewFlightToExistingAirport(newFlight, airpotId));
		
		return new ResponseEntity<ResponseStructure<Airport>>(responseStructure,HttpStatus.OK);
	}
	
}
