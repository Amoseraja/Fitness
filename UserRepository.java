package com.myfitness.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.myfitness.Entity.User;

public interface UserRepository  extends JpaRepository<User, Long> {
	User	findByUsernameAndPassword(String username, String password);
	// List<User> findByName(String name);
	List<User> findByUsername(String username);

}
