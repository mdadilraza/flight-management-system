package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.PilotDao;

import com.flight.flight_management_system.dto.Pilot;
import com.flight.flight_management_system.exception.PilotIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;

@Service
public class PilotService {
	@Autowired
	PilotDao pilotDao;

	public ResponseEntity<ResponseStructure<Pilot>> savePilot(Pilot pilot) {
		ResponseStructure<Pilot> responseStructure= new ResponseStructure<Pilot>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Pilot into DataBase");
		responseStructure.setData(pilotDao.savePilot(pilot));
		
		return new ResponseEntity<ResponseStructure<Pilot>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Pilot>> fetchPilot(int id) {
		Pilot pilot= pilotDao.fetchPilot(id);
		if(pilot != null) {
		ResponseStructure<Pilot> responseStructure= new ResponseStructure<Pilot>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched  Pilot from  DataBase");
		responseStructure.setData(pilotDao.fetchPilot(id));
		
		return new ResponseEntity<ResponseStructure<Pilot>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new PilotIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Pilot>>> fetchAllPilot(){
		ResponseStructure<List<Pilot>> responseStructure= new ResponseStructure<List<Pilot>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched All  Pilot from  DataBase");
		responseStructure.setData(pilotDao.fetchAllPilot());
		
		return new ResponseEntity<ResponseStructure<List<Pilot>>>(responseStructure,HttpStatus.FOUND);
	}
	

	public ResponseEntity<ResponseStructure<Pilot>> updatePilot(int oldId, Pilot newPilot) {
		Pilot pilot= pilotDao.fetchPilot(oldId);
		if(pilot != null) {
		ResponseStructure<Pilot> responseStructure= new ResponseStructure<Pilot>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated  Pilot into DataBase");
		responseStructure.setData(pilotDao.updatePilot(oldId, newPilot));
		
		return new ResponseEntity<ResponseStructure<Pilot>>(responseStructure,HttpStatus.OK);
		}else
			throw new PilotIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Pilot>> deletePilot(int id) {
		Pilot pilot= pilotDao.fetchPilot(id);
		if(pilot != null) {
		ResponseStructure<Pilot> responseStructure= new ResponseStructure<Pilot>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  Pilot from  DataBase");
		responseStructure.setData(pilotDao.deletePilot(id));
		
		return new ResponseEntity<ResponseStructure<Pilot>>(responseStructure,HttpStatus.OK);
		}else
			throw new PilotIdNotFoundException();
	}

}
