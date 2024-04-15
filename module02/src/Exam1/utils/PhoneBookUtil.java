package Exam1.utils;

import org.junit.platform.commons.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneBookUtil {

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

    public static String[] getEnumNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    /**
     * This method returns all the enum classes from a class
     *
     * @return
     */
    public static Class<?>[] getENumClasses() {
        Class<?>[] x = ConstantUtil.class.getClasses();
        return x;
    }

    /**
     * This utility performs following:
     * - will get all enum classes from EnumProto
     * - will get all names against all classes
     * - checks against all names of enum class and returns true if name matches else returns false
     *
     * @param enumClass
     * @param value
     * @return
     */
    public static Boolean enumValidator(String enumClass, String value) {
        Boolean bool = false;
        ConstantUtil.l = getENumClasses();
        for (Class x : ConstantUtil.l) {
            if (x.getSimpleName().equals(enumClass)) {
                try {
                    String enumNames[] = getEnumNames(x);
                    if (Arrays.asList(enumNames).contains(value)) {
                        bool = true;
                        return bool;
                    }
                } catch (ClassCastException e) {
                }
            }
        }
        return bool;
    }

    public static <T extends Enum<T>> T typeEnum(Class<T> enumerator, String prompt) {
        String res = inputWithOutEmpty(prompt).toUpperCase();
        while (!enumValidator(enumerator.getSimpleName(), res)) {
            System.out.printf("Invalid value !!!! Please input again\n", prompt);
            res = inputWithOutEmpty(prompt).toUpperCase();
        }

        return Enum.valueOf(enumerator, res);
    }

}
