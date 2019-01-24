package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.persistence.EntityNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {	
        return ResponseEntity.ok().body(productService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/name/{label}")
    public ResponseEntity<Product> findById(@PathVariable String label) throws EntityNotFoundException{
    	return ResponseEntity.ok().body(productService.findByName(label));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) throws EntityNotFoundException{
        return ResponseEntity.ok().body(productService.findById(id));
    }

}
