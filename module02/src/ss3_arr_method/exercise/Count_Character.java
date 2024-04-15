package ss3_arr_method.exercise;

import java.util.Scanner;

public class Count_Character {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter a string: ");
        String str = scanner.nextLine();
        System.out.println(" Enter a character you want to count: ");
        String c = scanner.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c.charAt(0)) {
                count++;
            }
        }
        System.out.println("Từ " + c.charAt(0) + " xuất hiện " + count + " lần");
    }
}
