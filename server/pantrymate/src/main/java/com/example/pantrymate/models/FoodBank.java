package com.example.pantrymate.models;

import jakarta.persistence.*;

import java.util.List;

//Properties
@Entity
@Table(name = "foodbanks")
public class FoodBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @OneToMany(mappedBy = "foodBank", cascade = CascadeType.ALL)
    private List<Inventory> inventories;

    //Constructors
    public FoodBank() {
    }

    public FoodBank(Long id, String name, String address, String contactNumber, List<Inventory> inventories) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.inventories = inventories;
    }

    public FoodBank(String name, String address, String contactNumber, List<Inventory> inventories) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.inventories = inventories;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    //To String
    @Override
    public String toString() {
        return "FoodBank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", inventories=" + inventories +
                '}';
    }
}
