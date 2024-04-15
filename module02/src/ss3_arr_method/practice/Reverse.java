package ss3_arr_method.practice;

import java.util.Scanner;

public class Reverse {
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
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        //%: chỉ ra đây là một đối số được định dạng
        //- : chuoi se duoc can le trai
        //20: hỉ ra rằng chuỗi sẽ có độ dài 20 ký tự (nếu không đạt đủ, sẽ được điền bằng khoảng trắng)
        // s: cho biết đối số sẽ la 1 chuỗi
        System.out.printf("%-20s%s", "Elements in array: ", ""); //sử dụng dể đn cấu trúc được in ra
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        //[1, 2, 3, 4, 5], sau khi vòng lặp trên thực hiện xong, mảng sẽ trở thành [5, 4, 3, 2, 1]
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
