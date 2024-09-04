package com.myfitness.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class caloirburing {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 private LocalDate consumedDate;
	 private int caloriesburning;
	    public caloirburing(Long id, LocalDate consumedDate, String name, int minutes, User user) {
		super();
		this.id = id;
		this.consumedDate = consumedDate;
		this.name = name;
		this.minutes = minutes;
		this.user = user;
	}
		public caloirburing() {
			super();
		}
		public caloirburing(Long id, LocalDate consumedDate, int caloriesburning, String name, int minutes, User user) {
			super();
			this.id = id;
			this.consumedDate = consumedDate;
			this.caloriesburning = caloriesburning;
			this.name = name;
			this.minutes = minutes;
			this.user = user;
		}
		public int getCaloriesburning() {
			return caloriesburning;
		}
		public void setCaloriesburning(int caloriesburning) {
			this.caloriesburning = caloriesburning;
		}
		public LocalDate getConsumedDate() {
		return consumedDate;
	}
	public void setConsumedDate(LocalDate consumedDate) {
		this.consumedDate = consumedDate;
	}
		private String name;
	   
	    
	    private int minutes; 
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
		public int getMinutes() {
			return minutes;
		}
		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public caloirburing(Long id, String name, int minutes, User user) {
			super();
			this.id = id;
			this.name = name;
			this.minutes = minutes;
			this.user = user;
		}
}
