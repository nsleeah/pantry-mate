package com.example.pantrymate.controllers;

import com.example.pantrymate.models.FoodBank;
import com.example.pantrymate.models.Inventory;
import com.example.pantrymate.models.Product;
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


    //@Put

    @PostMapping("/addNew") //Working
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        Inventory newInventory = new Inventory(inventory.getProduct(), inventory.getFoodBank(), inventory.getQuantity());
        inventoryService.addInventory(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInventory);
    }



    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable("id") Long id) {
        inventoryService.deleteInventory(id);
        return "Inventory successfully deleted!";
    }



}
