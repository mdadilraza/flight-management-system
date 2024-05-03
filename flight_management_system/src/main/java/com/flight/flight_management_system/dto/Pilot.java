package com.flight.flight_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pilot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int pilotId;
	
	private String pilotName;
	
	private double pilotSalary;
	
	private int pilotAge;
	
	private String pilotGender;
	
	private long pilotPhone;

	public int getPilotId() {
		return pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public double getPilotSalary() {
		return pilotSalary;
	}

	public void setPilotSalary(double pilotSalary) {
		this.pilotSalary = pilotSalary;
	}

	public int getPilotAge() {
		return pilotAge;
	}

	public void setPilotAge(int pilotAge) {
		this.pilotAge = pilotAge;
	}

	public String getPilotGender() {
		return pilotGender;
	}

	public void setPilotGender(String pilotGender) {
		this.pilotGender = pilotGender;
	}

	public long getPilotPhone() {
		return pilotPhone;
	}

	public void setPilotPhone(long pilotPhone) {
		this.pilotPhone = pilotPhone;
	}
	
	

}
