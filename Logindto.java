package com.myfitness.Dto;

public class Logindto {
	
	private String Username;
	public Logindto(String username, String password) {
		super();
		Username = username;
		this.password = password;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
}
