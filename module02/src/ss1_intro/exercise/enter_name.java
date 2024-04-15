package ss1_intro.exercise;

import java.util.Scanner;

public class enter_name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name :");
        String name = scanner.nextLine();
        System.out.println("Display " + name);
    }
}
