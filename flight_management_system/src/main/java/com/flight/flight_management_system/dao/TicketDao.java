package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.flight_management_system.dto.Ticket;
import com.flight.flight_management_system.repo.TicketRepo;

@Repository
public class TicketDao {
	
	@Autowired 
	TicketRepo ticketRepo;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	public Ticket fetchTicket(int id) {
		Optional<Ticket> optional= ticketRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public List<Ticket> fetchAllTicket() {
		return ticketRepo.findAll();
	}
	

	public Ticket updateTicket(int oldId, Ticket newTicket) {
		Ticket ticket=fetchTicket(oldId);
		if(ticket != null)
		newTicket.setTicketId(oldId);
		return ticketRepo.save(newTicket);
	}

	public Ticket deleteTicket(int id) {
		Ticket ticket = fetchTicket(id);
		if(ticket != null)
		ticketRepo.delete(ticket);;
		return ticket;
	}

}
