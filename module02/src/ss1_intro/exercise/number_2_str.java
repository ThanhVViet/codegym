package ss1_intro.exercise;

import java.util.Scanner;

public class number_2_str {
    public static void main(String[] args) {

        int num;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter a number :");
            num = Integer.parseInt(sc.nextLine());
            if (num > 999) {
                System.out.println("Please enter a number from 0 to 999 !!!");
            }
        } while (num > 999);

        if (num < 10) {

            switch (num) {

                case 1:
                    System.out.println("One");
                    break;

                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                case 10:
                    System.out.println("Ten");
                    break;
            }
        }
        int num1 = num % 10;
        int temp1 = num;
        if (num >= 10 && num < 20) {
            switch (num1) {
                case 0:
                    System.out.println("Ten");
                    break;
                case 1:
                    System.out.println("Eleven");
                    break;
                case 2:
                    System.out.println("Twelve");
                    break;
                case 3:
                    System.out.println("Thirteen");
                    break;
                case 4:
                    System.out.println("Fourteen");
                    break;
                case 5:
                    System.out.println("Fifteen");
                    break;
                case 6:
                    System.out.println("Sixteen");
                    break;
                case 7:
                    System.out.println("Seventeen");
                    break;
                case 8:
                    System.out.println("Eighteen");
                    break;
                case 9:
                    System.out.println("Nineteen");
                    break;
            }

        } else if (num >= 20) {
            int unit = temp1 % 10; // hàng đơn vị
            temp1 = temp1 / 10; // loại hàng dơn vị
            int dozen = temp1 % 10;
            temp1 = temp1 / 10;
            int hundred = temp1;
            String str1 = null, str2 = null, str3 = null;
            switch (hundred) {
                case 1:
                    str1 = "One hundred";
                    break;
                case 2:
                    str1 = "Two hundred";
                    break;
                case 3:
                    str1 = "Three hundred";
                    break;
                case 4:
                    str1 = "Four hundred";
                    break;
                case 5:
                    str1 = "Five hundred";
                    break;
                case 6:
                    str1 = "Six hundred";
                    break;
                case 7:
                    str1 = "Seven hundred";
                    break;
                case 8:
                    str1 = "Eight hundred";
                    break;
                case 9:
                    str1 = "Nine hundred";
                    break;
            }
            switch (dozen) {


                case 2:
                    str2 = "Twenty";
                    break;
                case 3:
                    str2 = "Thirty";
                    break;
                case 4:
                    str2 = "Forty";
                    break;
                case 5:
                    str2 = "Fifty";
                    break;
                case 6:
                    str2 = "Sixty";
                    break;
                case 7:
                    str2 = "Seventy";
                    break;
                case 8:
                    str2 = "Eighty";
                    break;
                case 9:
                    str2 = "Ninety";
                    break;
            }
            switch (unit) {
                case 1:
                    str3 = "One";
                    break;
                case 2:
                    str3 = "Two";
                    break;
                case 3:
                    str3 = "Three";
                    break;
                case 4:
                    str3 = "Four";
                    break;
                case 5:
                    str3 = "Five";
                    break;
                case 6:
                    str3 = "Six";
                    break;
                case 7:
                    str3 = "Seven";
                    break;
                case 8:
                    str3 = "Eight";
                    break;
                case 9:
                    str3 = "Nine";
                    break;
            }
            if (dozen == 1) {
                switch (unit) {
                    case 1:
                        str2 = " Eleven";
                        break;
                    case 2:
                        str2 = " Twelve";
                        break;
                    case 3:
                        str2 = " Thirteen";
                        break;
                    case 4:
                        str2 = " Fourteen";
                        break;
                    case 5:
                        str2 = " Fifteen";
                        break;
                    case 6:
                        str2 = " Sixteen";
                        break;
                    case 7:
                        str2 = " Seventeen";
                        break;
                    case 8:
                        str2 = " Eighteen";
                        break;
                    case 9:
                        str2 = " Nineteen";
                        break;
                }

            }
            String str = null;
            if (dozen == 1) {
                str = str1 + " and " + str2 + " ";
            } else if (str1 != null && str2 != null && str3 != null) {
                str = str1 + " and " + str2 + " " + str3;
            } else if (str2 == null && str3 == null) {
                str = str1;
            } else if (str1 != null && str2 != null) {
                str = str1 + " and " + str2;
            } else if (str1 != null && str3 != null) {
                str = str1 + " and " + str3;
            }
            System.out.println(str);
        }


    }
}
