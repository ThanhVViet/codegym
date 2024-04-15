package ss3_arr_method.exercise;

import java.util.Scanner;

public class Find_Min_Arr {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);

        array = new int[size]; // khai báo dộ dài phần tử mảng

        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + i + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        // in ra danh sách đã nhập
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        int min = array[0];
        for (int v = 1; v < array.length; v++) {
            if (min > array[v]) {
                min = array[v];
            }
        }
        System.out.println();
        System.out.println("Giá trị nhỏ nhất là:");
        System.out.println(min);
    }
}
