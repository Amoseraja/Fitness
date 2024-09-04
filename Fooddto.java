package com.myfitness.Dto;

import java.net.URL;

public class Fooddto {
	 private String name;
	    private int quality;  // Assuming you meant "quality" instead of "qualitity"
	    private int calories;
	    private int protein;  // Correcting the spelling of "protien" to "protein"
	    private int carb;
	    private int fat;
	    private String footpicture;
	    private Long userId; 
		public Fooddto() {
			super();
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

		public String getFootpicture() {
			return footpicture;
		}

		public void setFootpicture(String footpicture) {
			this.footpicture = footpicture;
		}

		public Fooddto(String name, int quality, int calories, int protein, int carb, int fat, String footpicture,
				long userId) {
			super();
			this.name = name;
			this.quality = quality;
			this.calories = calories;
			this.protein = protein;
			this.carb = carb;
			this.fat = fat;
			this.footpicture = footpicture;
			this.userId = userId;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}
}
