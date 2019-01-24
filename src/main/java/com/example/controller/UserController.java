package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    //@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity registerUser(@RequestBody User user) {
        System.out.println("test");
        return ResponseEntity.badRequest().body(userService.createUser(user));

    }

}
