package com.codegym.spring_data_jpa.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class StudentDto implements Validator {
    private int id;
//    @NotEmpty(message = "Require input data")
//    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Not Match regex")
    private String name;
    private int gender;

    public StudentDto() {
    }

    public StudentDto(int id, String name, int gender) {
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
    // không dùng tới
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
          StudentDto studentDto = (StudentDto)target;
          if ("".equals(studentDto.getName())){
              errors.rejectValue("name",null,"Require input data");
          }else if (!studentDto.getName().matches("^[A-Z][a-z]*$")){
              errors.rejectValue("name",null,"Not Match Regex");
          }
    }
}
