package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.JwtUser;
import com.example.service.JwtServiceImpl;

@Controller
public class JwtAuthController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtServiceImpl jwtServiceImpl;

	@PostMapping("/register")
	public void addUser(@RequestBody JwtUser jwtUser)
	{
		String username=jwtUser.getUsername();
		String password=jwtUser.getPassWord();
		//encode password
		String encodedPassword=encoder.encode(password);
		JwtUser jwtUser2=new JwtUser(username, encodedPassword);
		jwtServiceImpl.addUser(jwtUser2);
	}
}
