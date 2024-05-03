package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.TicketDao;

import com.flight.flight_management_system.dto.Ticket;
import com.flight.flight_management_system.exception.TicketIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;

@Service
public class TicketService {
	@Autowired
	TicketDao ticketDao;

	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket) {
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Ticket into DataBase");
		responseStructure.setData(ticketDao.saveTicket(ticket));

		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Ticket>> fetchTicket(int id) {
		Ticket ticket = ticketDao.fetchTicket(id);
		if (ticket != null) {
			ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully fetched  Ticket from DataBase");
			responseStructure.setData(ticketDao.fetchTicket(id));

			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new TicketIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Ticket>>> fetchAllTicket() {
		ResponseStructure<List<Ticket>> responseStructure = new ResponseStructure<List<Ticket>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched  Ticket from DataBase");
		responseStructure.setData(ticketDao.fetchAllTicket());

		return new ResponseEntity<ResponseStructure<List<Ticket>>>(responseStructure, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(int oldId, Ticket newTicket) {
		Ticket ticket = ticketDao.fetchTicket(oldId);
		if (ticket != null) {
			ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated  Ticket into DataBase");
			responseStructure.setData(ticketDao.updateTicket(oldId, newTicket));

			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.OK);
		} else
			throw new TicketIdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(int id) {
		Ticket ticket = ticketDao.fetchTicket(id);
		if (ticket != null) {
			ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully inserted Ticket into DataBase");
			responseStructure.setData(ticketDao.deleteTicket(id));

			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.OK);
		} else
			throw new TicketIdNotFoundException();
	}

}
