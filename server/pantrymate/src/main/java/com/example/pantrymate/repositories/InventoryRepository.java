package com.example.pantrymate.repositories;

import com.example.pantrymate.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository <Inventory, Long> {
}
