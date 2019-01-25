package com.example.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.model.User;

public interface UserService {

	UserDetails loadUserByUsername(String email);
	
	List<User> findAll();
	
	User findById(Long id) ;
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long userId);
}
