package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    //@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity registerUser(@RequestBody User user) {
        System.out.println("test");
        return ResponseEntity.ok().body(userService.createUser(user));

    }
}
