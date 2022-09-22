package com.example.model;

import javax.persistence.Entity;

@Entity
public class JwtUser {

	private String username;
	private String password;
	private Integer userId;
	public JwtUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JwtUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "JwtUser [username=" + username + ", password=" + password + ", userId=" + userId + "]";
	}

}
