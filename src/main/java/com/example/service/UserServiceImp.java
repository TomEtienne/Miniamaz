package com.example.service;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements UserDetailsService, UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

	private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User findById(Long id) throws EntityNotFoundException {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product " + id + "not found")
        );
    }
    
    // Create user
    public User createUser(User user) throws EntityExistsException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }
 
    // Update User
    public User updateUser(User user) throws EntityNotFoundException {
    	return userRepository.saveAndFlush(user);
    }
    
    // Delete User
    public void deleteUser(Long userId) throws EntityNotFoundException {
    	userRepository.deleteById(userId);
    }
}
