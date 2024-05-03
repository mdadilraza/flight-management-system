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

import com.flight.flight_management_system.dto.Airhosters;

import com.flight.flight_management_system.dto.Flight;
import com.flight.flight_management_system.dto.Passenger;
import com.flight.flight_management_system.dto.Pilot;
import com.flight.flight_management_system.dto.Seat;
import com.flight.flight_management_system.service.FlightService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class FlightController {

	@Autowired
	FlightService flightService;

	@PostMapping("/saveFlight")
	public ResponseEntity<ResponseStructure<Flight>> saveFlight(@RequestBody Flight flight) {
		return flightService.saveFlight(flight);
	}

	@GetMapping("/fetchFlight")
	public ResponseEntity<ResponseStructure<Flight>> fetchFlight(int id) {
		return flightService.fetchFlight(id);
	}
	@GetMapping("/fetchAllFlight")
	public ResponseEntity<ResponseStructure< List<Flight>>> fetchAllFlight() {
		return flightService.fetchAllFlight();
	}

	@PutMapping("/updateFlight")
	public ResponseEntity<ResponseStructure<Flight>> updateFlight(int oldId, @RequestBody Flight newFlight) {
		return flightService.updateFlight(oldId, newFlight);
	}

	@DeleteMapping("/deleteFlight")
	public ResponseEntity<ResponseStructure<Flight>> deleteFlight(int id) {
		return flightService.deleteFlight(id);
	}

	@PutMapping("/addExistingFlightToExistingPilot")
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingPilot(int flightId, int pilotId) {
		return flightService.addExistingFlightToExistingPilot(flightId, pilotId);
	}

	@PutMapping("/addNewFlightToExistingPilot")
	public ResponseEntity<ResponseStructure<Flight>> addNewFlightToExistingPilot(@RequestBody Pilot newPilot, int flightId) {
		return flightService.addNewFlightToExistingPilot(newPilot, flightId);
	}

	@PutMapping("/addExistingFlightToExistingSeat")
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingSeat(int flightId, int seatId) {
		return flightService.addExistingFlightToExistingSeat(flightId, seatId);
	}

	@PutMapping("/addNewSeatToExistingFlight")
	public ResponseEntity<ResponseStructure<Flight>> addNewSeatToExistingFlight(@RequestBody Seat newSeat, int flightId) {
		return flightService.addNewSeatToExistingFlight(newSeat, flightId);
	}

	@PutMapping("/addExistingFlightToExistingPassenger")
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingPassenger(int passengerId, int flightId) {
		return flightService.addExistingFlightToExistingPassenger(passengerId, flightId);
	}

	@PutMapping("/addNewPassengerToExistingFlight")
	public ResponseEntity<ResponseStructure<Flight>> addNewPassengerToExistingFlight(@RequestBody Passenger newPassenger, int flightId) {
		return flightService.addNewPassengerToExistingFlight(newPassenger, flightId);
	}

	@PutMapping("/addExistingFlightToExistingAirhosters")
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingAirhosters(int flightId, int airhostersId) {
		return flightService.addExistingFlightToExistingAirhosters(flightId, airhostersId);
	}
	
	@PutMapping("/addNewAirhostersToExistingFlight")
	public ResponseEntity<ResponseStructure<Flight>> addExistingFlightToExistingAirhosters(@RequestBody Airhosters newAirhosters, int flightId) {
		return flightService.addNewAirhostersToExistingFlight(newAirhosters, flightId);
	}

}
