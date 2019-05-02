package com.example.petpeers.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<String> authenticateUser(@PathParam("username") String username,@PathParam("password") String password){
		User user = new User();
		user.setUserName(username);
		user.setConfirmPassword(password);
		ResponseEntity<String> login = securityService.authenticate(user);
		return login;
	}

	@PostMapping("/pets/petDetail")
	public PetDto petDetail(@RequestBody PetDto petDto) {
			petDto = petservice.getPetById(petDto.getId());
			return petDto;			
	}
}
