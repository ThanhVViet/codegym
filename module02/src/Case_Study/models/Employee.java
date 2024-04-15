package Case_Study.models;

import Case_Study.utils.ConstantUtil.*;


public class Employee extends Person {
    private Degree degree;
    private Position position;
    private double salary;

    public Employee() {
    }

    public Employee(String fullName, String birthday, Gender gender, String phone, String email, String address, Degree degree, Position position, double salary) {
        super(fullName, birthday, gender, phone, email, address);
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String code, String fullName, String birthday, Gender gender, String phone, String email, String address, Degree degree, Position position, double salary) {
        super(code, fullName, birthday, gender, phone, email, address);
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }


    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
                , getCode(), getFullName(), getBirthday(), getGender().name(), getPhone(), getEmail(), getAddress(), getDegree().name(), getPosition().name(), getSalary());
    }
}
