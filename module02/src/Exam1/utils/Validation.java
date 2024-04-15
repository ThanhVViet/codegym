package Exam1.utils;

import java.time.LocalDate;

import static Exam1.utils.PhoneBookUtil.getDateFormat;
import static Exam1.utils.PhoneBookUtil.isDate;


public class Validation {
    public static boolean isPhoneNumber(String phonenumber) {
        return phonenumber.matches(ConstantUtil.PHONE);
    }

    public static boolean isEmail(String email) {
        String ePattern = ConstantUtil.EMAIL;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean dayOfBirth(String dayOfBirth) {
        LocalDate now = LocalDate.now();

        if (!isDate(dayOfBirth)) {
            return false;
        }

        LocalDate localDate = LocalDate.parse(dayOfBirth, getDateFormat());
        return now.getYear() - localDate.getYear() < 100 && now.getYear() - localDate.getYear() > 0;
    }
}
