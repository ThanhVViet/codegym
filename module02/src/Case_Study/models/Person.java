package Case_Study.models;


import Case_Study.utils.ConstantUtil.*;


public class Person {
    private String id;
    private String fullName;
    private String birthday;
    private Gender gender;
    private String phone;
    private String email;
    private String address;

    public Person() {
    }

    public Person(String id, String fullName, String birthday, Gender gender, String phone, String email, String address) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Person(String fullName, String birthday, Gender gender, String phone, String email, String address) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getCode() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setCode(String code) {
        this.id = code;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
