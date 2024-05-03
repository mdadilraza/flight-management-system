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


import com.flight.flight_management_system.dto.Ticket;
import com.flight.flight_management_system.service.TicketService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	@PostMapping("/saveTicket")
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}
	@GetMapping("/fetchTicket")
	public ResponseEntity<ResponseStructure<Ticket>> fetchTicket(int id) {
		return ticketService.fetchTicket(id);
	}
	@GetMapping("/fetchAllTicket")
	public ResponseEntity<ResponseStructure<List<Ticket>>> fetchAllTicket() {
		return ticketService.fetchAllTicket();
	}
	
   @PutMapping("/updateTicket")
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(int oldId,@RequestBody Ticket newTicket) {
		
		return ticketService.updateTicket(oldId, newTicket);
	}
   @DeleteMapping("/deleteTicket")
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(int id) {
		
		return ticketService.deleteTicket(id);
	}


}
