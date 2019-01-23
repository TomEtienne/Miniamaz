package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Display all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Get product by his Id
    public Product findById(UUID id) throws EntityNotFoundException {
        return productRepository.findById(id).orElseThrow(()
        -> new EntityNotFoundException("Product" + id + "not found")
        );
    }

    // Create product
    public Product createProduct(Product product) throws EntityExistsException {
        if(productRepository.existsById(product.getId())) {
            throw new EntityExistsException("Product" + product.getId() + "not created cause already exists");
        }
        return productRepository.saveAndFlush(product);
    }

    // Update product
    public Product updateProduct(Product product) throws EntityExistsException {
        if(productRepository.existsById(product.getId())) {
            throw new EntityExistsException("Product" + product.getId() + "not created cause already exists");
        }
        return productRepository.saveAndFlush(product);
    }

    // Update product
    public void deleteProduct(Product product) throws EntityExistsException {
        if(productRepository.existsById(product.getId())) {
            throw new EntityExistsException("Product" + product.getId() + "not created cause already exists");
        }
        productRepository.deleteById(product.getId());
    }

    //Get All products by name
    public Product findByName(String label) {
        return productRepository.findByLabel(label);
    }

}