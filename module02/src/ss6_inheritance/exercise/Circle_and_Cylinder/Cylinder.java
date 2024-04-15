package ss6_inheritance.exercise.Circle_and_Cylinder;

public class Cylinder extends Circle {
    private double height = 9;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double Volume(){
        return Math.PI * Math.pow(getRadius(),2) * height;
    }

    @Override
    public String toString() {
        return "Cylinder: " +
                "height=" + height + ", radius" + getRadius() +
                ", color = " + getColor() +
                ", volume is: " + Volume()
                ;
    }
}
