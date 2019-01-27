package com.example.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Inventory;
import com.example.model.Product;
import com.example.service.InventoryService;
import com.example.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/api/")
public class InventoryController {
	private InventoryService inventoryService;

	@Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventories")
    public ResponseEntity<List<Inventory>> findAll() {	
        return ResponseEntity.ok().body(inventoryService.findAll());
    }
    
    @GetMapping("inventories/{inventoryId}")
    public Inventory findById(@PathVariable Long inventoryId) throws EntityNotFoundException {
    	Inventory i = inventoryService.findById(inventoryId);
        return i;
    }

    @PostMapping("/inventory/create")
    //@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity createInventory(@RequestBody Inventory inventory) {
    	Inventory i = inventoryService.createInventory(inventory);
        if (i != null) {
        	return ResponseEntity.ok().body(i);
        } else {
        	return ResponseEntity.badRequest().body("Label already used");
        }
    }
    
    @PutMapping("/inventories/{inventoryId}")
    public ResponseEntity updateInventory(@PathVariable Long inventoryId, @RequestBody Inventory body) {
    	Inventory inventory = inventoryService.findById(inventoryId);
        if(inventory != null) {
        	return ResponseEntity.ok().body(inventoryService.updateInventory(body));
        } else {
        	return ResponseEntity.badRequest().body("Product not found");
        }
    }
    
    @PutMapping("/{inventoryId}/addProduct/{quantity}")
    public ResponseEntity addProduct(@PathVariable("inventoryId") Long inventoryId,
    		@PathVariable("productId") Integer quantity,
    		@RequestBody Product body) {
    	Inventory inventory = inventoryService.findById(inventoryId);
        if(inventory != null) {
        	inventory.addProducts(body.getId(), quantity);
        	return ResponseEntity.ok().body(this.inventoryService.updateInventory(inventory));
        } else {
        	return ResponseEntity.badRequest().body("Error");
        }
    }
    
    
    
    @DeleteMapping("/inventories/{inventoryId}")
    public void delete(@PathVariable Long inventoryId) {
    	inventoryService.deleteInventory(inventoryId);
    }

}
