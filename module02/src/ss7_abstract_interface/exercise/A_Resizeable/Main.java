package ss7_abstract_interface.exercise.A_Resizeable;

public class Main {
    public static void main(String[] args) {
        Shape [] shapes = new Shape[2];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();

        System.out.println("Pre-sized:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("After-sized:");
        for (Shape shape : shapes) {
            if(shape instanceof Circle){
                Circle circle =(Circle) shape;
                circle.resize(10);
            }else {
                Rectangle rectangle = (Rectangle) shape;
                rectangle.resize(30);
            }
            System.out.println(shape);
        }
    }
}
