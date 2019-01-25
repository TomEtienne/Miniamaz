package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
public class Inventory {
    @Id
    private Long id;

    private String label;

    private LocalDateTime creationDate;

    private LocalDateTime closureDate;

    private HashMap<Long, Integer> quantities;

    public Long getId() {
        return id;
    }

    public Inventory setId(Long id) {
        this.id = id;
        return this;
    }

    public Optional<String> getLabel() {
        return Optional.ofNullable(label);
    }

    public Inventory setLabel(String label) {
        this.label = label;
        return this;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Inventory setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public LocalDateTime getClosureDate() {
        return closureDate;
    }

    public Inventory setClosureDate(LocalDateTime closureDate) {
        this.closureDate = closureDate;
        return this;
    }

    public boolean isClosed() {
        if (closureDate == null) {
            return false;
        }
        return (closureDate.compareTo(LocalDateTime.now()) <= 0);
    }

    public HashMap<Long, Integer> getQuantities() {
        return quantities;
    }

    public Inventory setQuantities(HashMap<Long, Integer> quantities) {
        this.quantities = quantities;
        return this;
    }

    public int getQuantityOf(Long productId) {
        Integer quantity = quantities.getOrDefault(productId, 0);
        return (quantity == null) ? 0 : quantity;
    }

    public Inventory addProducts(Long productId, int quantity) {
        if (quantities.containsKey(productId)) {
            int stock = getQuantityOf(productId);
            quantities.replace(productId, stock + quantity);
        } else {
            quantities.put(productId, quantity);
        }
        return this;
    }

    public Inventory addProduct(Long productId) {
        return addProducts(productId, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) &&
                Objects.equals(label, inventory.label) &&
                Objects.equals(creationDate, inventory.creationDate) &&
                Objects.equals(closureDate, inventory.closureDate) &&
                Objects.equals(quantities, inventory.quantities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, creationDate, closureDate, quantities);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", creationDate=" + creationDate +
                ", closureDate=" + closureDate +
                ", quantities=" + quantities +
                '}';
    }
}
