package com.codegym.webservice.dto;

import com.codegym.webservice.model.ClassRoom;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDto implements Validator {
    private int id;
    private String name;
    private int gender;

    private ClassRoom classRoom;

    public StudentDto() {
    }

    public StudentDto(int id, String name, int gender, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classRoom = classRoom;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
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

    @Override
    public boolean supports(Class<?> clazz) {
        // method này không cần dùng tới
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       // ép kiểu
//        StudentDto studentDto = (StudentDto) target;
//        if (studentDto.getName().equals("")){
//            errors.rejectValue("name",null,"Require not empty");
//        }else if (!studentDto.getName().matches("^[A-Z][a-z]*$")){
//            errors.rejectValue("name", null,"Not match regex");
//        }

    }
}
