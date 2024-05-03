package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.flight.flight_management_system.dto.Seat;
import com.flight.flight_management_system.repo.SeatRepo;

@Repository
public class SeatDao {
	@Autowired
	SeatRepo seatRepo;
	
	public Seat saveSeat( Seat seat) {
		return seatRepo.save(seat);
	}
	
	public Seat fetchsSeat(int id) {
		Optional<Seat> optional=seatRepo.findById(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	public List<Seat> fetchsAllSeat() {
		return seatRepo.findAll();
	}
	

	public Seat updateSeat(int oldId, Seat newSeat) {
		Seat seat=fetchsSeat(oldId);
		if(seat !=null)
		newSeat.setSeatId(oldId);
		return seatRepo.save(newSeat);
	}

	public Seat deleteSeat(int id) {
		Seat seat = fetchsSeat(id);
		if(seat !=null)
		seatRepo.delete(seat);
		return seat;
	}

}
