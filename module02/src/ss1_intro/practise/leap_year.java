package ss1_intro.practise;

import java.util.Scanner;
//        Những năm chia hết cho 4 mà không chia hết cho 100 là năm nhuận
//
//        Những năm chia hết cho 100 mà không chia hết cho 400 thì KHÔNG PHẢI là năm nhuận
//
//        Những năm chia hết đồng thời cho 100 và 400 là năm nhuận
public class leap_year {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Enter a year: ");
        year = scanner.nextInt();

        boolean isLeapYear = false;

        boolean isDivisibleBy4 = year % 4 == 0;

        if(isDivisibleBy4){
            boolean isDivisibleBy100 = year % 100 == 0;
            if(isDivisibleBy100){
                boolean isDivisibleBy400 = year % 400 == 0;
                if(isDivisibleBy400){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is NOT a leap year", year);
        }
    }
}

