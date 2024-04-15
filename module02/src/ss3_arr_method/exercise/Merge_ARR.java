package ss3_arr_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_ARR {
    public static void main(String[] args) {
        System.out.println("Nhap mảng 1: ");
        int n = nhap();
        System.out.println("Nhap mảng 2: ");
        int m = nhap();
        int i;

        int[] a = new int[n];
        System.out.println("Nhap mang A: ");
        for (i = 0; i < n; i++) {
            System.out.print("\n Nhap phan tu thu " + i + " = ");
            a[i] = nhap();
        }
        System.out.println("Mảng A gồm: ");
        System.out.println(Arrays.toString(a));
        int[] b = new int[m];
        System.out.println("nhap mang B: ");
        for (i = 0; i < m; i++) {
            System.out.print("\n Nhap phan tu thu " + i + " = ");
            b[i] = nhap();
        }
        System.out.println("Mảng B gồm: ");
        System.out.println(Arrays.toString(b));

        int[] c = new int[m + n];

        for (int v = 0; v < a.length; v++) {
            c[v] = a[v];
        }
        int index = a.length;
        for (int t = 0; t < b.length; t++) {
            c[index] = b[t];
            index++;
        }
        System.out.println("Mảng C sau khi gộp: ");
        System.out.println(Arrays.toString(c));
    }

    public static int nhap() {
        Scanner input = new Scanner(System.in);
        boolean check = false; // ktra giá trị nhập vào có hợp lệ hay không
        int n = 0;
        while (!check) {
            System.out.print(" ");
            try {
                n = input.nextInt();
                check = true; // số nguyên thoát khỏi vòng lặp
            } catch (Exception e) {
                System.out.println("Ban phai nhap so! hay nhap lai...");
                input.nextLine();
            }
        }
        return (n);
    }
}
