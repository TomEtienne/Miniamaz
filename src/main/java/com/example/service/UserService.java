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

public class UserService {

	private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


	
}
