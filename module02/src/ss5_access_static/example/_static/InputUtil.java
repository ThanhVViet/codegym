package ss5_access_static.example._static;

import java.util.Scanner;

public class InputUtil {
    static Scanner scanner = new Scanner(System.in);
    public static int inputPositive(String target) {
        int number;
        do {
            System.out.printf("Mời bạn nhập vào %s: ", target);
            number = Integer.parseInt(scanner.nextLine());

            if (number < 0) {
                System.out.printf("Giá trị của bạn nhập vào không hợp lệ (%s >= 0), Xin nhập lại!!!\n", target);
            }
        } while (number < 0);
        return number;
    }
}
