package com.example.service;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.model.Product;
import com.example.model.User;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

	private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create user
    public User createUser(User user) throws EntityExistsException {
        /* if(userRepository.existsById(user.getUserId())) {
            throw new EntityExistsException("Product" + user.getUserId() + "not created cause already exists");
        } */
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
}
