package com.flight.flight_management_system.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flight.flight_management_system.util.ResponseStructureException;



@RestControllerAdvice //handle the exception globally 
public class ApplicationExceptionHandler {
	
	
	@ExceptionHandler(AirportIdNotFoundException.class) //used to handle the specific exception and sending the custom response  to client 
	public ResponseEntity<ResponseStructureException<String>> airportIdNotFound(AirportIdNotFoundException airportIdNotFoundException){
		ResponseStructureException<String> responseStructure= new ResponseStructureException<String>();
		
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id not found ");
		
		
		return new ResponseEntity<ResponseStructureException<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(AddressIdNotFoundException.class)
	public ResponseEntity<ResponseStructureException<String>> addressIdNotFound(AddressIdNotFoundException addressIdNotFoundException){
		
		ResponseStructureException<String> responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage(" Id Not Found");
		
		return new ResponseEntity<ResponseStructureException<String>>(responseStructureException, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	@ExceptionHandler(AirhostersIdNotFoundException.class)

	public ResponseEntity<ResponseStructureException<String>> airhostersIdNotFound(AirhostersIdNotFoundException airhostersIdNotFoundException){
		ResponseStructureException< String > responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage("Id not Found");
		
		return new  ResponseEntity<ResponseStructureException<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(FlightIdNotFoundException.class)

	public ResponseEntity<ResponseStructureException<String>> flightIdNotFound(FlightIdNotFoundException flightIdNotFoundException){
		ResponseStructureException< String > responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage("Id not Found");
		
		return new  ResponseEntity<ResponseStructureException<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(FoodIdNotFoundException.class)

	public ResponseEntity<ResponseStructureException<String>> foodIdNotFound(FoodIdNotFoundException foodIdNotFoundException){
		ResponseStructureException< String > responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage("Id not Found");
		
		return new  ResponseEntity<ResponseStructureException<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(PassengerIdNotFoundException.class)

	public ResponseEntity<ResponseStructureException<String>> passengerIdNotFound(PassengerIdNotFoundException passengerIdNotFoundException){
		ResponseStructureException< String > responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage("Id not Found");
		
		return new  ResponseEntity<ResponseStructureException<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(PassportIdNotFoundException.class)

	public ResponseEntity<ResponseStructureException<String>> passportIdNotFound(PassportIdNotFoundException passportIdNotFoundException){
		ResponseStructureException< String > responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage("Id not Found");
		
		return new  ResponseEntity<ResponseStructureException<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(PilotIdNotFoundException.class)

	public ResponseEntity<ResponseStructureException<String>> pilotIdNotFound(PilotIdNotFoundException pilotIdNotFoundException){
		ResponseStructureException< String > responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage("Id not Found");
		
		return new  ResponseEntity<ResponseStructureException<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(SeatIdNotFoundException.class)

	public ResponseEntity<ResponseStructureException<String>> seatIdNotFound(SeatIdNotFoundException seatIdNotFoundException){
		ResponseStructureException< String > responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage("Id not Found");
		
		return new  ResponseEntity<ResponseStructureException<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(TicketIdNotFoundException.class)

	public ResponseEntity<ResponseStructureException<String>> ticketIdNotFound(TicketIdNotFoundException ticketIdNotFoundException){
		ResponseStructureException< String > responseStructureException= new ResponseStructureException<String>();
		responseStructureException.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructureException.setMessage("Id not Found");
		
		return new  ResponseEntity<ResponseStructureException<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	

}
