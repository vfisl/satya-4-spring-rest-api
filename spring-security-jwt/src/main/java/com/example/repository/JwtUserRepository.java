package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.JwtUser;
@Repository
public interface JwtUserRepository extends JpaRepository<JwtUser, Integer> {

	JwtUser findByUsername(String username);
}
