package com.flight.flight_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airhosters {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int airhostersId;
	
	private String airhostersName;
	
	private double airhostersSalary;
	
	private int airhostersAge;
	
	private long airhostersPhone;

	public int getAirhostersId() {
		return airhostersId;
	}

	public void setAirhostersId(int airhostersId) {
		this.airhostersId = airhostersId;
	}

	public String getAirhostersName() {
		return airhostersName;
	}

	public void setAirhostersName(String airhostersName) {
		this.airhostersName = airhostersName;
	}

	public double getAirhostersSalary() {
		return airhostersSalary;
	}

	public void setAirhostersSalary(double airhostersSalary) {
		this.airhostersSalary = airhostersSalary;
	}

	public int getAirhostersAge() {
		return airhostersAge;
	}

	public void setAirhostersAge(int airhostersAge) {
		this.airhostersAge = airhostersAge;
	}

	public long getAirhostersPhone() {
		return airhostersPhone;
	}

	public void setAirhostersPhone(long airhostersPhone) {
		this.airhostersPhone = airhostersPhone;
	}
	
	
	

}
