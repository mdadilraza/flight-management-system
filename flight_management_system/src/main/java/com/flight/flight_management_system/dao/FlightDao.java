package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.flight_management_system.dto.Airhosters;

import com.flight.flight_management_system.dto.Flight;
import com.flight.flight_management_system.dto.Passenger;
import com.flight.flight_management_system.dto.Pilot;
import com.flight.flight_management_system.dto.Seat;

import com.flight.flight_management_system.repo.FlightRepo;

@Repository
public class FlightDao {

	@Autowired
	FlightRepo flightRepo;

	@Autowired
	PilotDao pilotDao;
	@Autowired
	SeatDao seatDao;

	@Autowired
	PassengerDao passengerDao;

	@Autowired
	AirhostersDao airhostersDao;

	public Flight saveFlight(Flight flight) {

		return flightRepo.save(flight);
	}

	public Flight fetchFlight(int id) {
		Optional<Flight> optional = flightRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public List<Flight> fetchAllFlight() {
		return flightRepo.findAll();
	}

	public Flight updateFlight(int oldId, Flight newFlight) {
		Flight flight = fetchFlight(oldId);
		if (flight != null) {
			newFlight.setFlightId(oldId);
		}
		return flightRepo.save(newFlight);
	}

	public Flight deleteFlight(int id) {
		Flight flight = flightRepo.findById(id).get();
		flightRepo.delete(flight);
		return flight;
	}

	// addExistingFlightToExistingPilot

	public Flight addExistingFlightToExistingPilot(int flightId, int pilotId) {
		Flight flight = fetchFlight(flightId);

		Pilot newPilot = pilotDao.fetchPilot(pilotId);

		List<Pilot> pilots = flight.getPilots();
		pilots.add(newPilot);

		flight.setPilots(pilots);
		return saveFlight(flight);

	}

	// addNewFlightToExistingAirport

	public Flight addNewFlightToExistingPilot(Pilot newPilot, int flightId) {
		Flight flight = fetchFlight(flightId);
		List<Pilot> pilots = flight.getPilots();

		pilots.add(newPilot);

		flight.setPilots(pilots);

		return saveFlight(flight);

	}

	// addExistingFlightToExistingSeat

	public Flight addExistingFlightToExistingSeat(int flightId, int seatId) {
		Flight flight = fetchFlight(flightId);

		Seat newSeat = seatDao.fetchsSeat(seatId);

		List<Seat> seats = flight.getSeats();
		seats.add(newSeat);

		flight.setSeats(seats);
		;
		return saveFlight(flight);

	}

	// addNewSeatToExistingFlight

	public Flight addNewSeatToExistingFlight(Seat newSeat, int flightId) {
		Flight flight = fetchFlight(flightId);

		List<Seat> seats = flight.getSeats();

		seats.add(newSeat);

		flight.setSeats(seats);
		return saveFlight(flight);

	}

	// addExistingFlightToExistingPassenger

	public Flight addExistingFlightToExistingPassenger(int passengerId, int flightId) {
		Flight flight = fetchFlight(flightId);

		Passenger passenger = passengerDao.fetchPassenger(passengerId);

		List<Passenger> passengers = flight.getPassengers();
		passengers.add(passenger);

		flight.setPassengers(passengers);

		return saveFlight(flight);

	}

	// addNewPassengerToExistingFlight

	public Flight addNewPassengerToExistingFlight(Passenger newPassenger, int flightId) {
		Flight flight = fetchFlight(flightId);
		List<Passenger> passengers = flight.getPassengers();
		passengers.add(newPassenger);

		flight.setPassengers(passengers);

		return saveFlight(flight);

	}

	// addExistingFlightToExistingAirhosters

	public Flight addExistingFlightToExistingAirhosters(int flightId, int airhostersId) {
		Flight flight = fetchFlight(flightId);

		Airhosters airhosters = airhostersDao.fetchAirhosters(airhostersId);

		List<Airhosters> list = flight.getAirhosters();
		list.add(airhosters);

		flight.setAirhosters(list);

		return saveFlight(flight);

	}

	// addNewAirhostersToExistingFlight

	public Flight addNewAirhostersToExistingFlight(Airhosters newAirhosters, int flightId) {
		Flight flight = fetchFlight(flightId);
		List<Airhosters> airhosters = flight.getAirhosters();
		airhosters.add(newAirhosters);

		flight.setAirhosters(airhosters);

		return saveFlight(flight);
	}

}
