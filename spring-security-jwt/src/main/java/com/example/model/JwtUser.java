package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JwtUser {
private String username;
private String passWord;
@Id
@GeneratedValue
private Integer userId;

public JwtUser(String username, String passWord) {
	super();
	this.username = username;
	this.passWord = passWord;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
@Override
public String toString() {
	return "JwtUser [username=" + username + ", passWord=" + passWord + ", userId=" + userId + "]";
}


}
