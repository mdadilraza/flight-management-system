package com.flight.flight_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.flight_management_system.dto.Food;
import com.flight.flight_management_system.service.FoodService;
import com.flight.flight_management_system.util.ResponseStructure;

@RestController
public class FoodController {

	@Autowired
	FoodService foodService;

	@PostMapping("/saveFood")
	public ResponseEntity<ResponseStructure<Food>> saveFood(@RequestBody Food food) {
		return foodService.saveFood(food);
	}

	@GetMapping("/fetchFood")
	public ResponseEntity<ResponseStructure<Food>> fetchFood(int id) {
		return foodService.fetchFood(id);
	}
	
	@GetMapping("/fetchAllFood")
	public ResponseEntity<ResponseStructure<List<Food>>>fetchAllFood() {
		return foodService.fetchAllFood();
	}

	@PutMapping("/updateFood")
	public ResponseEntity<ResponseStructure<Food>> updateFood(int oldId, Food newFood) {
		return foodService.updateFood(oldId, newFood);
	}

	@DeleteMapping("/deleteFood")
	public ResponseEntity<ResponseStructure<Food>> deleteFood(int id) {

		return foodService.deleteFood(id);
	}

}
