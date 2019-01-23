package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByLabel(String label);
    
    Product findByLabel(String label);
}