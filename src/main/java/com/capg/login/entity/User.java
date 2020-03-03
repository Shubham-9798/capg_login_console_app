package com.capg.login.entity;

public class User {
	private String username;
	private String password;
	private String type;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.type = null;
	}
	
	public User(String username, String password, String type) {
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getType() {
		return type;
	}

	
	
}
