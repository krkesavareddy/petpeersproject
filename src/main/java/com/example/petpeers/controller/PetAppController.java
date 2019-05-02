package com.example.petpeers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petpeers.entity.User;
import com.example.petpeers.pojo.PetDto;
import com.example.petpeers.service.PetService;
import com.example.petpeers.service.SecurityService;

@RestController
@RequestMapping("")
public class PetAppController {

	@Autowired
	PetService petservice;
	
	@Autowired
	SecurityService securityService;

	@PostMapping("/addpet")
	public ResponseEntity<String> addPet(@RequestBody PetDto PetDto) {
		String s = petservice.addPet(PetDto);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@PostMapping("/user/authenticate")
	public ResponseEntity<String> authenticateUser(@RequestParam String username,@RequestParam String password){
		User user = new User();
		user.setUserName(username);
		user.setConfirmPassword(password);
		ResponseEntity<String> login = securityService.authenticate(user);
		return login;
	}

	@PostMapping("/pets/petDetail/{petid}")
	public PetDto petDetail(@RequestParam Long id) {
			 PetDto petDto = petservice.getPetById(id);
			return petDto;			
	}
}
