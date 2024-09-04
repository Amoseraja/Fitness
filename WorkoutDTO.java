package com.myfitness.maindto;

public class WorkoutDTO {
	  private Long id;
	    private String name;
	    private String workpicture;
	    private int minutes;
	    private int caloriesburning;
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
		public int getCaloriesburning() {
			return caloriesburning;
		}
		public void setCaloriesburning(int caloriesburning) {
			this.caloriesburning = caloriesburning;
		}
}
