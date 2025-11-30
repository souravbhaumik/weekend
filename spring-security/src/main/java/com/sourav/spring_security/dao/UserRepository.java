package com.sourav.spring_security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.spring_security.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
