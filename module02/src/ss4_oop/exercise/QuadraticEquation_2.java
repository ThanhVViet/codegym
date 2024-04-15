package ss4_oop.exercise;

import java.util.Scanner;

public class QuadraticEquation_2 {
    public static class Simple_Equation {
        public float hsBac1;
        public float hsBac0;

        public Simple_Equation() {
        }

        public Simple_Equation(float hsBac1, float hsBac0) {
            this.hsBac1 = hsBac1;
            this.hsBac0 = hsBac0;
        }

        public float getHsBac1() {
            return hsBac1;
        }

        public void setHsBac1(float hsBac1) {
            this.hsBac1 = hsBac1;
        }

        public float getHsBac0() {
            return hsBac0;
        }

        public void setHsBac0(float hsBac0) {
            this.hsBac0 = hsBac0;
        }

        public void nhap() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap he so bac 1: ");
            hsBac1 = scanner.nextFloat();
            System.out.println("Nhap he so bac 0: ");
            hsBac0 = scanner.nextFloat();
        }

        public void giaiPTBac1() {
            float ketQua = 0;
            if (hsBac1 == 0 && hsBac0 != 0) {
                System.out.println("Phuong trinh vo nghiem!");
            } else if (hsBac1 == 0 && hsBac0 == 0) {
                System.out.println("Phuong trinh vo so nghiem!");
            } else {
                ketQua = -hsBac0 / hsBac1;
                System.out.println("Phuong trinh co nghiem duy nhat: " + ketQua);
            }
        }
    }

    public static class PhuongTrinhBac2 extends Simple_Equation {
        public float hsBac2;

        public PhuongTrinhBac2() {
        }

        public PhuongTrinhBac2(float hsBac1, float hsBac0, float hsBac2) {
            super(hsBac1, hsBac0);
            this.hsBac2 = hsBac2;
        }

        @Override
        public void nhap() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap he so bac 2: ");
            hsBac2 = scanner.nextFloat();
            super.nhap();
        }

        public void giaiPTBac2() {
            if (hsBac2 == 0) {
                System.out.println("Day la phuong trinh bac 1!");
                giaiPTBac1();
            } else {
                float delta = hsBac1 * hsBac1 - 4 * (hsBac2 * hsBac0);
                if (delta > 0) {
                    System.out.println("Phuong trinh co 2 nghiem phan biet!");
                    System.out.println("x1: " + (-hsBac1 + Math.sqrt(delta)) / 2 * hsBac2);
                    System.out.println("x2: " + (-hsBac1 - Math.sqrt(delta)) / 2 * hsBac2);
                } else if (delta == 0) {
                    System.out.println("Phuong trinh co nghiem kep!");
                    System.out.println("x1 = x2 : " + (-hsBac1 / (2 * hsBac2)));
                } else {
                    System.out.println("Phuong trinh vo nghiem!");
                }
            }
        }
    }

    public static void main(String[] args) {
        PhuongTrinhBac2 e = new PhuongTrinhBac2();
        e.nhap();
        e.giaiPTBac2();
    }
}
