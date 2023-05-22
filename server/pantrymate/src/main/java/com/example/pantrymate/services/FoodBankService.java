package com.example.pantrymate.services;

import com.example.pantrymate.models.FoodBank;
import com.example.pantrymate.repositories.FoodBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodBankService {
    @Autowired
    FoodBankRepository foodBankRepository;

    //CRUD

    //CREATE
    public FoodBank addNewFoodBank(FoodBank foodBank) {
        return foodBankRepository.save(foodBank);
    }

    //READ
    public List<FoodBank> getAllFoodBanks() {
        return foodBankRepository.findAll();
    }

    public FoodBank getFoodBankById(Long id) {
        Optional<FoodBank> foodBank = foodBankRepository.findById(id);
        return foodBank.orElse(null);
    }

    //UPDATE
    public FoodBank updateFoodBank(FoodBank foodBank) {
        Optional<FoodBank> existingFoodBank = foodBankRepository.findById(foodBank.getId());
        if (existingFoodBank.isPresent()){
            return foodBankRepository.save(foodBank);
        } else {
            return null;
        }
    }

    //DELETE
    public void deleteFoodBank(Long id) {
        foodBankRepository.deleteById(id);
    }

}
