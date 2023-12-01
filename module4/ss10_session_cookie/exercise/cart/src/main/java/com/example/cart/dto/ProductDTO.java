package com.example.cart.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Long id;
    @NotNull(message = "Khong duoc de trong !!!")
    @Size(min=8, message = "độ dài tối thiểu là 8")
    private String name;
//    private byte[] image;
    private String imageName;
    @NotNull(message = "Khong duoc de trong !!!")
    private String description;
    @NotNull(message = "Khong duoc de trong !!!")
    private Long price;
    @NotNull(message = "Khong duoc de trong !!!")
    private Short discount;
    private Long categoryId;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String imageName, String description, Long price, Short discount, Long categoryId) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.categoryId = categoryId;
    }

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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Short getDiscount() {
        return discount;
    }

    public void setDiscount(Short discount) {
        this.discount = discount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
