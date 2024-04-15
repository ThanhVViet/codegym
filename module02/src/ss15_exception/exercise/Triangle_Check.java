package ss15_exception.exercise;

public class Triangle_Check {
    private int a;
    private int b;
    private int c;

    public Triangle_Check(int a, int b, int c) throws IllegalTriangleException {
        this.a = a;
        this.b = b;
        this.c = c;

        if(a <= 0 || b <= 0 || c<=0){
            throw new IllegalTriangleException("sides of a triangle cannot be negative");
        }
        if(a + c <= 0 || a + b <= 0 || b + c <= 0){
            throw new IllegalTriangleException("sum of 2 sides of a triangle cannot be negative");
        }
    }


}
