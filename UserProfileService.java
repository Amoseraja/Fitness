package com.myfitness.Serivce;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.Entity.Fooditeam;
import com.myfitness.Entity.User;
import com.myfitness.Entity.Workout;
import com.myfitness.maindto.FoodDTO;
import com.myfitness.maindto.UserProfileDTO;
import com.myfitness.maindto.WorkoutDTO;
import com.myfitness.repo.FooditeamRepository;
import com.myfitness.repo.UserProfileS;
import com.myfitness.repo.UserRepository;
import com.myfitness.repo.WorkoutRepository;
@Service
public class UserProfileService implements UserProfileS{
	  @Autowired
			private UserRepository  userRepository;
	  @Autowired
	    private FooditeamRepository foodRepository;
	  @Autowired
	    private WorkoutRepository  workoutRepository;
	  public UserProfileDTO getUserProfile(Long userId) {
	        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
	        List<Fooditeam> foods = foodRepository.findByUserId(userId);
	        List<Workout> workouts = workoutRepository.findByUserId(userId);

	        // Map User, Foods, and Workouts to DTO
	        UserProfileDTO userProfileDTO = new UserProfileDTO();
	        userProfileDTO.setId(user.getId());
	        userProfileDTO.setUsername(user.getUsername());
	        userProfileDTO.setGender(user.getGender());
	        userProfileDTO.setEmail(user.getEmail());
	        userProfileDTO.setAge(user.getAge());
	        userProfileDTO.setWeight(user.getWeight());
	        userProfileDTO.setHeight(user.getHeight());
	        // Map Foods
//	        List<FoodDTO> foodDTOs = foods.stream().map(food -> {
//	            FoodDTO foodDTO = new FoodDTO();
//	            foodDTO.setId(food.getId());
//	            foodDTO.setName(food.getName());
//	            foodDTO.setQuality(food.getQuality());
//	            foodDTO.setCalories(food.getCalories());
//	            foodDTO.setProtein(food.getProtein());
//	            foodDTO.setCarb(food.getCarb());
//	            foodDTO.setFat(food.getFat());
//	            foodDTO.setFootpicture(food.getFootpicture());
//	            foodDTO.setMealType(food.getMealType());
//	            return foodDTO;
//	        }).collect(Collectors.toList());
//
//	        userProfileDTO.setFoodItemst(foodDTOs);
	     // Convert List<FoodDTO> to Set<FoodDTO>
	        Set<FoodDTO> foodDTOs = foods.stream().map(food -> {
	            FoodDTO foodDTO = new FoodDTO();
	            foodDTO.setId(food.getId());
	            foodDTO.setName(food.getName());
	            foodDTO.setQuality(food.getQuality());
	            foodDTO.setCalories(food.getCalories());
	            foodDTO.setProtein(food.getProtein());
	            foodDTO.setCarb(food.getCarb());
	            foodDTO.setFat(food.getFat());
	            foodDTO.setFootpicture(food.getFootpicture());
	            foodDTO.setMealType(food.getMealType());
	            return foodDTO;
	        }).collect(Collectors.toSet()); // Convert List to Set

	        // Set the Set<FoodDTO> in UserProfileDTO
	        userProfileDTO.setFoodItems(foodDTOs);

//	        // Map Workouts
//	        List<WorkoutDTO> workoutDTOs = workouts.stream().map(workout -> {
//	            WorkoutDTO workoutDTO = new WorkoutDTO();
//	            workoutDTO.setId(workout.getId());
//	            workoutDTO.setName(workout.getName());
//	            workoutDTO.setWorkpicture(workout.getWorkpicture());
//	            workoutDTO.setMinutes(workout.getMinutes());
//	            workoutDTO.setCaloriesburning(workout.getCaloriesburning());
//	            return workoutDTO;
//	        }).collect(Collectors.toList());
//
//	        userProfileDTO.setWorkouts(workoutDTOs);
//
//	        return userProfileDTO;
//	    }
	        Set<WorkoutDTO> workoutDTOs = workouts.stream().map(workout -> {
	            WorkoutDTO workoutDTO = new WorkoutDTO();
	            workoutDTO.setId(workout.getId());
	            workoutDTO.setName(workout.getName());
	            workoutDTO.setWorkpicture(workout.getWorkpicture());
	            workoutDTO.setMinutes(workout.getMinutes());
	            workoutDTO.setCaloriesburning(workout.getCaloriesburning());
	            return workoutDTO;
	        }).collect(Collectors.toSet()); // Convert List to Set

	        userProfileDTO.setWorkouts(workoutDTOs); // Pass the Set to the method

	        return userProfileDTO;

	  }
	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		//return null;
		 return userRepository.findById(userId).orElse(null);
	}}
