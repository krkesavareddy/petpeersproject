package com.example.petpeers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.petpeers.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from user_details where username=?1 and password=?2", nativeQuery = true)
	User authenticate(String username, String user_password);

}
