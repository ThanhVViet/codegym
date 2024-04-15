package ss7_abstract_interface.exercise.A_Colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();

        for(Shape shape : shapes){
            if(shape instanceof Square) {
                Square square = (Square) shape;
                System.out.print(square);
                square.howtoColor();
            }
            else {
                System.out.println(shape);
            }
        }
    }
}
