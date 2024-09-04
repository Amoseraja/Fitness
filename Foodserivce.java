package com.myfitness.Serivce;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.Dto.Caloricfooddto;
import com.myfitness.Dto.Fooddto;
import com.myfitness.Entity.Fooditeam;
import com.myfitness.Entity.User;
import com.myfitness.Entity.caloirintake;
import com.myfitness.repo.CalorieIntakeRepository;
import com.myfitness.repo.FoodService;
import com.myfitness.repo.FooditeamRepository;
@Service

public class Foodserivce implements FoodService {
	 @Autowired
	    private FooditeamRepository foodRepository;
	 @Autowired
	    private fitneesservice  userService;
	
	 @Autowired
	    private CalorieIntakeRepository calorieIntakeRepository;
	@Override
	public Fooditeam addFoodItem(Fooddto fooddto, User user) {
		 Fooditeam foodItem = new Fooditeam();
	        foodItem.setName(fooddto.getName());
	        foodItem.setQuality(fooddto.getQuality());
	        foodItem.setCalories(fooddto.getCalories());
	        foodItem.setProtein(fooddto.getProtein());
	        foodItem.setCarb(fooddto.getCarb());
	        foodItem.setFat(fooddto.getFat());
	        foodItem.setFootpicture(fooddto.getFootpicture());
	        foodItem.setUser(user);

	        return foodRepository.save(foodItem);
	}

	@Override
	public Fooditeam updateFoodItem(Long id, Fooddto fooddto) {
		 Optional<Fooditeam> existingFoodItem = foodRepository.findById(id);

	        if (existingFoodItem.isPresent()) {
	            Fooditeam foodItem = existingFoodItem.get();
	            foodItem.setName(fooddto.getName());
	            foodItem.setQuality(fooddto.getQuality());
	            foodItem.setCalories(fooddto.getCalories());
	            foodItem.setProtein(fooddto.getProtein());
	            foodItem.setCarb(fooddto.getCarb());
	            foodItem.setFat(fooddto.getFat());
	            foodItem.setFootpicture(fooddto.getFootpicture());

	            return foodRepository.save(foodItem);
	        } else {
	            throw new RuntimeException("Food item not found with id: " + id);
	        }
	    }
	

	@Override
	public void deleteFoodItem(Long id) {
		// TODO Auto-generated method stub
		 foodRepository.deleteById(id);
		
	}

	@Override
	public Fooditeam getFoodItemById(Long id) {
		  return foodRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Food item not found with id: " + id));
	}

	@Override
	public List<Fooditeam> getAllFoodItemsForUser(User user) {
	    return foodRepository.findAllByUser(user);
	}
	 //  public caloirintake createCaloirintake(String foodName, int userQuality, String mealType, LocalDate consumedDate, User user) {
//	        // Fetch the Fooditeam object based on the provided food name and user
//	        List<Fooditeam> foodItems = foodRepository.findByName(foodName);
//
//	        // Assume the first item is the desired one or refine your logic as needed
//	        Fooditeam foodItem = foodItems.stream()
//	                .filter(item -> item.getUser().equals(user)) // Filter by user
//	                .findFirst()
//	                .orElseThrow(() -> new RuntimeException("Food item not found for name: " + foodName));
//
//	        // Calculate the adjusted quality and calories
//	        int adjustedQuality = userQuality * foodItem.getQuality(); // Assuming Fooditeam has getQuality()
//	        int adjustedCalories = adjustedQuality * foodItem.getCalories();
//
//	        // Create a new caloirintake object
//	        caloirintake intake = new caloirintake();
//	        intake.setName(foodItem.getName()); // Set the name from Fooditeam
//	        intake.setQuality(adjustedQuality); // Set the calculated quality
//	        intake.setCalories(adjustedCalories); // Set the calculated calories
//	        intake.setMealType(mealType);
//	        intake.setConsumedDate(consumedDate);
//	        intake.setUser(user);
//
//	        // Save the caloirintake object to the database
//	        return calorieIntakeRepository.save(intake);
//	    }
	//}

//	public caloirintake createCaloirintake(String foodName, int userQuality, String mealType, LocalDate consumedDate,
//			User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//    public List<Fooditeam> getFoodItemsByUserAndDate(User user, LocalDate date) {
//        // Assuming that you have a method to filter food items by date for a specific user
//        return foodRepository.findByUser(user).stream()
//                .filter(food -> date.equals(food.getConsumedDate()))
//                .collect(Collectors.toList());
//    }

//    public Caloricfooddto calculateCalories(Caloricfooddto caloricCalculatiodto) {
//        List<Fooditeam> foodItems = getFoodItemsByUserAndDate(user, consumedDate);
//
//        // Find the specific food item by name
//        Fooditeam foodItem = foodItems.stream()
//                .filter(item -> item.getName().equalsIgnoreCase(foodName))
//                .findFirst()
//                .orElse(null);
//
//        if (foodItem == null) {
//            throw new RuntimeException("Food item not found for name: " + foodName);
//        }
//
//        // Calculate the adjusted calories based on user-provided quality
//        int adjustedCalories = foodItem.getCalories() * userQuality;
//
//        // Create a DTO to return the result, including mealType
//        return new Caloricfooddto(foodItem.getName(), userQuality, adjustedCalories, consumedDate, mealType);
//    }
//    
//}
//public Caloricfooddto calculateCalories(String foodName, int userQuality, User user, LocalDate consumedDate, String mealType) {
//    // Retrieve the list of food items by user and date
//    List<Fooditeam> foodItems = getFoodItemsByUserAndDate(user, consumedDate);
//
//    // Find the specific food item by name
//    Fooditeam foodItem = foodItems.stream()
//            .filter(item -> item.getName().equalsIgnoreCase(foodName))
//            .findFirst()
//            .orElse(null);
//
//    if (foodItem == null) {
//        throw new RuntimeException("Food item not found for name: " + foodName);
//    }
//
//    // Calculate the adjusted calories based on user-provided quality
//    int adjustedCalories = foodItem.getCalories() * userQuality;
//
//    // Create a DTO to return the result, including mealType
//    return new Caloricfooddto(foodItem.getName(), userQuality, adjustedCalories, user.getId(), consumedDate, mealType);
//}
//    public Caloricfooddto calculateCalories(String foodName, int userQuality, User user, LocalDate consumedDate, String mealType) {
//        List<Fooditeam> foodItems = getFoodItemsByUserAndDate(user, consumedDate);
//
//        Fooditeam foodItem = foodItems.stream()
//                .filter(item -> item.getName().equalsIgnoreCase(foodName))
//                .findFirst()
//                .orElse(null);
//
//        if (foodItem == null) {
//            throw new RuntimeException("Food item not found for name: " + foodName);
//          //  System.out.print("amose");
//        }
//
//        int adjustedCalories = foodItem.getCalories() * userQuality;
//
//        return new Caloricfooddto(foodItem.getName(), userQuality, adjustedCalories, user.getId(), consumedDate, mealType);
//    }

    }
