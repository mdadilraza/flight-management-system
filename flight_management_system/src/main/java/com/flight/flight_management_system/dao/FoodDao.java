package com.flight.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.flight.flight_management_system.dto.Food;
import com.flight.flight_management_system.repo.FoodRepo;

@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;
	
	public Food saveFood( Food food) {
		return foodRepo.save(food);
	}
	
	public Food fetchFood(int id) {
		Optional<Food> optional= foodRepo.findById(id);
		if(optional.isPresent()) {
		return optional.get();
		
		}else {
			return null;
		}
	}
	
	public List<Food> fetchAllFood() {
		return foodRepo.findAll();
	}
	
	

	public Food updateFood(int oldId, Food newFood) {
		Food food = fetchFood(oldId);
		if(food != null)
		newFood.setFoodId(oldId);
		return foodRepo.save(newFood);
	}

	public Food deleteFood(int id) {
		Food food = foodRepo.findById(id).get();
		if(food != null)
		foodRepo.delete(food);
		return food;
	}

}
