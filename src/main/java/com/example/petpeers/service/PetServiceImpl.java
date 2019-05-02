package com.example.petpeers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petpeers.entity.Pet;
import com.example.petpeers.pojo.PetDto;
import com.example.petpeers.repository.PetRepository;
@Service
public class PetServiceImpl  implements PetService {
	@Autowired
	PetRepository petRepository;

	@Override
	public String addPet(PetDto PetDto) {
		try {
		Pet pet=new Pet();
		pet.setAge(PetDto.getAge());
		pet.setPlace(PetDto.getPlace());
		pet.setPetName(PetDto.getName());
		petRepository.save(pet);
		
		return "sucessfully added";
		}
		catch(Exception e) {
			return "sucessfully not added";
		}
		
		
	}
	
	@Override
	public PetDto getPetById(long id) {
		Pet pet = petRepository.findById(id).get();
		PetDto PetDto = new PetDto();
		PetDto.setAge(pet.getAge());
		PetDto.setId(pet.getPetId());
		PetDto.setName(pet.getPetName());
		PetDto.setPlace(pet.getPlace());
		
		return PetDto;
	}

	

}
