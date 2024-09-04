package com.myfitness.Dto;

import java.time.LocalDate;

public class Display1dto {
	   private Long id;
		 private LocalDate consumedDate;
		 private int caloriesburning;
		 private String name;
		    public Display1dto() {
			super();
		}
//			public Display1dto(Long id, LocalDate consumedDate, int caloriesburning, String name, int minutes) {
//			super();
//			this.id = id;
//			this.consumedDate = consumedDate;
//			this.caloriesburning = caloriesburning;
//			this.name = name;
//			this.minutes = minutes;
//		}
			  public Display1dto(Long id, String name, int caloriesburning, int minutes, LocalDate consumedDate) {
			        this.id = id;
			        this.name = name;
			        this.caloriesburning = caloriesburning;
			        this.minutes = minutes;
			        this.consumedDate = consumedDate;
			    }
			public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDate getConsumedDate() {
			return consumedDate;
		}
		public void setConsumedDate(LocalDate consumedDate) {
			this.consumedDate = consumedDate;
		}
		public int getCaloriesburning() {
			return caloriesburning;
		}
		public void setCaloriesburning(int caloriesburning) {
			this.caloriesburning = caloriesburning;
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
			private int minutes; 
}
