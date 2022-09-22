package com.example.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.JwtUser;
import com.example.repository.JwtUserRepository;
import com.example.util.JwtTokenUtil;
@Service
public class JwtUserServiceImpl implements UserDetailsService {
	@Autowired
	private JwtUserServiceImpl userServiceImpl;
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	// for existing users
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody JwtUser jwtUser){
		String username = jwtUser.getUsername();
		String password = jwtUser.getPassword();
		authenticate(username,password);
		// check if name exists
		UserDetails user = userServiceImpl.loadUserByUsername(username);
		// generate the  token and return it
		String token = jwtTokenUtil.generateToken(user);
		return ResponseEntity.ok(token);
	}
  
  private void authenticate(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			}catch(DisabledException e) {
				System.out.println("user disabled");
			}catch(BadCredentialsException e) {
				System.out.println("Invalid credentials");
			}
		
	}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	return null;
}
	}


