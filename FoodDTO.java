package com.myfitness.maindto;

public class FoodDTO {
	   private Long id;
	    private String name;
	    private int quality;
	    private int calories;
	    private int protein;
	    private int carb;
	    private int fat;
	    private String footpicture;
	    private String mealType;
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
		public String getFootpicture() {
			return footpicture;
		}
		public void setFootpicture(String footpicture) {
			this.footpicture = footpicture;
		}
		public String getMealType() {
			return mealType;
		}
		public void setMealType(String mealType) {
			this.mealType = mealType;
		}
}
