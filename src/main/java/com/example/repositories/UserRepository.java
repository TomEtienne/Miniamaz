package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	 List<User> findByLastName(String lastName);
}