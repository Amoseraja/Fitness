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
public class caloirintake {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    private String name;
	    private int quality;  // Assuming you meant "quality" instead of "qualitity"
	    private int calories;
	    
	    //private LocalDate date;
	    private String mealType;
	   private LocalDate consumedDate;
	    public caloirintake(Long id, String name, int quality, int calories, String mealType, LocalDate consumedDate,
			User user) {
		super();
		this.id = id;
		this.name = name;
		this.quality = quality;
		this.calories = calories;
		this.mealType = mealType;
		this.consumedDate = consumedDate;
		this.user = user;
	}
		public caloirintake() {
			super();
		}
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
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public LocalDate getConsumedDate() {
		return consumedDate;
	}
	public void setConsumedDate(LocalDate consumedDate) {
		this.consumedDate = consumedDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
}
