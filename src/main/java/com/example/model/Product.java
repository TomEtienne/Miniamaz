package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name="product")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String label;

    @PositiveOrZero
    private Float price;
    
    public Product() {

    }
    
    public Product(String label, Float price) {
    	this.label = label;
    	this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Product setLabel(String label) {
        this.label = label;
        return this;
    }

    public Optional<Float> getPrice() {
        return Optional.ofNullable(price);
    }

    public Product setPrice(Float price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", price=" + price +
                '}';
    }
}
