package ss4_oop.exercise;

import java.util.Scanner;

public class Class_QuadraticEquation {
    public static void main(String[] args) {
        QuadraticEquation ptb2 = new QuadraticEquation();
        ptb2.nhap();
        ptb2.getDiscriminant();
    }
    public static class QuadraticEquation {
        double a, b, c;
        public QuadraticEquation() {
        }

        public QuadraticEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public void nhap() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap he so bac 2: ");
            a = scanner.nextFloat();
            System.out.println("Nhap he so bac 1: ");
            b = scanner.nextFloat();
            System.out.println("Nhap he so bac 0: ");
            c = scanner.nextFloat();
        }

        public void getDiscriminant() {
            double delta = b * b - 4 * a * c;
            if (a == 0) {
                System.out.println("Day la phuong trinh bac 1!");
                if (b == 0 && c != 0) {
                    System.out.println("Phuong trinh vo nghiem!");
                } else if (b == 0 && c == 0) {
                    System.out.println("Phuong trinh vo so nghiem!");
                } else {
                    System.out.println("Phuong trinh co nghiem duy nhat: " + (-c / b));
                }
            } else {

                if (delta > 0) {
                    System.out.println("Phuong trinh co 2 nghiem phan biet!");
                    System.out.println("x1: " + (-b + Math.sqrt(delta)) / 2 * a);
                    System.out.println("x2: " + (-b - Math.sqrt(delta)) / 2 * a);
                } else if (delta == 0) {
                    System.out.println("Phuong trinh co nghiem kep!");
                    System.out.println("x1 = x2 : " + (-b / (2 * a)));
                } else {
                    System.out.println("Phuong trinh vo nghiem!");
                }
            }

        }


    }
}
