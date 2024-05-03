package com.flight.flight_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.flight_management_system.dto.Food;
import com.flight.flight_management_system.dto.Passenger;
import com.flight.flight_management_system.dto.Passport;
import com.flight.flight_management_system.dto.Ticket;
import com.flight.flight_management_system.service.PassengerService;
import com.flight.flight_management_system.util.ResponseStructure;

@Controller
@ResponseBody
public class PassengerController {
	
	@Autowired
	PassengerService passengerService;
	@PostMapping("/savePassenger")
	public ResponseEntity<ResponseStructure<Passenger>> savePassenger (@RequestBody Passenger passenger) {
		return passengerService.savePassenger(passenger);
	}
	@GetMapping("/fetchPassenger")
	public ResponseEntity<ResponseStructure<Passenger>> fetchPassenger(int id) {
		return passengerService.fetchPassenger(id);
	}
	@GetMapping("/fetchAllPassenger")
	public ResponseEntity<ResponseStructure< List<Passenger>>> fetchAllPassenger(){
		return passengerService.fetchAllPassenger();
	}
	
    @PutMapping("/updatePassenger")
	public ResponseEntity<ResponseStructure<Passenger>> updatePassenger(int oldId,@RequestBody Passenger newPassenger) {
		
		return passengerService.updatePassenger(oldId, newPassenger);
	}
   @DeleteMapping("/deletePassenger")
	public ResponseEntity<ResponseStructure<Passenger>> deletePassenger(int id) {
		
		return passengerService.deletePassenger(id);
	}
   
   @PutMapping("/addExistingPassengerToExistingTicket")
   public   ResponseEntity<ResponseStructure<Passenger>> addExistingPassengerToExistingTicket(int passengerId, int ticketId) {
	   return passengerService.addExistingPassengerToExistingTicket(passengerId, ticketId);
   }
   @PutMapping("/addNewTicketToExistingPassenger")
   public ResponseEntity<ResponseStructure<Passenger>> addNewTicketToExistingPassenger(@RequestBody Ticket newTicket,int  passengerId) {
	   return passengerService.addNewTicketToExistingPassenger(newTicket, passengerId);
   }
   @PutMapping("/addExistingPassengerToExistingPassport")
   public   ResponseEntity<ResponseStructure<Passenger>> addExistingPassengerToExistingPassport(int passengerId, int passportId) {
		return passengerService.addExistingPassengerToExistingPassport(passengerId, passportId);
	}
	@PutMapping("/addNewPassportToExistingPassenger")
	public ResponseEntity<ResponseStructure<Passenger>> addNewPassportToExistingPassenger(@RequestBody Passport newPassport,int  passengerId) {
		return passengerService.addNewPassportToExistingPassenger(newPassport, passengerId);
	}
	
	@PutMapping("/addExistingPassengerToExistingFood")
	public ResponseEntity<ResponseStructure<Passenger>> addExistingPassengerToExistingFood(int passengerId, int foodId) {//1 5 
		return passengerService.addExistingPassengerToExistingFood(passengerId, foodId);
	}
	@PutMapping("/addNewFoodToExistingPassenger")
	public ResponseEntity<ResponseStructure<Passenger>> addNewFoodToExistingPassenger(@RequestBody Food newFood , int passengerId) {
		return passengerService.addNewFoodToExistingPassenger(newFood, passengerId);
	}

}
