package com.example.validate_register_form.web;

import jakarta.validation.constraints.*;

public class RegisterUser {
    @Min(value = 18, message = "Độ tuổi phải lớn hơn hoặc bằng 18")
    private int age;
    @NotNull(message = "thông tin bắt buộc")
    @Pattern(regexp = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$",
            message = "Sai định dạng email !! Vui lòng nhập lại")
    private String email;
    @NotNull(message = "thông tin bắt buộc")
    @Size(min = 5, max = 45, message = "độ dài tối thiểu là 5 và tối da là 45")
    private String firstName;
    @NotNull(message = "thông tin bắt buộc")
    @Size(min = 5, max = 45, message = "độ dài tối thiểu là 5 và tối da là 45")
    private String lastName;

//    @Email(message = "Email không hợp lệ")
//    private String email;

    @Size(min=10, max = 11)
    @Pattern(regexp = "^0\\d{9,10}$",
            message = "Sai định dạng só điện thoại !! Vui lòng nhập lại")
    private String phone;

    public RegisterUser() {
    }

    public RegisterUser(int age, String password, String firstName, String lastName, String email, String phone) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
