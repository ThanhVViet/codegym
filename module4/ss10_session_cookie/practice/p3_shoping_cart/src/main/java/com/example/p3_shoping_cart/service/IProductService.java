package com.example.p3_shoping_cart.service;

import com.example.p3_shoping_cart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
