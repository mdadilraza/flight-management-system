package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.SeatDao;

import com.flight.flight_management_system.dto.Seat;
import com.flight.flight_management_system.exception.SeatIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;

@Service
public class SeatService {
	@Autowired
	SeatDao seatDao;
	
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(Seat seat) {
		ResponseStructure<Seat> responseStructure= new ResponseStructure<Seat>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Seat into DataBase");
		responseStructure.setData(seatDao.saveSeat(seat));
		
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.CREATED);
	}

	
	public ResponseEntity<ResponseStructure<Seat>> fetchsSeat(int id) {
		Seat seat = seatDao.fetchsSeat(id);
		if(seat != null) {
		
		ResponseStructure<Seat> responseStructure= new ResponseStructure<Seat>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully fetched seat  from  DataBase");
		responseStructure.setData(seatDao.fetchsSeat(id));
		
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.CREATED);
		}else
			throw new SeatIdNotFoundException();
		
	}
	
	public ResponseEntity<ResponseStructure<List<Seat>>> fetchAllSeats(){
		ResponseStructure<List<Seat>> responseStructure= new ResponseStructure<List<Seat>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched seat  from  DataBase");
		responseStructure.setData(seatDao.fetchsAllSeat());
		
		return new ResponseEntity<ResponseStructure<List<Seat>>>(responseStructure,HttpStatus.FOUND);
	}
	

	public  ResponseEntity<ResponseStructure<Seat>>updateSeat(int oldId, Seat newSeat) {
		Seat seat = seatDao.fetchsSeat(oldId);
		if(seat != null) {
		ResponseStructure<Seat> responseStructure= new ResponseStructure<Seat>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully inserted Pilot into DataBase");
		responseStructure.setData(seatDao.updateSeat(oldId, newSeat));
		
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.OK);
		}else
			throw new SeatIdNotFoundException();
		
		
	}

	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(int id) {
		Seat seat = seatDao.fetchsSeat(id);
		if(seat != null) {
		ResponseStructure<Seat> responseStructure= new ResponseStructure<Seat>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  Pilot from  DataBase");
		responseStructure.setData(seatDao.deleteSeat(id));
		
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.OK);
		}else {
			throw new SeatIdNotFoundException();
		}
	}
}
