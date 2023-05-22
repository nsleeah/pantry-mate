package com.example.pantrymate.models;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "expires_on")
    private LocalDate expiresOn;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    //Constructor
    public Product() {
    }

    public Product(Long id, String name, String description, LocalDate expiresOn, CategoryEnum category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expiresOn = expiresOn;
        this.category = category;
    }

    public Product(String name, String description, LocalDate expiresOn, CategoryEnum category) {
        this.name = name;
        this.description = description;
        this.expiresOn = expiresOn;
        this.category = category;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(LocalDate expiresOn) {
        this.expiresOn = expiresOn;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }


    //To String

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expiresOn=" + expiresOn +
                ", category=" + category +
                '}';
    }
}
