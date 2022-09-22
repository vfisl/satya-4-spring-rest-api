package com.example.cnntrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.JwtUser;
import com.example.service.JwtUserServiceImpl;

@RestController
public class JwtAuthControler {
	private JwtUserServiceImpl jwtUserServiceImpl;

	private PasswordEncoder encoder;
	 @Autowired
	 private JwtUserServiceImpl serviceImpl;
	 @PostMapping("/authenticate")
	  public ResponseEntity<String>authenticate(@RequestBody JwtUser user);
	 {
		 return null;
	 }
	 @PostMapping("/register")
	 public ResponseEntity<String>register(@RequestBody JwtUser user)
	 {
		 String password=user.getPassword();
		 String newpass=encoder.encode(password);
		 String uname=user.getUsername();
		 JwtUser newUser=new JwtUser(uname,newpass);
		 jwtUserServiceImpl.addUser(newUser);
		 return ResponseEntity.ok("registered");
		 
	 }
}
