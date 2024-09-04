package com.myfitness.Dto;

import java.time.LocalDate;

public class Displaydto {
	  private Long id;
	    private String name;
	    private int quality;
	    private int calories;
	    private String mealType;
	    private LocalDate consumedDate;
		public Displaydto(Long id, String name, int quality, int calories, String mealType, LocalDate consumedDate) {
			super();
			this.id = id;
			this.name = name;
			this.quality = quality;
			this.calories = calories;
			this.mealType = mealType;
			this.consumedDate = consumedDate;
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
}
