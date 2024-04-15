package Case_Study.utils;


import Case_Study.utils.PATH.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import static Case_Study.utils.CommonUtil.getDateFormat;
import static Case_Study.utils.CommonUtil.isDate;

public class Validation {
    public static boolean dayOfBirth(String dayOfBirth) {
        LocalDate now = LocalDate.now();

        if (!isDate(dayOfBirth)) {
            return false;
        }

        LocalDate localDate = LocalDate.parse(dayOfBirth, getDateFormat());
        return now.getYear() - localDate.getYear() < 100 && now.getYear() - localDate.getYear() > 18;
    }

//    static public boolean isMember(String aName) {
//        Gender[] aFruits = Gender.values();
//        for (Gender gender : aFruits)
//            if (gender.getGender().equals(aName))
//                return true;
//        return false;
//    }

    public static boolean ageCalculator(final String date) {

        LocalDate now = LocalDate.now();

        boolean valid;

        try {

            LocalDate localDate = LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
                            .withResolverStyle(ResolverStyle.STRICT)
            );
            return now.getYear() - localDate.getYear() < 100 && now.getYear() - localDate.getYear() > 18;

        } catch (DateTimeParseException e) {
            e.printStackTrace();
            valid = false;
        }
        return valid;
    }

    public static boolean isEmployee(String employee) {
        return employee.matches(PATH.Regex.EMPLOYEE);
    }

    public static boolean isPhoneNumber(String phonenumber) {
        return phonenumber.matches(PATH.Regex.PHONE);
    }

    public static boolean isEmail(String email) {
        String ePattern = PATH.Regex.EMAIL;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isFloor(int number) {

        return number > 0;
    }

    public static boolean checkCost(double cost) {
        return cost > 0;
    }

    public static boolean checkMaxPeople(int max) {
        return max > 0 && max < 20;
    }

    public static boolean checkArea(double area) {
        return area > 30;
    }

    public static boolean isPool(double areaOfPool) {
        return areaOfPool > 0;
    }

    public static boolean isVilla(String val) {
        return val.matches(Regex.VILLA);
    }

    public static boolean isHouse(String val) {

        return val.matches(Regex.HOUSE);
    }

    public static boolean isRoom(String val) {
        return val.matches(Regex.ROOM);
    }

    public static boolean isServiceName(String val) {
        return val.matches(Regex.SERVICE_NAME);
    }


}
