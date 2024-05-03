package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.FoodDao;
import com.flight.flight_management_system.dto.Flight;
import com.flight.flight_management_system.dto.Food;
import com.flight.flight_management_system.exception.FoodIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;

	public ResponseEntity<ResponseStructure<Food>> saveFood(Food food) {
		ResponseStructure<Food> responseStructure= new ResponseStructure<Food>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Food into DataBase");
		responseStructure.setData(foodDao.saveFood(food));
		
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Food>> fetchFood(int id) {
		Food food =foodDao.fetchFood(id);
		
		if(food!= null) {
		
		ResponseStructure<Food> responseStructure= new ResponseStructure<Food>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched Food from DataBase");
		responseStructure.setData(foodDao.fetchFood(id));
		
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new FoodIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Food>>>fetchAllFood() {
		ResponseStructure<List<Food>> responseStructure= new ResponseStructure<List<Food>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched all Flight from database ");
		responseStructure.setData(foodDao.fetchAllFood());
		
		return new ResponseEntity<ResponseStructure<List<Food>>>(responseStructure,HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<Food>> updateFood(int oldId, Food newFood) {
		Food food= foodDao.fetchFood(oldId);
		
		if(food != null) {
		ResponseStructure<Food> responseStructure= new ResponseStructure<Food>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated  Food  into DataBase");
		responseStructure.setData(foodDao.updateFood(oldId, newFood));
		
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.OK);
		}else {
			throw new FoodIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Food>> deleteFood(int id) {
		
		Food food = foodDao.fetchFood(id);
		if(food != null) {
		

		ResponseStructure<Food> responseStructure= new ResponseStructure<Food>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  food from DataBase");
		responseStructure.setData(foodDao.deleteFood(id));
		
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.OK);
		}else {
			throw new FoodIdNotFoundException();
		}
	}

}
