package com.example.service;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
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

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(UUID id) throws EntityNotFoundException {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product " + id + "not found")
        );
    }

    public List<Product> findAllByLabel(String label) {
        return productRepository.findAll(label);
    }

    public Product createProduct(Product product) throws EntityExistsException {
        if (productRepository.existsById(product.getId())) {
            throw new EntityExistsException("Product " + product.getId() + "already exists");
        }
        return productRepository.saveAndFlush(product);
    }

    public Product updateProduct(Product product) throws EntityNotFoundException {
        if (!productRepository.existsById(product.getId())) {
            throw new EntityNotFoundException("Product " + product.getId() + "not found");
        }
        return productRepository.saveAndFlush(product);
    }

    public void deleteProduct(UUID productId) throws EntityNotFoundException {
        if (!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("Product " + productId + "not found");
        }
        productRepository.deleteById(productId);
    }
}