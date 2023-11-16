package com.example.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ProductDTO, Integer> productMap = new HashMap<>();

    public CartDTO() {
    }

    public Map<ProductDTO, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDTO, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDTO ProductDTO) {
        if (productMap.containsKey(ProductDTO)) {
            //update value + 1
            Integer currentValue = productMap.get(ProductDTO);
//            productMap.put(ProductDTO, currentValue + 1);
            productMap.replace(ProductDTO, currentValue + 1);
        } else {
            productMap.put(ProductDTO, 1); //Lan dau dc them vao
        }
    }
}
