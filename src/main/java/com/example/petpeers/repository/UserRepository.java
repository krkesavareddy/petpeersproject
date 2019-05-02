package com.example.petpeers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<com.example.petpeers.entity.User, Long> {
	
	@Query(value="select * from user_details where username=?1 and password=?2",nativeQuery=true)
	com.example.petpeers.entity.User authenticate(String username,String user_password);
	
}
