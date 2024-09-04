package com.myfitness.Entity;

import java.net.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Workout {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    private String name;
	    private String workpicture;
//    @Column(nullable = true) // or set a default value if needed
//    private Integer hour;

	    
	    private int minutes;  // Assuming you meant "quality" instead of "qualitity"
	    public Workout() {
			super();
		}
		public Workout(Long id, String name, String workpicture, int minutes, int caloriesburning, User user) {
			super();
			this.id = id;
			this.name = name;
			this.workpicture = workpicture;
			this.minutes = minutes;
			this.caloriesburning = caloriesburning;
			this.user = user;
		}
		private int caloriesburning;
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCaloriesburning() {
			return caloriesburning;
		}
		public void setCaloriesburning(int caloriesburning) {
			this.caloriesburning = caloriesburning;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getWorkpicture() {
			return workpicture;
		}
		public void setWorkpicture(String workpicture) {
			this.workpicture = workpicture;
		}
		public int getMinutes() {
			return minutes;
		}
		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}
}
