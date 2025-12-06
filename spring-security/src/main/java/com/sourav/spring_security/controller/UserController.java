package com.sourav.spring_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.spring_security.model.User;
import com.sourav.spring_security.service.JWTService;
import com.sourav.spring_security.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager
                                            .authenticate(new UsernamePasswordAuthenticationToken(
                                                user.getUsername(), user.getPassword()
                                            ));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "Failure";
        }
    }

}
