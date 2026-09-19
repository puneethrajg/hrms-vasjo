package com.vasjo.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasjo.hrms.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
}
