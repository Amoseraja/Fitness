package com.myfitness.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myfitness.Dto.Fooddto;
import com.myfitness.Dto.Workoutdto;
import com.myfitness.Entity.Fooditeam;
import com.myfitness.Entity.User;
import com.myfitness.Entity.Workout;
import com.myfitness.Serivce.Workoutserivce;
import com.myfitness.Serivce.fitneesservice;
@RestController
@RequestMapping("/workouts")
public class Workoutcontorller {
	 @Autowired
	    private Workoutserivce workoutService;
	 @Autowired
	    private fitneesservice sc1;
	 @PostMapping("/save/{userId}")
	    public ResponseEntity<Workout> addFoodItem(@RequestBody Workoutdto Workoutdto, @PathVariable Long userId) {
	        User user = sc1.getUserById(userId);
	        Workout createdFoodItem = workoutService.addFoodItem(Workoutdto, user);
	        return new ResponseEntity<>(createdFoodItem, HttpStatus.CREATED);
	    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id) {
	        Optional<Workout> workout = workoutService.getWorkoutById(id);
	        return workout.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Get all workouts for a specific user
	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Workout>> getAllWorkoutsForUser(@PathVariable Long userId) {
	        User user = sc1.getUserById(userId); // Assuming a method to get User by ID in service
	        if (user == null) {
	            return ResponseEntity.notFound().build();
	        }
	        List<Workout> workouts = workoutService.getAllWorkoutsForUser(user);
	        return ResponseEntity.ok(workouts);
	    }

	    // Get all workouts by user ID
	    @GetMapping("/user-id/{userId}")
	    public ResponseEntity<List<Workout>> getWorkoutsByUserId(@PathVariable Long userId) {
	        List<Workout> workouts = workoutService.getWorkoutsByUserId(userId);
	        return ResponseEntity.ok(workouts);
	    }

	    // Delete a workout by its ID
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
	        workoutService.deleteworkout(id);
	        return ResponseEntity.noContent().build();
	    }
}
