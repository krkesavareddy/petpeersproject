package com.example.petpeers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.petpeers.repository.UserRepository;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<String> authenticate(com.example.petpeers.entity.User user) {
		com.example.petpeers.entity.User dbobject = userRepository.authenticate(user.getUserName(),user.getConfirmPassword());
		if(dbobject == (null)) {
			return new ResponseEntity<String>("Credentials Not found,need to register",HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<String>("User logged-in Successfully",HttpStatus.OK);
	}

}
