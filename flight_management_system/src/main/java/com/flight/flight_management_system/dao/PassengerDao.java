package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.flight_management_system.dto.Food;
import com.flight.flight_management_system.dto.Passenger;
import com.flight.flight_management_system.dto.Passport;
import com.flight.flight_management_system.dto.Ticket;
import com.flight.flight_management_system.repo.PassengerRepo;
import com.flight.flight_management_system.repo.PassportRepo;
import com.flight.flight_management_system.repo.TicketRepo;

@Repository
public class PassengerDao {
	@Autowired
	PassengerRepo passengerRepo;

	@Autowired
	TicketRepo ticketRepo;
	@Autowired
	PassportRepo passportRepo;

	@Autowired
	FoodDao foodDao;

	public Passenger savePassenger(Passenger passenger) {
		return passengerRepo.save(passenger);
	}

	public Passenger fetchPassenger(int id) {
		Optional<Passenger> optional = passengerRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public List<Passenger> fetchAllPassenger() {
		return passengerRepo.findAll();
	}

	public Passenger updatePassenger(int oldId, Passenger newPassenger) {
		Passenger passenger = fetchPassenger(oldId);
		if (passenger != null)
			newPassenger.setPassengerId(oldId);
		return passengerRepo.save(newPassenger);
	}

	public Passenger deletePassenger(int id) {
		Passenger passenger = fetchPassenger(id);
		if (passenger != null)
			passengerRepo.delete(passenger);
		return passenger;
	}

	public Passenger addExistingPassengerToExistingTicket(int passengerId, int ticketId) {
		Passenger passenger = fetchPassenger(passengerId);
		Ticket ticket = ticketRepo.findById(ticketId).get();
		passenger.setTicket(ticket);
		return savePassenger(passenger);

	}

	public Passenger addNewTicketToExistingPassenger(Ticket newTicket, int passengerId) {

		Passenger passenger = fetchPassenger(passengerId);
		passenger.setTicket(newTicket);
		return savePassenger(passenger);
	}

	public Passenger addExistingPassengerToExistingPassport(int passengerId, int passportId) {
		Passenger passenger = fetchPassenger(passengerId);
		Passport passport = passportRepo.findById(passportId).get();
		passenger.setPassport(passport);
		return savePassenger(passenger);

	}

	public Passenger addNewPassportToExistingPassenger(Passport newPassport, int passengerId) {

		Passenger passenger = fetchPassenger(passengerId);
		passenger.setPassport(newPassport);
		return savePassenger(passenger);
	}

	// addExistingPassengerToExistingFood
	public Passenger addExistingPassengerToExistingFood(int passengerId, int foodId) {
		Passenger passenger = fetchPassenger(passengerId);

		Food newfood = foodDao.fetchFood(foodId);

		List<Food> list = passenger.getFood();
		list.add(newfood);

		passenger.setFood(list);

		return savePassenger(passenger);

	}

	// addNewFoodToExistingPassenger

	public Passenger addNewFoodToExistingPassenger(Food newFood, int passengerId) {
		Passenger passenger = fetchPassenger(passengerId);

		List<Food> foods = passenger.getFood();
		foods.add(newFood);

		passenger.setFood(foods);
		return savePassenger(passenger);

	}

}
