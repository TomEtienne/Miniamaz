package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.model.Inventory;
import com.example.repository.InventoryRepository;

@Component
public class InventoryServiceImp implements InventoryService {

	private InventoryRepository inventoryRepository;
	
	@Autowired
	public InventoryServiceImp(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	@Override
	public List<Inventory> findAll() {
		return inventoryRepository.findAll();
	}

	@Override
	public Inventory findById(Long id) {
		return inventoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Inventory " + id + "not found")
        );
	}

	@Override
	public Inventory createInventory(Inventory inventory) {
		if (inventoryRepository.existsById(inventory.getId())) {
            throw new EntityExistsException("Inventory " + inventory.getId() + " already exists");
        }
        return inventoryRepository.saveAndFlush(inventory.setCreationDate(LocalDateTime.now()));
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		if (!inventoryRepository.existsById(inventory.getId())) {
            throw new EntityNotFoundException("Inventory " + inventory.getId() + " not found");
        }
        return inventoryRepository.saveAndFlush(inventory);
	}

	@Override
	public void deleteInventory(Long inventoryId) {
		if (!inventoryRepository.existsById(inventoryId)) {
            throw new EntityNotFoundException("Inventory " + inventoryId + " not found");
        }
        inventoryRepository.deleteById(inventoryId);
	}

}
