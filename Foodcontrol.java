package com.myfitness.controller;

import com.myfitness.Dto.CaloricCalculatiodto;
import com.myfitness.Dto.Caloricfooddto;
import com.myfitness.Dto.Fooddto;
import com.myfitness.Entity.Fooditeam;
import com.myfitness.Entity.User;
import com.myfitness.Entity.caloirintake;
import com.myfitness.Serivce.Foodserivce;
import com.myfitness.Serivce.fitneesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/fitness/food")
public class Foodcontrol {
	@Autowired
    private Foodserivce foodService;
	 
    @Autowired
    private fitneesservice sc;  
    // Add a new food item
    @PostMapping("/add/{userId}")
    public ResponseEntity<Fooditeam> addFoodItem(@RequestBody Fooddto fooddto, @PathVariable Long userId) {
        User user = sc.getUserById(userId);
        Fooditeam createdFoodItem = foodService.addFoodItem(fooddto, user);
        return new ResponseEntity<>(createdFoodItem, HttpStatus.CREATED);
    }
   

    // Update an existing food item
    @PutMapping("/update/{id}")
    public ResponseEntity<Fooditeam> updateFoodItem(@PathVariable Long id, @RequestBody Fooddto fooddto) {
        Fooditeam updatedFoodItem = foodService.updateFoodItem(id, fooddto);
        return ResponseEntity.ok(updatedFoodItem);
    }

    // Delete a food item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
        foodService.deleteFoodItem(id);
        return ResponseEntity.noContent().build();
    }

    // Get a food item by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Fooditeam> getFoodItemById(@PathVariable Long id) {
        Fooditeam foodItem = foodService.getFoodItemById(id);
        return ResponseEntity.ok(foodItem);
    }

    // Get all food items for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Fooditeam>> getAllFoodItemsForUser(@PathVariable Long userId) {
        // Fetch the user by userId
        User user = sc.getUserById(userId); 
        List<Fooditeam> foodItems = foodService.getAllFoodItemsForUser(user);
        return ResponseEntity.ok(foodItems);
    }

    }
