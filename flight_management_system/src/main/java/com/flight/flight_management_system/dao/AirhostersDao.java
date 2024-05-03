package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.flight_management_system.dto.Address;
import com.flight.flight_management_system.dto.Airhosters;
import com.flight.flight_management_system.repo.AirhostersRepo;


@Repository
public class AirhostersDao {
	
	@Autowired
	AirhostersRepo airhostersRepo;
	
	public Airhosters saveAirhosters(Airhosters airhosters) {
		return airhostersRepo.save(airhosters);
		
	}
	public Airhosters fetchAirhosters(int id) {
		
	Optional<Airhosters> optional	= airhostersRepo.findById(id);
	if(optional.isPresent()) {
		return optional.get();
	}
	else {
		return null;
	}
		
	}
	
	public List<Airhosters> fetchAll() {
		return airhostersRepo.findAll();
	}
	
	
	public Airhosters updateAirhosters(int oldId , Airhosters newAirhosters) {
		Airhosters airhosters=fetchAirhosters(oldId);
	
			
		
		 airhostersRepo.save(newAirhosters);
		 return airhosters;
	
		
	}
	
	public Airhosters deleteAirhosters(int id) {
	Airhosters airhosters	=fetchAirhosters(id);
	if(airhosters != null)
	  airhostersRepo.delete(airhosters);
	  return airhosters;
	}
	
	

}
