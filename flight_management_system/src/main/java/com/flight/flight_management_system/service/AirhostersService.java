package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.AirhostersDao;

import com.flight.flight_management_system.dto.Airhosters;
import com.flight.flight_management_system.exception.AirhostersIdNotFoundException;
import com.flight.flight_management_system.exception.AirportIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;

@Service
public class AirhostersService {
	@Autowired
	AirhostersDao airhostersDao;

	public ResponseEntity<ResponseStructure<Airhosters>> saveAirhosters(Airhosters airhosters) {
		ResponseStructure<Airhosters> responseStructure= new ResponseStructure<Airhosters>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Address into DataBase");
		responseStructure.setData(airhostersDao.saveAirhosters(airhosters));
		
		return new ResponseEntity<ResponseStructure<Airhosters>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Airhosters>>  fetchAirhosters(int id) {
		Airhosters airhosters= airhostersDao.fetchAirhosters(id);
		if(airhosters !=null) {
		
		ResponseStructure<Airhosters> responseStructure= new ResponseStructure<Airhosters>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched  Address from  DataBase");
		responseStructure.setData(airhostersDao.fetchAirhosters(id));
		
		return new ResponseEntity<ResponseStructure<Airhosters>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new AirhostersIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure< List<Airhosters>>> fetchAll() {
		ResponseStructure<List<Airhosters>> responseStructure= new ResponseStructure<List<Airhosters>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched  Address from  DataBase");
		responseStructure.setData(airhostersDao.fetchAll());
		
		return new ResponseEntity<ResponseStructure<List<Airhosters>>>(responseStructure,HttpStatus.FOUND);
		
		
	}
	

	public ResponseEntity<ResponseStructure<Airhosters>> updateAirhosters(int oldId, Airhosters newAirhosters) {
		Airhosters airhosters= airhostersDao.fetchAirhosters(oldId);
		if(airhosters !=null) {
		ResponseStructure<Airhosters> responseStructure= new ResponseStructure<Airhosters>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated  Address from DataBase");
		responseStructure.setData(airhostersDao.updateAirhosters(oldId, newAirhosters));
		
		return new ResponseEntity<ResponseStructure<Airhosters>>(responseStructure,HttpStatus.OK);
		}
		else 
			throw new AirhostersIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Airhosters>> deleteAirhosters(int id) {
		Airhosters airhosters= airhostersDao.fetchAirhosters(id);
		if(airhosters !=null) {
		ResponseStructure<Airhosters> responseStructure= new ResponseStructure<Airhosters>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  Address from  DataBase");
		responseStructure.setData(airhostersDao.deleteAirhosters(id));
		
		return new ResponseEntity<ResponseStructure<Airhosters>>(responseStructure,HttpStatus.OK);
		}
		else 
			throw new AirhostersIdNotFoundException();

	}

}
