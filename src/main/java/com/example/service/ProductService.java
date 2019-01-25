package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(Long id);
	
	Product createProduct(Product product);
	
	Product updateProduct(Product product);
	
	void deleteProduct(Long idProduct);
	
	Product findByName(String label);
}
