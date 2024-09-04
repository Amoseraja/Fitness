package com.myfitness.Serivce;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.myfitness.Dto.Caloricfooddto;
import com.myfitness.Entity.User;
import com.myfitness.Entity.caloirintake;
import com.myfitness.repo.CalorieIntakeRepository;
import com.myfitness.repo.FooditeamRepository;
import com.myfitness.repo.UserRepository;

public class Calorisintake {
	 @Autowired
		private UserRepository  userRepository;
	 @Autowired
	    private FooditeamRepository foodRepository;
	 
	 @Autowired
	    private  CalorieIntakeRepository calorieRepository;
	   public List<caloirintake> getFoodItemsByUserAndDate(User user, LocalDate date) {      // Assuming that you have a method to filter food items by date for a specific user
     return calorieRepository.findByUserId(user).stream()
             .filter(food -> date.equals(food.getConsumedDate()))
              .collect(Collectors.toList());
  }
//	   public Caloricfooddto calculateCalories(String foodName, int userQuality, User user, LocalDate consumedDate, String mealType) {
//        List<Fooditeam> foodItems = getFoodItemsByUserAndDate(user, consumedDate);
//        List<caloirintake> foodItems1 = getFoodItemsByUserAndDate(user, consumedDate);
//        Fooditeam foodItem = foodItems.stream()
//	                .filter(item -> item.getName().equalsIgnoreCase(foodName))
//	                .findFirst()
//	                .orElse(null);
//	
//        if (foodItem == null) {
//	            throw new RuntimeException("Food item not found for name: " + foodName);
//	          //  System.out.print("amose");
//	        }
//	
//        int adjustedCalories = foodItem.getCalories() * userQuality;
//	
//        return new Caloricfooddto(foodItem.getName(), userQuality, adjustedCalories, user.getId(), consumedDate, mealType);
///	    }


}
