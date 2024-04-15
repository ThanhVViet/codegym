package ss5_access_static.exercise;

public class Access_Modifier {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println(c1.getArea());
        System.out.println(c1.getRadius());
        Circle c2 = new Circle(3);
        System.out.println(c2.getRadius());
        System.out.println(c2.getArea());
    }

    static class Circle {
        private double radius = 1;
        private String color = "red";

        public Circle() {

        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }
    }

}
