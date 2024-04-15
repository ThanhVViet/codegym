package ss1_intro.practise;

import java.util.Scanner;

public class PTB1 {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver"); //"Giải phương trình tuyến tính"
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");//hãy nhập các hằng số
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
