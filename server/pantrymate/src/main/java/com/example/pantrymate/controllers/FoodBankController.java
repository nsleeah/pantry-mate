package com.example.pantrymate.controllers;

import com.example.pantrymate.models.FoodBank;
import com.example.pantrymate.services.FoodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodBanks")
public class FoodBankController {
    @Autowired
    private FoodBankService foodBankService;

    @GetMapping()
    public Iterable<FoodBank> getFoodBanks() {
        Iterable<FoodBank> foodBanks = foodBankService.getAllFoodBanks();
        return foodBanks;
    }

    @GetMapping("/{id}")
    public FoodBank getFoodBankById(@PathVariable Long id) {
        return foodBankService.getFoodBankById(id);
    }

    @PostMapping("/addNew")
    public String addNewFoodBank(@RequestBody FoodBank foodBank) {
        FoodBank newFoodBank = new FoodBank(foodBank.getName(), foodBank.getAddress(), foodBank.getContactNumber(), foodBank.getInventories());
        foodBankService.addNewFoodBank(newFoodBank);
        return "New Food Bank successfully added!";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFoodBank(@PathVariable("id") Long id, @RequestBody FoodBank foodBank) {
        foodBank.setId(id);
        FoodBank updatedFoodBank = foodBankService.updateFoodBank(foodBank);
        if (updatedFoodBank == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Foodbank updated!");
    }

    @DeleteMapping("/{id}")
    public String deleteFoodBank(@PathVariable("id") Long id) {
        foodBankService.deleteFoodBank(id);
        return "Food Bank successfully deleted!";
    }

    //Routes Tested via Postman.

}
