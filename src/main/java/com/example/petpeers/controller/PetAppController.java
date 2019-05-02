package com.example.petpeers.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petpeers.entity.User;
import com.example.petpeers.pojo.PetDto;
import com.example.petpeers.pojo.Response;
import com.example.petpeers.pojo.UserDTO;
import com.example.petpeers.service.PetService;
import com.example.petpeers.service.SecurityService;
import com.example.petpeers.service.UserService;

@RestController
@RequestMapping("/pets")
public class PetAppController {

	@Autowired
	PetService petservice;

	@Autowired
	SecurityService securityService;

	@Autowired
	private UserService userService;

	// User Registration done here
	@PostMapping("/add")
	public Response addUser(@RequestBody UserDTO userdto) {
		User user = new User();
		user.setUserId(userdto.getId());
		user.setUserName(user.getUserName());
		user.setPassword(user.getPassword());
		user.setConfirmPassword(user.getConfirmPassword());
		userService.createUser(user);
		return new Response("User Successful Register " + user.getUserId(), Boolean.TRUE);
	}

	@PostMapping("/addpet")
	public ResponseEntity<String> addPet(@RequestBody PetDto PetDto) {
		String s = petservice.addPet(PetDto);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}

	@PostMapping("/user/authenticate")
	public ResponseEntity<String> authenticateUser(@PathParam("username") String username,
			@PathParam("password") String password) {
		User user = new User();
		user.setUserName(username);
		user.setConfirmPassword(password);
		ResponseEntity<String> login = securityService.authenticate(user);
		return login;
	}

	@PostMapping("/petDetail")
	public PetDto petDetail(@RequestBody PetDto petDto) {
		petDto = petservice.getPetById(petDto.getId());
		return petDto;
	}
}
