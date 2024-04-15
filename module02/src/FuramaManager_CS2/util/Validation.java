package FuramaManager_CS2.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import FuramaManager_CS2.util.ConstantUtil.Regex;

public class Validation {
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

    public static boolean checkArea(double area) {
        return area > 30;
    }

    public static boolean checkPrice(double price) {
        return price > 0;
    }

    public static boolean checkMaxPeople(int maxPeople) {
        return maxPeople > 0 && maxPeople < 20;
    }

    public static boolean numberOfFloor(int numberOfFloor) {
        return numberOfFloor > 0;
    }

        public static boolean dayOfBirth(String dayOfBirth) {
        LocalDate now = LocalDate.now();

        if (!CommonUtil.isDate(dayOfBirth)) {
            return false;
        }

        LocalDate localDate = LocalDate.parse(dayOfBirth, CommonUtil.getDateFormat());
        return now.getYear() - localDate.getYear() < 100 && now.getYear() - localDate.getYear() > 18;
          //  Period p = Period.between(birthday, today);
    }
}
