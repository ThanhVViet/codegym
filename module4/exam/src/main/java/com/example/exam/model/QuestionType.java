package com.example.exam.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "question_type")

public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    Set<QuestionContent> contents;

    public QuestionType() {
    }
    public QuestionType(Integer id, String name, Set<QuestionContent> contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<QuestionContent> getContents() {
        return contents;
    }

    public void setContents(Set<QuestionContent> contents) {
        this.contents = contents;
    }
}
