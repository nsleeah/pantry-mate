package com.example.pantrymate.controllers;

import com.example.pantrymate.models.FoodBank;
import com.example.pantrymate.services.FoodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodBanks")
public class FoodBankController {
    @Autowired
    private FoodBankService foodBankService;

    @GetMapping()
    public List<FoodBank> getAllFoodBanks() {
        return foodBankService.getAllFoodBanks();
    }

    @GetMapping("/{id}")
    public FoodBank getFoodBankById(@PathVariable Long id) {
        return foodBankService.getFoodBankById(id);
    }

    @PostMapping()
    public String addNewFoodBank(@RequestBody FoodBank foodBank) {
        FoodBank newFoodBank = new FoodBank(foodBank.getName(), foodBank.getAddress(), foodBank.getContactNumber());
        foodBankService.addNewFoodBank(newFoodBank);
        return "New Food Bank successfully added!";
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFoodBank(@PathVariable("id") Long id, @RequestBody FoodBank foodBank) {
        foodBank.setId(id);
        FoodBank updatedFoodBank = foodBankService.updateFoodBank(foodBank);
        if (updatedFoodBank == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Foodbank updated!");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<FoodBank> deleteFoodBank(@PathVariable Long id){
        foodBankService.deleteFoodBank(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Routes Tested via Postman 26
    //@PostMapping - JSON
    //{
    //        "name": "Hackney New",
    //        "address": "456 Hackney Rd, London E2 9ED",
    //        "contactNumber": "020 9876 5432",
    //        "inventoryList": [
    //        ]
    //    }

}
