package com.myfitness.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfitness.Entity.User;
import com.myfitness.Entity.Workout;

public interface WorkoutRepository  extends JpaRepository<Workout, Long>{
	  // Find all workouts by a specific user//   List<Workout> findByUserId(Long userId);
	List<Workout> findByUser(User user);
	 List<Workout> findByUserId(Long userId);
	   List<Workout> findByName(String name);
}
