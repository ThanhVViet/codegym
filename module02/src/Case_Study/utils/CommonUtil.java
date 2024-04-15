package Case_Study.utils;

import Case_Study.models.Person;
import Case_Study.models.Facility;
import Case_Study.utils.ConstantUtil.*;
import org.junit.platform.commons.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommonUtil {
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

    public static <T extends Enum<T>> T inputToEnum(Class<T> enumerator, String prompt) {
        String res = inputWithOutEmpty(prompt).toUpperCase();
        while (!enumValidator(enumerator.getSimpleName(), res)) {
            System.out.printf("Invalid value !!!! Please input again\n", prompt);
            res = inputWithOutEmpty(prompt).toUpperCase();
        }

        return Enum.valueOf(enumerator, res);
    }


    public static boolean isDate1(String date) {

        boolean valid;
        try {
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
            );
            valid = true;

        } catch (DateTimeParseException e) {
            e.printStackTrace();
            valid = false;
        }
        return valid;
    }

    public static String inputWithOutEmpty(String prompt) {
        String res = null;

        do {
            System.out.printf(res != null ? "This %s cannot empty. Please input again:" : prompt, prompt);
            res = getScanner().nextLine();
        } while (StringUtils.isBlank(res));

        return res;
    }

    public static Facility createFacility() {
        String name = inputWithOutEmpty("Enter name of facility: ");
        Double areaUsed = typeDouble("Enter useable area: ");
        while (!Validation.checkArea(areaUsed)) {
            areaUsed = typeDouble(" The area must be more than 30 square meters ");
        }
        Double cost = typeDouble("Enter amount of money have to pay: ");
        while (!Validation.checkCost(cost)) {
            cost = typeDouble(" The area must be more than 30 square meters ");
        }
        Integer max = typeInteger("Enter max people: ");
        while (!Validation.checkMaxPeople(max)) {
            System.out.println("Value must between 0 and 20 !!!");
            max = typeInteger("Enter again: ");
        }

        RentType rentType = inputToEnum(RentType.class, "Enter type of rent: ");

        return new Facility(name, areaUsed, cost, max, rentType);

    }


    public static Person createPerson() {

        String name = inputWithOutEmpty("Enter name: ");
        String birthday = inputWithOutEmpty("Enter day of birth: ");
        while (!Validation.dayOfBirth(birthday)) {
            System.out.println("Invalid day !!! Example 'dd/MM/yyyy': ");
            birthday = inputWithOutEmpty("Enter again: ");
        }

        Gender gender = inputToEnum(Gender.class, "Enter Gender(MALE/FEMALE): ");
//        while (!enumValidator(ConstantUtil.Gender.class.getSimpleName(), String.valueOf(gender))) {
//            System.out.println("Invalid !!! Please enter 'MALE' or 'FEMALE': ");
//            gender = Gender.valueOf(inputWithOutEmpty("Enter again: "));
//        }
        String phone;
        do {
            phone = inputWithOutEmpty("Enter phone number: ");
        } while (!Validation.isPhoneNumber(phone));

        String email = inputWithOutEmpty("Enter customer email: ");

        while (!Validation.isEmail(email)) {
            System.out.println("Invalid email !!");
            email = inputWithOutEmpty("Enter email: ");
        }


        String address = inputWithOutEmpty("Enter address: ");
        return new Person(name, birthday, gender, phone, email, address);

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

    /**
     * This method returns all names of an enum
     *
     * @param e
     * @return
     */
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


//    public static Person createPerson() {
//        Scanner scanner = new Scanner(System.in);
//
//        String name = getInput(scanner, "Enter name: ");
//        String birthday = getValidBirthday(scanner);
//        Gender gender = getValidGender(scanner);
//        String phone = getInput(scanner, "Enter phone: ");
//        String email = getInput(scanner, "Enter email: ");
//        String address = getInput(scanner, "Enter address: ");
//
//        scanner.close();
//
//        return new Person(name, birthday, gender, phone, email, address);
//    }
//
//    private static String getInput(Scanner scanner, String prompt) {
//        System.out.print(prompt);
//        return scanner.nextLine();
//    }
//
//    private static String getValidBirthday(Scanner scanner) {
//        String birthday;
//        do {
//            birthday = getInput(scanner, "Enter birthday: ");
//            if (!Validation.dayOfBirth(birthday)) {
//                System.out.println("Invalid day! Please enter a valid birthday.");
//            }
//        } while (!Validation.dayOfBirth(birthday));
//
//        return birthday;
//    }
//
//    private static Gender getValidGender(Scanner scanner) {
//        Gender gender = null;
//        do {
//            String genderInput = getInput(scanner, "Enter gender (MALE/FEMALE): ");
//            try {
//                gender = Gender.valueOf(genderInput.toUpperCase());
//            } catch (IllegalArgumentException e) {
//                System.out.println("Invalid input! Please enter 'MALE' or 'FEMALE'.");
//            }
//        } while (gender == null);
//
//        return gender;
//    }


}
