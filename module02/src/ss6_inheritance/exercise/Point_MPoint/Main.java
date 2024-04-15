package ss6_inheritance.exercise.Point_MPoint;

public class Main {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint();
        System.out.println(mp);
        mp.setX(4);
        mp.setSpeed(5,9);
        System.out.println(mp.move());
    }

}
