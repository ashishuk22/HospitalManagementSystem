package com.Arc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arc.hospital.entity.User;

public interface Userrepo extends JpaRepository<User, Long> {
      
	User findByUsername(String username);
}
