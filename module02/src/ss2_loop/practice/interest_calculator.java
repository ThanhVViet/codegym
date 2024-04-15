package ss2_loop.practice;

import java.util.Scanner;

public class interest_calculator {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter investment amount: "); // nhap so tien gui
        money = input.nextDouble();
        System.out.println("Enter number of months: "); // nhap so thang gui
        month = input.nextInt();
        System.out.println("Enter annual interest rate in percentage: "); // nhap lai suat
        interestRate = input.nextDouble();
        // tinh lai suat nhan duoc
        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
