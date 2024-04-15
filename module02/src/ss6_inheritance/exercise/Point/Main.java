package ss6_inheritance.exercise.Point;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D p2d = new Point2D();
        System.out.println(p2d);
        p2d.setXY(5,10);
        System.out.println(Arrays.toString(p2d.getXY()));

        Point3D p3d = new Point3D();
        p3d.setXYZ(8,9,10);
        System.out.println(Arrays.toString(p3d.getXYZ()));
        System.out.println(p3d);
    }
}
