package ss15_exception.exercise;

import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = Integer.parseInt(input("Side a: "));
        int b = Integer.parseInt(input("Side b: "));
        int c = Integer.parseInt(input("Side c: "));
        try{
            Triangle_Check tc = new Triangle_Check(a,b,c);
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
    }

//    public static boolean check(int a, int b, int c) throws IllegalTriangleException{
//        if(a <= 0 || b <= 0 || c<=0){
//            throw new IllegalTriangleException("sides of a triangle cannot be negative");
//        }
//        if(a + c <= 0 || a + b <= 0 || b + c <= 0){
//            throw new IllegalTriangleException("sum of 2 sides of a triangle cannot be negative");
//        }
//        return true;
//
//    }
private static String input(String field) {
    System.out.print(field + ": ");
    return scanner.nextLine();
}
}
