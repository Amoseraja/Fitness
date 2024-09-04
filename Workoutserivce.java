package com.myfitness.Serivce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.Dto.Workoutdto;
import com.myfitness.Entity.Fooditeam;
import com.myfitness.Entity.User;
import com.myfitness.Entity.Workout;

import com.myfitness.repo.WorkoutRepository;
import com.myfitness.repo.workserive;
@Service
public class Workoutserivce implements  workserive  {
	 @Autowired
	    private WorkoutRepository  workoutRepository;
	
	 @Autowired
	    private fitneesservice  userService1;

	@Override
	public Workout addFoodItem(Workoutdto workoutdto, User user) {
		// TODO Auto-generated method stub
		Workout foodItem = new Workout();
	        foodItem.setName(workoutdto.getName());
	        foodItem.setCaloriesburning(workoutdto.getCaloriesburning());
	        foodItem.setMinutes(workoutdto.getMinutes());
	        foodItem.setWorkpicture(workoutdto.getWorkpicture());
	        foodItem.setUser(user);

	        return workoutRepository.save(foodItem);
		
	}

	

	
    // Get a workout by its ID
    public Optional<Workout> getWorkoutById(Long id) {
        return workoutRepository.findById(id);
    }

    // Get all workouts for a specific user
    public List<Workout> getAllWorkoutsForUser(User user) {
        return workoutRepository.findByUser(user);
    }

    // Get all workouts by user ID
    public List<Workout> getWorkoutsByUserId(Long userId) {
        User user = userService1.getUserById(userId); // Assuming userService1 has a method to get User by ID
        return workoutRepository.findByUser(user);
    }




	@Override
	public void deleteworkout(Long id) {
		// TODO Auto-generated method stub
		 workoutRepository.deleteById(id);
		
	}



	
	



	


	
}