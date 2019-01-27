package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class ProductServiceImp {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Display all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Get product by his Id
    public Product findById(Long id) throws EntityNotFoundException {
        return productRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("No Product found with id " + id));
    }

    // Create product
    public Product createProduct(Product product) throws EntityExistsException {
        if (productRepository.findByLabel(product.getLabel()) == null) {
			return productRepository.saveAndFlush(product);
		} else {
			return null;
		}
    }

    // Update product
    public Product updateProduct(Product product) throws EntityExistsException {
        return productRepository.saveAndFlush(product);
    }

    // Update product
    public void deleteProduct(Long idProduct) throws EntityExistsException {
        productRepository.deleteById(idProduct);
    }

    //Get product by name
    public Product findByName(String label) {
        return productRepository.findByLabel(label);
    }

}