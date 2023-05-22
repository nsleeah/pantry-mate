package com.example.pantrymate.services;

import com.example.pantrymate.models.Product;
import com.example.pantrymate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    //CRUD

    @Autowired
    private ProductRepository productRepository;

    //CREATE
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    //GET - READ
    public List<Product>getAllProducts(){
        return productRepository.findAll();
    }

    //GET ID - READ
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    //UPDATE
    public Product updateProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getId());
        if (existingProduct.isPresent()){
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    //DELETE
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    //SAVE
    public void save(Product product) {
        productRepository.save(product);
    }
    

}
