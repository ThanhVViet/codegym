package com.example.cart.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long price;
    private Short discount;
//    @Lob
//    @Column(name = "image", length = Integer.MAX_VALUE, nullable = true)
//    private byte[] image;

    @Column(name = "image_name")
    private String imageName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH
            })
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, String description, Long price, Short discount, String imageName, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.imageName = imageName;
        this.category = category;
    }

    public Product(Long id, String description, Long price, Short discount, String imageName, Date createDate) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.imageName = imageName;
        this.createDate = createDate;
    }

    public Product(Long id, String description, Long price, Short discount, String imageName, Date createDate, Category category) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.imageName = imageName;
        this.createDate = createDate;
        this.category = category;
    }

    public Product(Long id, String name, String description, Long price, Short discount, String imageName, Date createDate, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.imageName = imageName;
        this.createDate = createDate;
        this.category = category;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Transient
    public String getProductImagePath() {
        if (imageName == null || id == null) return null;
        return "/productImages/" + id + "/" + imageName;
    }
}
