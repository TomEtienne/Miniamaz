package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.UserServiceImp;
import com.example.dto.UserDAOHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

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

    @GetMapping("/users")
    public ResponseEntity<?> findAll() {
    	ArrayList<User> list = (ArrayList<User>) userService.findAll();
    	ArrayList<UserDto> res = new ArrayList<UserDto>();
    	list.forEach(user -> res.add(UserDAOHibernate.createDTO(user)));
    	System.out.println(res);
        return ResponseEntity.ok().body(res);
    }
    
    @GetMapping("users/{id}")
    public User findById(@PathVariable Long id) throws EntityNotFoundException {
        return userService.findById(id);
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
