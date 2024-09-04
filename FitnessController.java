package com.myfitness.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.myfitness.Dto.CaloricCalculatiodto;
import com.myfitness.Dto.Caloricfooddto;
import com.myfitness.Dto.CalorieBurningDTO;
import com.myfitness.Dto.Display1dto;
import com.myfitness.Dto.Displaydto;
import com.myfitness.Dto.Logindto;
import com.myfitness.Dto.Signupdto;
import com.myfitness.Entity.User;
import com.myfitness.Entity.caloirburing;
import com.myfitness.Entity.caloirintake;
import com.myfitness.Serivce.UserProfileService;
import com.myfitness.Serivce.fitneesservice;
import com.myfitness.maindto.UserProfileDTO;
@RestController
@RequestMapping("/myfitness")
public class FitnessController {
	 @Autowired
	    private fitneesservice  userService;
	 
	  @Autowired
	    private UserProfileService userProfileService;
	 // private static final Logger logger = Logger.getLogger(CalorieController.class.getName());
	  private static final Logger logger = LoggerFactory.getLogger(FitnessController.class);
	    @PostMapping("/signup")
	    public ResponseEntity<String> registerUser(@RequestBody Signupdto signupdto) {
	        try {
	            // Call the service to register the user
	            User newUser = userService.registerNewUser(signupdto);
	            return new ResponseEntity<>("User registered successfully with username: " + newUser.getUsername(), HttpStatus.CREATED);
	        } catch (Exception e) {
	            // Handle any exceptions, such as username already taken, validation errors, etc.
	            return new ResponseEntity<>("Error occurred during user registration: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }
	    @PostMapping("/login")
	    public ResponseEntity<?> loginUser(@RequestBody Logindto logindto) {
	        try {
	            // Authenticate the user
	            boolean isAuthenticated = userService.authenticateUser(logindto.getUsername(), logindto.getPassword());
	            if (isAuthenticated) {
	                // Retrieve the user object after successful authentication
	                User user = userService.findByUsernameAndPassword(logindto.getUsername(), logindto.getPassword());
	                
	                // Extract the user ID from the User object
	                Long userId = user.getId(); // Assuming the User entity has a getId() method

	                // Create a response object or map to include the user ID
	                Map<String, Object> response = new HashMap<>();
	                response.put("message", "Login successful!");
	                response.put("userId", userId);

	                return new ResponseEntity<>(response, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error occurred during login: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }



	    @GetMapping("/username/{username}")
	    public List<User> getUsersByUsername(@PathVariable String username) {
	        return userService.getUsersByUsername(username);
	    }
  @PostMapping("/calculate-calories")
   public ResponseEntity<Double> calculateCalories(@RequestBody CaloricCalculatiodto caloricCalculatiodto) {
       double calories = userService.calculateCalories(caloricCalculatiodto);
       return ResponseEntity.ok(calories);
	    }

	    @GetMapping("/profile/{userId}")
	    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Long userId) {
	        UserProfileDTO userProfileDTO = userProfileService.getUserProfile(userId);
	        return ResponseEntity.ok(userProfileDTO);
	    }

	    @PostMapping("/createcaloirintake/{userId}")
	    public ResponseEntity<caloirintake> createCaloirintake(
	            @PathVariable Long userId,
	            @RequestBody Caloricfooddto caloricCalculatiodto) {
	        try {
	            // Extract necessary fields from caloricCalculatiodto
	            String foodName = caloricCalculatiodto.getName();
	            int userQuality = caloricCalculatiodto.getQuality();
	            String mealType = caloricCalculatiodto.getMealType();
	            LocalDate consumedDate = caloricCalculatiodto.getConsumedDate();

	            // Retrieve the user by ID
	            User user = userProfileService.getUserById(userId);
	            if (user == null) {
	                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	            }

	            // Call the service method to create a caloirintake record
	            caloirintake newIntake = userService.createCaloirintake(foodName, userQuality, mealType, consumedDate, user);
	            return new ResponseEntity<>(newIntake, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	        }}

	    @GetMapping("/total-food/{userId}")
	    public ResponseEntity<Double> getTotalFoodOfDay(@PathVariable("userId") Long userId, @RequestParam("date") String date) {
	        try {
	            LocalDate consumedDate = LocalDate.parse(date);
	            double totalFood = userService.getTotalFoodOfDay(consumedDate, userId);
	            return ResponseEntity.ok(totalFood);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	        }
	    }
	   
	    	@PostMapping("/burning/{userId}")
	    	public ResponseEntity<caloirburing> createCalorieIntake(
	    	        @PathVariable Long userId, 
	    	        @RequestBody CalorieBurningDTO calorieBurningDTO) {
	    	    try {
	    	        // Extract necessary fields from calorieBurningDTO
	    	        String workName = calorieBurningDTO.getWorkName();
	    	        int userMinutes = calorieBurningDTO.getUserMinutes();
	    	        LocalDate consumedDate = calorieBurningDTO.getConsumedDate();

	    	        // Retrieve the user by ID
	    	        User user = userProfileService.getUserById(userId);
	    	        if (user == null) {
	    	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    	        }

	    	        // Call the service method to create a calorie intake record
	    	        caloirburing newIntake = userService.createCalorieIntake(workName, userMinutes, consumedDate, user);
	    	        return new ResponseEntity<>(newIntake, HttpStatus.CREATED);
	    	    } catch (Exception e) {
	    	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    	    }
	    	}

	        
	    // Endpoint to get the total calories burned for a specific day
	   
	    	@GetMapping("/burning/total/{userId}")
	    	public ResponseEntity<Double> getTotalCaloriesBurningOfDay(
	    	        @PathVariable("userId") Long userId, 
	    	        @RequestParam("date") String date) {
	    	    try {
	    	        // Convert the date string to LocalDate
	    	        LocalDate parsedDate = LocalDate.parse(date);

	    	        // Call the service method to get the total calories burned
	    	        double totalCalories = userService.getTotalcaloriesburingOfDay(parsedDate, userId);

	    	        // Return the result
	    	        return ResponseEntity.ok(totalCalories);
	    	    } catch (Exception e) {
	    	        // Handle exceptions and return a bad request response
	    	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    	    }
	    	}
	    	

	    	@GetMapping("/calorieintakeday/{userId}")
	    	public ResponseEntity<List<Displaydto>> getCalorieIntakeByDateAndUserId(
	    	        @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dateStr,
	    	        @PathVariable("userId") Long userId) {

	    	    // Log received date for debugging
	    	    logger.info("Received request to fetch calorie intake for user ID: {} on date: {}", userId, dateStr);

	    	    try {
	    	        // Trim and validate date format
	    	        String trimmedDateStr = dateStr.trim();
	    	        
	    	        // Parse the date string to LocalDate
	    	        LocalDate date = LocalDate.parse(trimmedDateStr);

	    	        // Service call to fetch data
	    	        List<Displaydto> calorieIntakeDTOs = userService.getCaloriesByDateAndUserId(date, userId);

	    	        // Check if the result is empty
	    	        if (calorieIntakeDTOs == null || calorieIntakeDTOs.isEmpty()) {
	    	            logger.warn("No calorie intake data found for user ID: {} on date: {}", userId, date);
	    	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 if no data found
	    	        }

	    	        // Return the fetched data
	    	        return ResponseEntity.ok(calorieIntakeDTOs);}
//	    	    } catch (MethodArgumentTypeMismatchException ex) {
//	    	        // Log error for date parsing issues
//	    	        logger.error("Invalid date format for user ID: {}. Date received: {}. Error: {}", userId, dateStr, ex.getMessage());
//	    	        return new ResponseEntity<>("Invalid date format. Please use yyyy-MM-dd.", HttpStatus.BAD_REQUEST); // 400 for bad date format
//	    	    } 
	    	        catch (Exception e) {
	    	        // Log the exception details for debugging
	    	        logger.error("Error fetching calorie intake for user ID: {} on date: {}. Error: {}", userId, dateStr, e.getMessage());
	    	        // Return an internal server error with a message
	    	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // 500 for unexpected errors
	    	    }}
	    	 @GetMapping("/calorieburiningday/{userId}")
	    	    public ResponseEntity<List<Display1dto>> getCaloriesByDateAndUserId1(
	    	            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dateStr,
	    	            @PathVariable("userId") Long userId) {

	    	        // Log received date for debugging
	    	        logger.info("Received request to fetch calorie intake for user ID: " + userId + " on date: " + dateStr);

	    	        try {
	    	            // Trim and validate date format
	    	            String trimmedDateStr = dateStr.trim();

	    	            // Parse the date string to LocalDate
	    	            LocalDate date = LocalDate.parse(trimmedDateStr);

	    	            // Service call to fetch data
	    	            List<Display1dto> calorieIntakeDTO = userService.getCaloriesByDateAndUserId1(date, userId);

	    	            // Check if the result is empty
	    	            if (calorieIntakeDTO == null || calorieIntakeDTO.isEmpty()) {
		    	            logger.warn("No calorie intake data found for user ID: {} on date: {}", userId, date);
		    	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 if no data found
		    	        }

	    	            // Return the fetched data
	    	            return ResponseEntity.ok(calorieIntakeDTO);
	    	        } catch (Exception e) {
	    	            // Log the exception details for debugging
	    	          //  logger.severe("Error fetching calorie intake for user ID: " + userId + " on date: " + dateStr + ". Error: " + e.getMessage());
	    	            // Return an internal server error with a message
	    	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // 500 for unexpected errors
	    	        }
	    	    }}
