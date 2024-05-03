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

import com.flight.flight_management_system.dto.Pilot;
import com.flight.flight_management_system.service.PilotService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class PilotController {
	@Autowired
	PilotService pilotService;

	@PostMapping("/savePilot")
	public ResponseEntity<ResponseStructure<Pilot>> savePilot(@RequestBody Pilot pilot) {
		return pilotService.savePilot(pilot);
	}

	@GetMapping("/fetchPilot")
	public ResponseEntity<ResponseStructure<Pilot>> fetchPilot(int id) {
		return pilotService.fetchPilot(id);
	}
	@GetMapping("/fetchAllPilot")
	public ResponseEntity<ResponseStructure<List<Pilot>>> fetchAllPilot(){
		return pilotService.fetchAllPilot();
	}

	@PutMapping("/updatePilot")
	public ResponseEntity<ResponseStructure<Pilot>> updatePilot(int oldId, @RequestBody Pilot newPilot) {
		return pilotService.updatePilot(oldId, newPilot);
	}

	@DeleteMapping("/deletePilot")
	public ResponseEntity<ResponseStructure<Pilot>> deletePilot(int id) {
		return pilotService.deletePilot(id);
	}

}
