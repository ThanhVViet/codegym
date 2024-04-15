package ss3_arr_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ADD_elements {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size < 4 || size > 20)
                System.out.println("Size does not exceed 8");
        } while (size < 4 || size > 20);
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
        int index_add = -1;
        do {
            System.out.println();
            System.out.println("Enter index you want to add element: ");
            int x = scanner.nextInt();
            index_add = x;
            System.out.println("Enter a number you want to ADD:  ");
            int add_num = scanner.nextInt();
            if (x <= 1 || x >= array.length - 1) {
                System.out.println("Vị trí bạn chọn không thể chèn vào !! Vui lòng nhập lại: ");
            } else {
                for (int z = array.length - 1; z > x; z--) {
                    array[z] = array[z - 1];
                }
                array[x] = add_num;
            }
        } while (index_add <= 1 || index_add >= array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
