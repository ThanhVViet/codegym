package ss3_arr_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Gop_Mang {
    public static void main(String[] args) {
        System.out.println("Nhap n: ");
        int n = nhap();
        System.out.println("Nhap m: ");
        int m = nhap();
        int i;
        int[] a = new int[n + m];
        int[] b = new int[m];
        //Nhap vao mang A va sap xep theo thu tu tang dan
        System.out.println("Nhap mang A: ");
        for (i = 0; i < n; i++) {
            System.out.print("\n Nhap phan tu thu " + i + " = ");
            a[i] = nhap();
        }
        Arrays.sort(a);
        //Nhap vao mang B va sap xep theo thu tu tang dan
        System.out.println("nhap mang B: ");
        for (i = 0; i < m; i++) {
            System.out.print("\n Nhap phan tu thu " + i + " = ");
            b[i] = nhap();
        }
        Arrays.sort(b);
        //Gop mang b vao mang a
        for (i = 0; i < m; i++) {
            themPhanTu(a, n + m + 1, b[i]);
        }
        inArray(a, 0, n + m);
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

    // in ra arr mới
    public static void inArray(int[] a, int begin, int end) {
        System.out.println();
        int i;
        for (i = begin; i < end; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
    }

    public static void themPhanTu(int[] a, int n, int pt) {
        a[0] = pt;
        Arrays.sort(a);
    }
}
