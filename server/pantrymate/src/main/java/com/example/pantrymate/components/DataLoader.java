package com.example.pantrymate.components;

import com.example.pantrymate.models.CategoryEnum;
import com.example.pantrymate.models.FoodBank;
import com.example.pantrymate.models.Inventory;
import com.example.pantrymate.models.Product;
import com.example.pantrymate.repositories.FoodBankRepository;
import com.example.pantrymate.repositories.InventoryRepository;
import com.example.pantrymate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    FoodBankRepository foodBankRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {



        //Create Products
        Product product1 = new Product("Oranges", "Fruit", LocalDate.of(2023, 06, 12), CategoryEnum.FRESH_PRODUCE);
        Product product2 = new Product("Rice", "Basmati", LocalDate.of(2023, 06, 10), CategoryEnum.DRY_GOODS);
        Product product3 = new Product("Apples", "Granny Smith", LocalDate.of(2023, 5, 20), CategoryEnum.FRESH_PRODUCE);
        Product product4 = new Product("Bread", "Whole Wheat", LocalDate.of(2023, 5, 15), CategoryEnum.BAKERY);
        Product product5 = new Product("Milk", "Whole", LocalDate.of(2023, 5, 18), CategoryEnum.DAIRY_AND_EGGS);
        Product product6 = new Product("Beef", "Ground", LocalDate.of(2023, 5, 22), CategoryEnum.MEAT_FISH_POULTRY);
        Product product7 = new Product("Pasta", "Linguine", LocalDate.of(2023, 5, 25), CategoryEnum.DRY_GOODS);
        Product product8 = new Product("Lettuce", "Romaine", LocalDate.of(2023, 5, 19), CategoryEnum.FRESH_PRODUCE);
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8));

        //Create FoodBanks
        FoodBank foodBank1 = new FoodBank("Newham", "12 Newham Rd, London E6 1NW", "020 8690 3122");
        FoodBank foodBank2 = new FoodBank("Brixton", "123 Brixton Rd, London SW9 6DE", "020 1234 5678");
        FoodBank foodBank3 = new FoodBank("Hackney", "456 Hackney Rd, London E2 9ED", "020 9876 5432");
        FoodBank foodBank4 = new FoodBank("Wembley", "789 High Rd, Wembley HA0 4BN", "020 1111 2222");
        FoodBank foodBank5 = new FoodBank("Camden", "10 Chalk Farm Rd, London NW1 8AG", "020 3333 4444");
        FoodBank foodBank6 = new FoodBank("Islington", "25-27 Chapel Market, London N1 9EZ", "020 5555 6666");
        FoodBank foodBank7 = new FoodBank("Greenwich", "2-10 Creek Rd, London SE8 3BT", "020 7777 8888");
        FoodBank foodBank8 = new FoodBank("Tower Hamlets", "55 Old Montague St, London E1 5NL", "020 9999 0000");
        foodBankRepository.saveAll(Arrays.asList(foodBank1, foodBank2, foodBank3, foodBank4, foodBank5, foodBank6, foodBank7, foodBank8));

        //Create Inventories
        Inventory inventory1 = new Inventory(product2, foodBank1, 10);
        Inventory inventory2 = new Inventory(product3, foodBank2, 5);
        Inventory inventory3 = new Inventory(product4, foodBank3, 8);
        Inventory inventory4 = new Inventory(product5, foodBank4, 15);
        Inventory inventory5 = new Inventory(product6, foodBank5, 20);
        Inventory inventory6 = new Inventory(product7, foodBank6, 12);
        Inventory inventory7 = new Inventory(product8, foodBank7, 3);
        Inventory inventory8 = new Inventory(product2, foodBank3, 10);
        inventoryRepository.saveAll(Arrays.asList(inventory1, inventory2, inventory3, inventory4, inventory5, inventory6, inventory7, inventory8));



    }
}
