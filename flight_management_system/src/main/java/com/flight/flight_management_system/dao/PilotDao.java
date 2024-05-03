package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.flight.flight_management_system.dto.Pilot;

import com.flight.flight_management_system.repo.PilotRepo;

@Repository
public class PilotDao {
	
	@Autowired
	PilotRepo pilotRepo;
	
	public Pilot savePilot( Pilot pilot) {
		return pilotRepo.save(pilot);
	}
	
	
	public Pilot fetchPilot(int id) {
		Optional<Pilot> optional= pilotRepo.findById(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	
	public List<Pilot> fetchAllPilot(){
		return pilotRepo.findAll();
	}

	public Pilot updatePilot(int oldId, Pilot newPilot) {
		Pilot pilot= fetchPilot(oldId);
		if(pilot !=null) {
		newPilot.setPilotId(oldId);
		return pilotRepo.save(newPilot);}
		return null;
	}

	public Pilot deletePilot(int id) {
		Pilot pilot= fetchPilot(id);
		if(pilot != null)
		pilotRepo.delete(pilot);
		return pilot;
	}


}
