package com.example.pantrymate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inventory")
public class Inventory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        private Long id;

        @ManyToOne
        @JoinColumn(name = "product_id", nullable = false)
        private Product product;

        @ManyToOne
        @JoinColumn(name = "foodbank_id", nullable = false)
        private FoodBank foodBank;

        @Column(name = "quantity")
        private int quantity;

        //Constructor
        public Inventory() {
        }

        public Inventory(Long id, Product product, FoodBank foodBank, int quantity) {
            this.id = id;
            this.product = product;
            this.foodBank = foodBank;
            this.quantity = quantity;
        }

        public Inventory(Product product, FoodBank foodBank, int quantity) {
            this.product = product;
            this.foodBank = foodBank;
            this.quantity = quantity;
        }

        //Getters & Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public FoodBank getFoodBank() {
            return foodBank;
        }

        public void setFoodBank(FoodBank foodBank) {
            this.foodBank = foodBank;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        //To String
        @Override
        public String toString() {
            return "Inventory{" +
                    "id=" + id +
                    ", product=" + product +
                    ", foodBank=" + foodBank +
                    ", quantity=" + quantity +
                    '}';
        }
}
