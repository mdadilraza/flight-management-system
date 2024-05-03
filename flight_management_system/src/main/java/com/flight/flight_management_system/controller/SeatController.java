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


import com.flight.flight_management_system.dto.Seat;
import com.flight.flight_management_system.service.SeatService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class SeatController {
	@Autowired
	SeatService seatService;
	@PostMapping("/saveSeat")
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(@RequestBody Seat seat) {
		return seatService.saveSeat(seat);
	}

	@GetMapping("/fetchsSeat")
	public ResponseEntity<ResponseStructure<Seat>> fetchsSeat(int id) {
		return seatService.fetchsSeat(id);
	}
	
	@GetMapping("/fetchAllSeats")
	public ResponseEntity<ResponseStructure<List<Seat>>> fetchAllSeats(){
		return seatService.fetchAllSeats();
	}

	@PutMapping("/updateSeat")
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(int oldId,@RequestBody Seat newSeat) {
		
		return seatService.updateSeat(oldId, newSeat);
	}
    @DeleteMapping("deleteSeat")
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(int id) {
		
		return seatService.deleteSeat(id);
	}

}
