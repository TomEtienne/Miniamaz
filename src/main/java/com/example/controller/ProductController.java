package com.example.controller;

import com.example.dto.UserDAOHibernate;
import com.example.dto.UserDto;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/api/")
public class ProductController {

    private ProductServiceImp productService;

    @Autowired
    public ProductController(ProductServiceImp productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {	
        return ResponseEntity.ok().body(productService.findAll());
    }
    
    @GetMapping("products/{productId}")
    public Product findById(@PathVariable Long productId) throws EntityNotFoundException {
    	Product p = productService.findById(productId);
        return p;
    }

    @PostMapping("/product/create")
    //@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product p = productService.createProduct(product);
        if (p != null) {
        	return ResponseEntity.ok().body(p);
        } else {
        	return ResponseEntity.badRequest().body("Label already used");
        }
    }
    
    @PutMapping("/products/{productId}")
    public ResponseEntity updateProduct(@PathVariable Long productId, @RequestBody Product body) {
        Product product = productService.findById(productId);
        if(product != null) {
        	return ResponseEntity.ok().body(productService.updateProduct(body));
        } else {
        	return ResponseEntity.badRequest().body("Product not found");
        }
    }
    
    @DeleteMapping("/products/{productId}")
    public void delete(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

}
