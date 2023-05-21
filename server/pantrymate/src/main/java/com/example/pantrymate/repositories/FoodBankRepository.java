package com.example.pantrymate.repositories;

import com.example.pantrymate.models.FoodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodBankRepository extends JpaRepository<FoodBank, Long> {
}
