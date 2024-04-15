package ss6_inheritance.exercise.Circle_and_Cylinder;

public class Main {
    public static void main(String[] args) {

        Circle c1 = new Circle();
        System.out.println(c1);

        Cylinder cy1 = new Cylinder();
        System.out.println(cy1);

        Cylinder cy2 = new Cylinder(12,"blue",99);
        System.out.println(cy2);

    }
}
