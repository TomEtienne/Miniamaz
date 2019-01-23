package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public String test(){
        return "It works";
    }

    /*
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Product> getAllProducts() {
		return productService.findAll();
	} */

}
