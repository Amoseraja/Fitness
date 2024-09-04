package com.myfitness.Dto;

import java.time.LocalDate;

public class Caloricfooddto {
	private String name;
    private int quality;  
    private int calories;
    private Long userId; 
    public Caloricfooddto(String name, int quality, int calories, Long userId, LocalDate consumedDate, String mealType) {
        super();
        this.name = name;
        this.quality = quality;
        this.calories = calories;
        this.userId = userId;
        this.consumedDate = consumedDate;
        this.mealType = mealType;
    }

//	public Caloricfooddto(String name, int quality, int calories, LocalDate consumedDate, String mealType) {
//		super();
//		this.name = name;
//		this.quality = quality;
//		this.calories = calories;
//		this.consumedDate = consumedDate;
//		this.mealType = mealType;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Caloricfooddto() {
		super();
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
//	public LocalDate getDate() {
//		return date;
//	}
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
//	private LocalDate date;

    public LocalDate getConsumedDate() {
		return consumedDate;
	}
	public void setConsumedDate(LocalDate consumedDate) {
		this.consumedDate = consumedDate;
	}

	private LocalDate consumedDate;
//    public Caloricfooddto(String name, int quality, int calories, Long userId, LocalDate consumedDate,
//			String mealType) {
//		super();
//		this.name = name;
//		this.quality = quality;
//		this.calories = calories;
//		this.userId = userId;
//		this.consumedDate = consumedDate;
//		this.mealType = mealType;
	//}

	private String mealType; // Added mealType for breakfast, lunch, or dinner
//  
	@Override
	public String toString() {
	    return "Caloricfooddto{" +
	           "name='" + name + '\'' +
	           ", quality=" + quality +
	           ", consumedDate=" + consumedDate +
	           ", mealType='" + mealType + '\'' +
	           '}';
	}

}
