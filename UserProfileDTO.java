package com.myfitness.maindto;

import java.util.Set;

public class UserProfileDTO {
	  private Long id;
	    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Set<FoodDTO> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(Set<FoodDTO> foodItems) {
		this.foodItems = foodItems;
	}
	public Set<WorkoutDTO> getWorkouts() {
		return workouts;
	}
	public void setWorkouts(Set<WorkoutDTO> workouts) {
		this.workouts = workouts;
	}
		private String username;
	    private String gender;
	    private String email;
	    private int age;
	    private Double weight;
	    private Double height;
	    public UserProfileDTO() {
			super();
		}
		public UserProfileDTO(Long id, String username, String gender, String email, int age, Double weight,
				Double height, Set<FoodDTO> foodItems, Set<WorkoutDTO> workouts) {
			super();
			this.id = id;
			this.username = username;
			this.gender = gender;
			this.email = email;
			this.age = age;
			this.weight = weight;
			this.height = height;
			this.foodItems = foodItems;
			this.workouts = workouts;
		}
		private Set<FoodDTO> foodItems;
	    private Set<WorkoutDTO> workouts;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Double getHeight() {
			return height;
		}
		public void setHeight(Double height) {
			this.height = height;
		}
}
