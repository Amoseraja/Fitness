package com.myfitness.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class totalCalorierburing {
	 public totalCalorierburing(Long id, Long userId, LocalDate consumedDate, double totalCalories) {
		super();
		this.id = id;
		this.userId = userId;
		this.consumedDate = consumedDate;
		this.totalCalories = totalCalories;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public LocalDate getConsumedDate() {
		return consumedDate;
	}
	public void setConsumedDate(LocalDate consumedDate) {
		this.consumedDate = consumedDate;
	}
	public double getTotalCalories() {
		return totalCalories;
	}
	public void setTotalCalories(double totalCalories) {
		this.totalCalories = totalCalories;
	}
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    public totalCalorierburing() {
		super();
	}
		private Long userId;
	    private LocalDate consumedDate;
	    private double totalCalories;
}
