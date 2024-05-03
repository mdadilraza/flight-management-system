package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.flight_management_system.dto.Address;
import com.flight.flight_management_system.dto.Airport;
import com.flight.flight_management_system.dto.Flight;
import com.flight.flight_management_system.repo.AddressRepo;
import com.flight.flight_management_system.repo.AirportRepo;

@Repository
public class AirportDao {

	@Autowired
	AirportRepo airportRepo;

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	FlightDao flightDao;

	public Airport saveAirport(Airport airport) {
		return airportRepo.save(airport);
	}

	public Airport fetchAirport(int id) {

		Optional<Airport> airport = airportRepo.findById(id);
		if (airport.isPresent()) {
			return airport.get();
		} else {
			return null;
		}
	}

	public List<Airport> fetchAllAirport() {
		return airportRepo.findAll();
	}

	public Airport updateAirport(int oldId, Airport newAirport) {
		Airport airport = fetchAirport(oldId);
		airport.setAirportAuthority(newAirport.getAirportAuthority());
		airport.setAirportEmail(newAirport.getAirportEmail());
		airport.setAirportName(newAirport.getAirportName());
		airport.setAirportPhone(newAirport.getAirportPhone());
		return airportRepo.save(airport);
	}

	public Airport deleteAirport(int id) {
		Airport airport = fetchAirport(id);
		airportRepo.delete(airport);
		return airport;
	}

	public Airport addExistingAddressToExistingAirpot(int addressId, int airpotId) {
		// Airport airport=airportRepo.findById(airpotId).get();
		Airport airport = fetchAirport(airpotId);

		Address address = addressRepo.findById(addressId).get();
		airport.setAddress(address);

		// return airportRepo.save(airport);

		return saveAirport(airport);

	}

	public Airport addNewAddressToExistingAirport(Address newAddress, int airpotId) {
		Airport airport = fetchAirport(airpotId);
		airport.setAddress(newAddress);

		return saveAirport(airport);
	}

	// addExistingAirportToExistingFlight

	public Airport addExistingAirportToExistingFlight(int airpotId, int flightId) {
		Airport airpot = fetchAirport(airpotId);

		Flight newflight = flightDao.fetchFlight(flightId);

		List<Flight> flights = airpot.getFlights();
		flights.add(newflight);

		airpot.setFlights(flights);
		return saveAirport(airpot);

	}

	// addNewFlightToExistingAirport

	public Airport addNewFlightToExistingAirport(Flight newFlight, int airpotId) {
		Airport airpot = fetchAirport(airpotId);
		List<Flight> flights = airpot.getFlights();
		flights.add(newFlight);

		airpot.setFlights(flights);

		return saveAirport(airpot);

	}

}
