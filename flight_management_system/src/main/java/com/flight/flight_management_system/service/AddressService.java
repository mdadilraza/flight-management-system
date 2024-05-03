package com.flight.flight_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.flight_management_system.dao.AddressDao;
import com.flight.flight_management_system.dto.Address;
import com.flight.flight_management_system.exception.AddressIdNotFoundException;
import com.flight.flight_management_system.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	public ResponseEntity< ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> responseStructure= new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted Address into DataBase");
		responseStructure.setData(addressDao.saveAddress(address));
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}
   
	public ResponseEntity<ResponseStructure<Address>> fetchAddress(int id) {
		
		Address address= addressDao.fetchAddress(id);
		if(address !=null) {
		ResponseStructure<Address> responseStructure= new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Fetched  Address from DataBase");
		responseStructure.setData(addressDao.fetchAddress(id));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}
		else
		throw new AddressIdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Address>>> fetchAll(){
		ResponseStructure<List<Address>> responseStructure= new ResponseStructure<List<Address>>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Fetched  Address from DataBase");
		responseStructure.setData(addressDao.fetchAll());
		return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.FOUND);
	}
	
	public  ResponseEntity<ResponseStructure<Address>>  updateAddress(int oldId , Address newAddress) {
		Address address= addressDao.fetchAddress(oldId);
		if(address != null) {
		ResponseStructure<Address> responseStructure= new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated  Address into DataBase");
		responseStructure.setData(addressDao.updateAddress(oldId, newAddress));
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new AddressIdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address address= addressDao.deleteAddress(id);
		if(address !=null) {
		ResponseStructure<Address> responseStructure= new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted  Address from DataBase");
		responseStructure.setData(addressDao.deleteAddress(id));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new AddressIdNotFoundException();
		
		  
		}
}
