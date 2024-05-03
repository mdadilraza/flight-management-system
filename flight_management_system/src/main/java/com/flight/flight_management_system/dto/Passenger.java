package com.flight.flight_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int passengerId;
	
	private String passengerName;
	
	private String passengerEmail;
	
	private String passengerGender;
	
	private int passengerAge;
	private long passengerPhone;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ticket ticket;//has a 

	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Food> food;

	public Passport getPassport() {
		return passport;
	}



	public void setPassport(Passport passport) {
		this.passport = passport;
	}



	public int getPassengerId() {
		return passengerId;
	}
	
	

	public Ticket getTicket() {
		return ticket;
	}



	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}



	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public long getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(long passengerPhone) {
		this.passengerPhone = passengerPhone;
	}



	public List<Food> getFood() {
		return food;
	}



	public void setFood(List<Food> food) {
		this.food = food;
	}



	



	
	
	
	

}
