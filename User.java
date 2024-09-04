package com.myfitness.Entity;

import java.net.URL;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
	 public User() {
		super();
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	private String username;
	
	private String password;
	private String gender;
	private String email;
	


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}
	private String Phone;
	private  int age ;
	private String role;
	private double weight;
	  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Workout> workouts;

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Fooditeam> foodItems;
	    



	public Set<Workout> getWorkouts() {
			return workouts;
		}


		public void setWorkouts(Set<Workout> workouts) {
			this.workouts = workouts;
		}


		public Set<Fooditeam> getFoodItems() {
			return foodItems;
		}


		public void setFoodItems(Set<Fooditeam> foodItems) {
			this.foodItems = foodItems;
		}


	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public User(Long id, String username, String password, String gender, String email, String phone, int age,
			String role, double weight, Set<Workout> workouts, Set<Fooditeam> foodItems, double height, String goals,
			URL profitpicture, String activityLevel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.email = email;
		Phone = phone;
		this.age = age;
		this.role = role;
		this.weight = weight;
		this.workouts = workouts;
		this.foodItems = foodItems;
		this.height = height;
		this.goals = goals;
		this.profitpicture = profitpicture;
		this.activityLevel = activityLevel;
	}
	private double height;
    private String goals;
    private URL profitpicture;
    private String activityLevel;
   


	public URL getProfitpicture() {
		return profitpicture;
	}


	public void setProfitpicture(URL profitpicture) {
		this.profitpicture = profitpicture;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getActivityLevel() {
		return activityLevel;
	}


	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	

}
