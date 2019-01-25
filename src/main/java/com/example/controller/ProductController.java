package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/product")
public class ProductController {

    private ProductServiceImp productService;

    @Autowired
    public ProductController(ProductServiceImp productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {	
        return ResponseEntity.ok().body(productService.findAll());
    }

    @PostMapping("/product/create")
    //@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }
    
    @PutMapping("/product/{productId}")
    public ResponseEntity updateProduct(@PathVariable Long productId) {
        Product product = productService.findById(productId);
        return ResponseEntity.ok().body(productService.updateProduct(product));
    }
    
    @DeleteMapping("/product/{productId}")
    public void delete(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

}
