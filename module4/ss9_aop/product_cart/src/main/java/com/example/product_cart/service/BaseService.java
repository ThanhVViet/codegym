package com.example.product_cart.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    Optional<T> findById(int id);
    List<T> findAll();
}
