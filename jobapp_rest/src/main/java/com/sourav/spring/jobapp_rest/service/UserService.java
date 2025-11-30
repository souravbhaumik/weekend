package com.sourav.spring.jobapp_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sourav.spring.jobapp_rest.dao.UserRepository;
import com.sourav.spring.jobapp_rest.model.User;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return user != null ? userRepository.save(user) : null;
    }

}
