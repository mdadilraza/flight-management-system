package com.flight.flight_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.flight_management_system.dto.Flight;

public interface FlightRepo extends JpaRepository<Flight, Integer> {

}
