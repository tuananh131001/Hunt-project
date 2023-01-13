package com.s3864077.hunt.service;

import com.s3864077.hunt.model.Inventory;
import com.s3864077.hunt.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    public Page<Inventory> getAllInventories(Pageable pageable) {
        Page<Inventory> inventories = inventoryRepository.findAll(pageable);

        return inventories;
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(Long id, Inventory updatedInventory) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        if (inventory.isPresent()) {
            updatedInventory.setId(id);
            return inventoryRepository.save(updatedInventory);
        } else {
            return null;
        }

    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
