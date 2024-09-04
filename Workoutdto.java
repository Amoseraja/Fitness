package com.myfitness.Dto;

public class Workoutdto {

    private String name;
    private String workpicture;
    
    private int minutes;  
    private int caloriesburning;
    public Workoutdto() {
		super();
	}
	public Workoutdto(String name, String workpicture, int minutes, int caloriesburning, Long userId) {
		super();
		this.name = name;
		this.workpicture = workpicture;
		this.minutes = minutes;
		this.caloriesburning = caloriesburning;
		this.userId = userId;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	private Long userId; 

}
