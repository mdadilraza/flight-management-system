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
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airportId;

	private String airportAuthority;

	private String airportName;

	private long airportPhone;

	private String airportEmail;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Flight> flights;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public String getAirportAuthority() {
		return airportAuthority;
	}

	public void setAirportAuthority(String airportAuthority) {
		this.airportAuthority = airportAuthority;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public long getAirportPhone() {
		return airportPhone;
	}

	public void setAirportPhone(long airportPhone) {
		this.airportPhone = airportPhone;
	}

	public String getAirportEmail() {
		return airportEmail;
	}

	public void setAirportEmail(String airportEmail) {
		this.airportEmail = airportEmail;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	

}
