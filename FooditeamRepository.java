package com.myfitness.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.myfitness.Entity.Fooditeam;
import com.myfitness.Entity.User;

public interface FooditeamRepository extends JpaRepository<Fooditeam, Long> {
	// Find all food items by a specific user
  //  List<Fooditeam> findByUserId(Long userId);
//	 List<Fooditeam> findByUser(User user);
	 List<Fooditeam> findByName(String name);
	 List<Fooditeam> findAllByUser(User user);
//	 List<Fooditeam> findByUserAndConsumedDate(User user, LocalDate consumedDate);
//
//	    // Find all food items by a specific user, date, and meal type
//	    List<Fooditeam> findByUserAndConsumedDateAndMealType(User user, LocalDate date, String mealType);
	  List<Fooditeam> findByUserId(Long userId);
}
