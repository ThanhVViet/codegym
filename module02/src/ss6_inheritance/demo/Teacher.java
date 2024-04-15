package ss6_inheritance.demo;

public class Teacher extends Person {
    private double slary;

    public Teacher(double slary) {
        this.slary = slary;
    }

    public Teacher(int id, String name, double slary) {
        super(id, name);
        this.slary = slary;
    }

    public double getSlary() {
        return slary;
    }

    public void setSlary(double slary) {
        this.slary = slary;
    }
}
