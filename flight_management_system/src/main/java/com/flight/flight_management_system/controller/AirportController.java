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
import com.flight.flight_management_system.dto.Airport;
import com.flight.flight_management_system.dto.Flight;
import com.flight.flight_management_system.service.AirportService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class AirportController {
	
	@Autowired
	AirportService airportService;
	@PostMapping("/saveAirport")
	public ResponseEntity<ResponseStructure<Airport>> saveAirport(@RequestBody Airport airport) {
		return airportService.saveAirport(airport);
	}
	
	@GetMapping("/fetchAirport")
	public ResponseEntity<ResponseStructure<Airport>> fetchAirport(int id) {
		return airportService.fetchAirport(id);
	}
	@GetMapping("/fetchAllAirport")
	public ResponseEntity<ResponseStructure< List<Airport>>> fetchAllAirport(){
		return airportService.fetchAllAirport();
	}
	
	@PutMapping("/updateAirport")
	public ResponseEntity<ResponseStructure<Airport>> updateAirport(int oldId ,@RequestBody Airport newAirport) {
		return airportService.updateAirport(oldId, newAirport);
	}
	
	@DeleteMapping("/deleteAirport")
	public ResponseEntity<ResponseStructure<Airport>> deleteAirport(int id) {
		return airportService.deleteAirport(id);
	}
	@PutMapping("/addExistingAddressToExistingAirpot")
	public ResponseEntity<ResponseStructure<Airport>> addExistingAddressToExistingAirpot(int addressId, int airpotId) {
		return airportService.addExistingAddressToExistingAirpot(addressId, airpotId);
		}
		
	   @PutMapping("/addNewAddressToExistingAirport")
		public ResponseEntity<ResponseStructure<Airport>> addNewAddressToExistingAirport(@RequestBody Address newAddress, int airpotId) {
			return airportService.addNewAddressToExistingAirport(newAddress, airpotId);
		}
	   
	   @PutMapping("/addExistingAirportToExistingFlight")
	   public ResponseEntity<ResponseStructure<Airport>> addExistingAirportToExistingFlight(int airpotId, int flightId) {
			return airportService.addExistingAirportToExistingFlight(airpotId, flightId);
		}
	   @PutMapping("/addNewFlightToExistingAirport")
	   public ResponseEntity<ResponseStructure<Airport>> addNewFlightToExistingAirport(@RequestBody Flight newFlight, int airpotId) {
			return airportService.addNewFlightToExistingAirport(newFlight, airpotId);
		}

}
