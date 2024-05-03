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

import com.flight.flight_management_system.service.AirhostersService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class AirhostersController {
	@Autowired
	AirhostersService airhostersService;

	@PostMapping("/saveAirhosters")
	public ResponseEntity<ResponseStructure<Airhosters>> saveAirhosters(@RequestBody Airhosters airhosters) {
		return airhostersService.saveAirhosters(airhosters);
	}

	@GetMapping("/fetchAirhosters")
	public ResponseEntity<ResponseStructure<Airhosters>> fetchAirhosters(int id) {
		return airhostersService.fetchAirhosters(id);

	}
	
	@GetMapping("/fetchAllAirhosters")
	public ResponseEntity<ResponseStructure<List<Airhosters>>> fetchAll() {
		return airhostersService.fetchAll();

	}
	
	

	@PutMapping("/updateAirhosters")
	public ResponseEntity<ResponseStructure<Airhosters>> updateAirhosters(int oldId,@RequestBody Airhosters newAirhosters) {
		return airhostersService.updateAirhosters(oldId, newAirhosters);
	}

	@DeleteMapping("/deleteAirhosters")
	public ResponseEntity<ResponseStructure<Airhosters>> deleteAirhosters(int id) {
		return airhostersService.deleteAirhosters(id);
	}

}
