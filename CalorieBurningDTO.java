package com.myfitness.Dto;

import java.time.LocalDate;

public class CalorieBurningDTO {
	  private String workName;
	    private int userMinutes;
	    private LocalDate consumedDate; 
	   // private String consumedDate;
	    private Long userId;
		public String getWorkName() {
			return workName;
		}
		public void setWorkName(String workName) {
			this.workName = workName;
		}
		public int getUserMinutes() {
			return userMinutes;
		}
		public void setUserMinutes(int userMinutes) {
			this.userMinutes = userMinutes;
		}
		
		public LocalDate getConsumedDate() {
			return consumedDate;
		}
		public void setConsumedDate(LocalDate consumedDate) {
			this.consumedDate = consumedDate;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}

}
