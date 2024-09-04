package com.myfitness.Serivce;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.Dto.CaloricCalculatiodto;
import com.myfitness.Dto.Caloricfooddto;
import com.myfitness.Dto.Display1dto;
import com.myfitness.Dto.Displaydto;
import com.myfitness.Dto.Fooddto;
import com.myfitness.Dto.Signupdto;
import com.myfitness.Entity.Fooditeam;
import com.myfitness.Entity.TotalFood;
import com.myfitness.Entity.User;
import com.myfitness.Entity.Workout;
import com.myfitness.Entity.caloirburing;
import com.myfitness.Entity.caloirintake;
import com.myfitness.Entity.totalCalorierburing;
import com.myfitness.repo.Calariosburingrepo;
import com.myfitness.repo.CalorieIntakeRepository;
import com.myfitness.repo.FooditeamRepository;
import com.myfitness.repo.TotalFoodRepository;
import com.myfitness.repo.Totalcalriosburingrepo;
import com.myfitness.repo.UserRepository;
import com.myfitness.repo.UserService;
import com.myfitness.repo.WorkoutRepository;


@Service

public class fitneesservice  {
	 @Autowired
	    private FooditeamRepository foodRepository;
	 @Autowired
	    private  Totalcalriosburingrepo   totalcalriosburingrepo;
	 @Autowired
	    private Calariosburingrepo Caloriesburingrepo;
	 @Autowired
	    private WorkoutRepository workoutRepository;
	  @Autowired
	    private TotalFoodRepository totalFoodRepository;
	 @Autowired
	    private CalorieIntakeRepository calorieIntakeRepository;
	  @Autowired
		private UserRepository  userRepository;
	public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
	public User registerNewUser(Signupdto signupdto) {
        // Convert Signupdto to User entity
        User user = new User();
        user.setUsername(signupdto.getUsername());
        user.setPassword(signupdto.getPassword());
        user.setGender(signupdto.getGender());
        user.setAge(signupdto.getAge());
       user.setEmail(signupdto.getEmail());
       user.setPhone(signupdto.getPhone());
        user.setWeight(signupdto.getWeight());
        user.setHeight(signupdto.getHeight());
        
        user.setGoals(signupdto.getGoals());

        // Save the user entity to the database
        return userRepository.save(user);
    }
	public boolean authenticateUser(String username, String password) {
        User user = findByUsernameAndPassword(username, password);
        return user != null;
    }
	
	  public User getUserById(Long id) {
	        return userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	    }
	  public List<User> getUsersByUsername(String username) {
		    return userRepository.findByUsername(username);
		}
	  public User findUserById(Long userId) {
	        return userRepository.findById(userId).orElse(null);
	    }
	  public double calculateCalories(CaloricCalculatiodto caloridto) {
	        double bmr;

	        // Basic Metabolic Rate (BMR) calculation using Mifflin-St Jeor Equation
	        bmr = 10 * caloridto.getWeight() + 6.25 * caloridto.getHeight() - 5 * caloridto.getAge();
	        if (caloridto.getActivityLevel().equalsIgnoreCase("male")) {
	            bmr += 5;
	        } else {
	            bmr -= 161;
	        }

	        // Adjust BMR based on activity level
	        switch (caloridto.getActivityLevel().toLowerCase()) {
	            case "sedentary":
	                return bmr * 1.2;
	            case "lightly active":
	                return bmr * 1.375;
	            case "moderately active":
	                return bmr * 1.55;
	            case "very active":
	                return bmr * 1.725;
	            default:
	                return bmr * 1.2; // Default to sedentary
	        }
	    }
	  public caloirintake createCaloirintake(String foodName, int userQuality, String mealType, LocalDate consumedDate, User user) {
	        // Fetch the Fooditeam object based on the provided food name and user
	        List<Fooditeam> foodItems = foodRepository.findByName(foodName);

	        // Assume the first item is the desired one or refine your logic as needed
	        Fooditeam foodItem = foodItems.stream()
	                .filter(item -> item.getUser().equals(user)) // Filter by user
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("Food item not found for name: " + foodName));

	        // Calculate the adjusted quality and calories
	        int adjustedQuality = userQuality * foodItem.getQuality(); // Assuming Fooditeam has getQuality()
	        int adjustedCalories = adjustedQuality * foodItem.getCalories();

	        // Create a new caloirintake object
	        caloirintake intake = new caloirintake();
	        intake.setName(foodItem.getName()); // Set the name from Fooditeam
	        intake.setQuality(adjustedQuality); // Set the calculated quality
	        intake.setCalories(adjustedCalories); // Set the calculated calories
	        intake.setMealType(mealType);
	        intake.setConsumedDate(consumedDate);
	        intake.setUser(user);

	        // Save the caloirintake object to the database
	        return calorieIntakeRepository.save(intake);
	    }
	

	  public double getTotalFoodOfDay(LocalDate consumedDate, Long userId) {
		    // Retrieve all food intake records for the specified user on the given date
		    List<caloirintake> foodIntakes = calorieIntakeRepository.findByUserIdAndConsumedDate(userId, consumedDate);

		    // Calculate the total food amount for the user on the specified date
		    double totalFood = foodIntakes.stream()
		                                  .mapToDouble(caloirintake::getCalories)
		                                  .sum();

		    // Save the total food value to the database (e.g., in a TotalFood entity)
		    TotalFood totalFoodRecord = new TotalFood();
		    totalFoodRecord.setUserId(userId);
		    totalFoodRecord.setConsumedDate(consumedDate);
		    totalFoodRecord.setTotalCalories(totalFood);
		    
		    // Assuming you have a repository for storing total food values
		    totalFoodRepository.save(totalFoodRecord);

		    return totalFood;
		}
	  
//	  public caloirintake createCaloirburing(String name, int mintues,  LocalDate consumedDate, User user) {
//	        // Fetch the Fooditeam object based on the provided food name and user
//	        List<Workout> workout =  workoutRepository.findByName(workname);
//
//	        // Assume the first item is the desired one or refine your logic as needed
//	        Workout workout = foodItems.stream()
//	                .filter(item -> item.getUser().equals(user)) // Filter by user
//	                .findFirst()
//	                .orElseThrow(() -> new RuntimeException("Food item not found for name: " + foodName));
//
//	        // Calculate the adjusted quality and calories
//	        int adjustedMINTUSE = userMINTUE *  workout.getMinutes(); // Assuming Fooditeam has getQuality()
//	        int adjustedCalories = adjustedQuality * workout.getCaloriesburning();
//
//	        // Create a new caloirintake object
//	        caloirintake intake = new caloirintake();
//	        intake.setName(foodItem.getName()); // Set the name from Fooditeam
//	        intake.setQuality(adjustedQuality); // Set the calculated quality
//	        intake.setCalories(adjustedCalories); // Set the calculated calories
//	        //intake.setMealType(mealType);
//	        intake.setConsumedDate(consumedDate);
//	        intake.setUser(user);
//
//	        // Save the caloirintake object to the database
//	        return Caloriesburingrepo.save(intake);
//	    }
	   
	  public caloirburing createCalorieIntake(String workname, int userMinutes, LocalDate consumedDate, User user) {
		    // Fetch the Workout object based on the provided workout name
		    List<Workout> workouts = workoutRepository.findByName(workname);

		    // Find the first workout for the user, if it exists
		    Workout workout = workouts.stream()
		            .filter(item -> item.getUser().equals(user)) // Filter by user
		            .findFirst()
		            .orElseThrow(() -> new RuntimeException("Workout not found for name: " + workname));

		    // Calculate the adjusted minutes and calories
		    int adjustedMinutes = userMinutes * workout.getMinutes();
		    int adjustedCalories = adjustedMinutes * workout.getCaloriesburning(); // Assuming workout has getCaloriesburning()

		    // Create a new CalorieIntake object
		    caloirburing intake = new caloirburing();
		    intake.setName(workout.getName()); // Set the name from Workout
		    intake.setMinutes(adjustedMinutes); // Set the calculated minutes
		    intake.setCaloriesburning(adjustedCalories); // Set the calculated calories
		    intake.setConsumedDate(consumedDate);
		    intake.setUser(user);

		    // Save the caloirintake object to the database
		    return Caloriesburingrepo.save(intake);
		}
	  public double getTotalcaloriesburingOfDay(LocalDate consumedDate, Long userId) {
		    // Retrieve all calorie burning records for the specified user on the given date
		    List<caloirburing> calorieBurnings = Caloriesburingrepo.findByUserIdAndConsumedDate(userId, consumedDate);

		    // Calculate the total calories burned for the user on the specified date
		    double totalCaloriesBurned = calorieBurnings.stream()
		                                                .mapToDouble(caloirburing::getCaloriesburning) // Corrected method reference
		                                                .sum();

		    // Save the total calories burned value to the database
		    totalCalorierburing totalCaloriesRecord = new totalCalorierburing(); // Correct object instantiation
		    totalCaloriesRecord.setUserId(userId);
		    totalCaloriesRecord.setConsumedDate(consumedDate);
		    totalCaloriesRecord.setTotalCalories(totalCaloriesBurned);

		    // Save the total calories burned to the database
		    totalcalriosburingrepo.save(totalCaloriesRecord); // Assuming this repository exists

		    return totalCaloriesBurned;
		}
	  public List<Displaydto> getCaloriesByDateAndUserId(LocalDate consumedDate, Long userId) {
	        List<caloirintake> calorieIntakeList = calorieIntakeRepository.findByConsumedDateAndUserId(consumedDate, userId);
	        return calorieIntakeList.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    private Displaydto convertToDTO(caloirintake calorieIntake) {
	        return new Displaydto(
	                calorieIntake.getId(),
	                calorieIntake.getName(),
	                calorieIntake.getQuality(),
	                calorieIntake.getCalories(),
	                calorieIntake.getMealType(),
	                calorieIntake.getConsumedDate()
	        );
	    }
	    
	    // Method to get calories burned by date and user ID
	    public List<Display1dto> getCaloriesByDateAndUserId1(LocalDate consumedDate, Long userId) {
	        List<caloirburing> calorieIntakeList = Caloriesburingrepo.findByConsumedDateAndUserId(consumedDate, userId);
	        return calorieIntakeList.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    // Method to convert CalorieBurning entity to Display1Dto
	    private Display1dto convertToDTO(caloirburing calorieIntake) {
	        return new Display1dto(
	                calorieIntake.getId(),
	                calorieIntake.getName(),
	                calorieIntake.getCaloriesburning(),
	                calorieIntake.getMinutes(),
	                calorieIntake.getConsumedDate()
	        );
	    }
}
