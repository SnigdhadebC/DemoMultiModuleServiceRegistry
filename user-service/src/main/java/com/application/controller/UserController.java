package com.application.controller;

import com.application.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private List<com.application.model.User> users = Arrays.asList(
            new User("test","test"),
            new User("admin","admin")
    );


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
        return ResponseEntity.ok().body(
                users.stream()
                        .filter(u -> u.getUserId().equalsIgnoreCase(userId))
                        .findAny()
                        .orElse(null)
        );
    }
 }
