package Exam1.model;

import Exam1.utils.ConstantUtil.*;

public class PhoneBook {
    private String name;
    private String birthday;
    private String contactGroup;
    private String phone;
    private String address;
    private String email;
    private Gender gender;

    public PhoneBook() {
    }

    public PhoneBook(String name, String birthday, String contactGroup, String phone, String address, String email, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.contactGroup = contactGroup;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.gender = gender;
    }

    public PhoneBook(String name, String birthday, String contactGroup, String address, String email, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.contactGroup = contactGroup;
        this.address = address;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getName(), getBirthday(), getContactGroup(), getPhone(), getAddress(), getEmail(), getGender().name());
    }
}
