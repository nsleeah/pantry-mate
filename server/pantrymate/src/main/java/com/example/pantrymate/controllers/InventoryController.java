package com.example.pantrymate.controllers;

import com.example.pantrymate.models.Inventory;
import com.example.pantrymate.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping()
    public Iterable<Inventory> getInventories() {
        Iterable<Inventory> inventory = inventoryService.getAllInventories();
        return inventory;
    }

    @GetMapping("/{id}")
    public Inventory getInventoriesById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    @PostMapping("/addNew") //Not Working
    public String addNewInventory(@RequestBody Inventory inventory) {
        Inventory newInventory = new Inventory(inventory.getProduct(), inventory.getFoodBank(), inventory.getQuantity());
        inventoryService.addNewInventory(newInventory);
        return "New Inventory successfully added!";
    }

    @PutMapping("/update/{id}") //Not Working
    public ResponseEntity<String> updateInventory(@PathVariable("id") Long id, @RequestBody Inventory inventory) {
        inventory.setId(id);
        Inventory updatedInventory = inventoryService.updateInventory(inventory);
        if (updatedInventory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Inventory updated!");
    }

    @DeleteMapping("/{id}") //Working
    public String deleteInventory(@PathVariable("id") Long id) {
        inventoryService.deleteInventory(id);
        return "Inventory successfully deleted!";
    }



}
