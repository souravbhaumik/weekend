package com.sourav.spring.jobapp_rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.spring.jobapp_rest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
