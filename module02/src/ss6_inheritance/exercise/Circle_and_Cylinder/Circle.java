package ss6_inheritance.exercise.Circle_and_Cylinder;

public class Circle {
    private double radius = 5;
    private String color = "purple";
    public Circle() {
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double Area(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle: " +
                "radius=" + radius +
                ", color='" + color + '\''+ ", Area is: " + Area()
                ;
    }
}
