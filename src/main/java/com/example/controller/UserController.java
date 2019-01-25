package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/")
public class UserController {

    private UserServiceImp userService;

    @Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> findAll() {	
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/users/create")
    //@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity createUser(@RequestBody User user) {
        System.out.println("test");
        return ResponseEntity.ok().body(userService.createUser(user));
    }
    
    @PutMapping("/users/{userId}")
    public ResponseEntity updateUser(@PathVariable Long userId) {
        User userUpdate = userService.findById(userId);
        return ResponseEntity.ok().body(userService.updateUser(userUpdate));
    }
    
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}
