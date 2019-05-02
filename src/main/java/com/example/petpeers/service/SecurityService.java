package com.example.petpeers.service;

import org.springframework.http.ResponseEntity;

public interface SecurityService {

	public ResponseEntity<String> authenticate(com.example.petpeers.entity.User user);
	
}
