package com.example.petpeers.service;

import org.springframework.stereotype.Service;

import com.example.petpeers.pojo.PetDto;
@Service
public interface PetService {

	//public BuyResponceObject buyPet(@RequestBody BuyRequestObject buyRequestObject);
	

	public String addPet(PetDto petDto);
	PetDto getPetById(long id);
		
}
