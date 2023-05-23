package com.example.pantrymate.services;

import com.example.pantrymate.models.FoodBank;
import com.example.pantrymate.models.Inventory;
import com.example.pantrymate.repositories.FoodBankRepository;
import com.example.pantrymate.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    //CRUD

    //CREATE
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    //READ
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        return inventory.orElse(null);
    }

    //UPDATE
    public Inventory updateInventory(Inventory inventory) {
        Optional<Inventory> existingInventory = inventoryRepository.findById(inventory.getId());
        if (existingInventory.isPresent()){
            return inventoryRepository.save(inventory);
        } else {
            return null;
        }
    }


    //DELETE
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }



}
