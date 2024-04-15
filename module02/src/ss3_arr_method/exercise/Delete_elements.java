package ss3_arr_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Delete_elements {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 8)
                System.out.println("Size does not exceed 8");
        } while (size > 8);
        array = new int[size]; // khai báo dộ dài phần tử mảng
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
// in ra danh sách đã nhập
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        int index_del = -1;

        do {
            System.out.println("Enter a number you want to delete:  ");
            int delnum = scanner.nextInt();
            for (int z = 0; z < array.length; z++) {
                if (delnum == array[z]) {
                    index_del = z;
                    break;
                }
            }
            for (int v = index_del; v < array.length - 1; v++) {
                array[v] = array[v + 1];
            }
            array[array.length - 1] = 0;


            if (index_del == -1) {
                System.out.println("Hãy nhập lại số cần xoá !!!");
            }
        } while (index_del == -1);
        System.out.println(Arrays.toString(array));

    }
}
