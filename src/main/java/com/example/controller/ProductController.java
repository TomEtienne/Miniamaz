package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    private ProductService productRepository;

    @Autowired
    public ProductController(ProductService productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path="/all")
	public @ResponseBody Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
