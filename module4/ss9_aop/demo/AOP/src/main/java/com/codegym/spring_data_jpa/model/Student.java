package com.codegym.spring_data_jpa.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int gender;

    @OneToOne
    @JoinColumn(name = "username",referencedColumnName = "username",unique = true)
    private Jame jame;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(int id, String name, int gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}
