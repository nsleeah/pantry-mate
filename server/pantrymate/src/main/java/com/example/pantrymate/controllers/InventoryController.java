package com.example.pantrymate.controllers;

import com.example.pantrymate.models.FoodBank;
import com.example.pantrymate.models.Inventory;
import com.example.pantrymate.models.Product;
import com.example.pantrymate.repositories.InventoryRepository;
import com.example.pantrymate.services.FoodBankService;
import com.example.pantrymate.services.InventoryService;
import com.example.pantrymate.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private FoodBankService foodBankService;

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/{id}")
    public Inventory getInventoriesById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateInventory(@PathVariable("id") Long id, @RequestBody Inventory inventory) {
        inventory.setId(id);
        Inventory updatedInventory = inventoryService.updateInventory(inventory);
        if (updatedInventory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Foodbank updated!");
    }

    @PostMapping("/addNew") //Working
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        //Inventory newInventory = inventoryService.addInventory(inventory);
        Inventory newInventory = inventoryRepository.save(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInventory);
    }



    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable("id") Long id) {
        inventoryService.deleteInventory(id);
        return "Inventory successfully deleted!";
    }



}
