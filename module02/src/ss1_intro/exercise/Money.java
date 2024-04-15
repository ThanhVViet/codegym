package ss1_intro.exercise;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an amount of money(USD) you want to exchange :");
        double usd = Double.parseDouble(scanner.nextLine());
        double rate = 23000 * usd;
        System.out.println("Số tiền VND là: " + rate);
    }
}
