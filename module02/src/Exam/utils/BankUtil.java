package Exam.utils;

import org.junit.platform.commons.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankUtil {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static int display(int from, int to) {
        Scanner scanner = new Scanner(System.in);

        int res = 0;
        while (res < from || res > to) {

            System.out.printf("Enter a number from %s to %s to choose function: ", from, to);

            while (!scanner.hasNextInt()) {
                System.out.printf("You must enter a number and its value must between %s and %s !!" +
                        "Please enter again: ", from, to);
                scanner.nextLine();
            }
            res = scanner.nextInt();
        }
        return res;
    }

    public static DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public static boolean isDate(String date) {
        try {
            LocalDate.parse(date, getDateFormat());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String inputWithOutEmpty(String prompt) {
        String res = null;

        do {
            System.out.printf(res != null ? "This %s cannot empty. Please input again:" : prompt, prompt);
            res = getScanner().nextLine();
        } while (StringUtils.isBlank(res));

        return res;
    }

    public static Integer typeInteger(String prompt) {
        String temp = inputWithOutEmpty(prompt);
        while (!isNumeric(temp)) {
            System.out.println("Invalid value !!! ");
            temp = inputWithOutEmpty("Enter again: ");
        }
        return Integer.parseInt(temp);
    }

    public static Double typeDouble(String prompt) {
        String temp = inputWithOutEmpty(prompt);
        while (!isNumeric(temp)) {
            System.out.println("Invalid value !!! ");
            temp = inputWithOutEmpty("Enter again: ");
        }
        return Double.parseDouble(temp);
    }

    public static boolean isNumeric(String string) {
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, string);
    }

}
