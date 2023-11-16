package com.example.cart.service;

import com.example.cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Optional<Product> find(long id);

}
