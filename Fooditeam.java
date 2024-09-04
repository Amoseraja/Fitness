package com.myfitness.Entity;


import java.net.URL;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Fooditeam {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    private String name;
	    private int quality;  // Assuming you meant "quality" instead of "qualitity"
	    private int calories;
	    private int protein;  // Correcting the spelling of "protien" to "protein"
	    private int carb;
	    private int fat;
	    private String footpicture;
	    //private LocalDate date;

	   // private LocalDate consumedDate;




//		public Fooditeam(Long id, String name, int quality, int calories, int protein, int carb, int fat,
//				String footpicture, LocalDate consumedDate, String mealType, User user) {
//			super();
//			this.id = id;
//			this.name = name;
//			this.quality = quality;
//			this.calories = calories;
//			this.protein = protein;
//			this.carb = carb;
//			this.fat = fat;
//			this.footpicture = footpicture;
//			this.consumedDate = consumedDate;
//			this.mealType = mealType;
//			this.user = user;
//		}




		public String getMealType() {
			return mealType;
		}




		public void setMealType(String mealType) {
			this.mealType = mealType;
		}

		private String mealType; // Example values: "breakfast", "lunch", "dinner"
		public Fooditeam() {
			super();
		}
	

		
		
		public Fooditeam(Long id, String name, int quality, int calories, int protein, int carb, int fat,
				String footpicture, User user) {
			super();
			this.id = id;
			this.name = name;
			this.quality = quality;
			this.calories = calories;
			this.protein = protein;
			this.carb = carb;
			this.fat = fat;
			this.footpicture = footpicture;
			this.user = user;
		}




		public String getFootpicture() {
			return footpicture;
		}




		public void setFootpicture(String footpicture) {
			this.footpicture = footpicture;
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

		public int getProtein() {
			return protein;
		}

		public void setProtein(int protein) {
			this.protein = protein;
		}

		public int getCarb() {
			return carb;
		}

		public void setCarb(int carb) {
			this.carb = carb;
		}

		public int getFat() {
			return fat;
		}

		public void setFat(int fat) {
			this.fat = fat;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

//		public LocalDate getConsumedDate() {
//			return consumedDate;
//		}
//
//
//
//
//		public void setConsumedDate(LocalDate consumedDate) {
//			this.consumedDate = consumedDate;
//		}

		@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

	 


}
