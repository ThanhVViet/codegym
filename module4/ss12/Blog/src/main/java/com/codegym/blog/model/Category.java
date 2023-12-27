package com.codegym.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_category;
    private String name_category;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonBackReference
    Set<Blog> blogSet;

    public Category() {
    }

    public Category(Integer id_category, String name_category, Set<Blog> blogSet) {
        this.id_category = id_category;
        this.name_category = name_category;
        this.blogSet = blogSet;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
