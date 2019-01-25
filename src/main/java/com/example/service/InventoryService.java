package com.example.service;

import java.util.List;
import com.example.model.Inventory;

public interface InventoryService {

	List<Inventory> findAll();
	
	Inventory findById(Long id);
	
	Inventory createInventory(Inventory inventory);
	
	Inventory updateInventory(Inventory inventory);
	
	void deleteInventory(Long inventoryId);
}
