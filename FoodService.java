package com.myfitness.repo;

import java.util.List;

import com.myfitness.Dto.Fooddto;
import com.myfitness.Entity.Fooditeam;
import com.myfitness.Entity.User;

public interface FoodService {
	 Fooditeam addFoodItem(Fooddto fooddto, User user);
	    Fooditeam updateFoodItem(Long id, Fooddto fooddto);
	    void deleteFoodItem(Long id);
	    Fooditeam getFoodItemById(Long id);
	    List<Fooditeam> getAllFoodItemsForUser(User user);
}
