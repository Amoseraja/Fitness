package com.myfitness.repo;

import java.util.List;

import com.myfitness.Dto.Workoutdto;

import com.myfitness.Entity.User;
import com.myfitness.Entity.Workout;

public interface workserive {
	 Workout addFoodItem(Workoutdto workoutdto, User user);
	
	    void deleteworkout(Long id);

}
