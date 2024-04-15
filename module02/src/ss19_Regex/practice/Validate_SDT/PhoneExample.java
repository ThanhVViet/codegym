package ss19_Regex.practice.Validate_SDT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneExample {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_REGEX = "\\(\\d{2}\\)-\\(0\\d{9}\\)";

    public PhoneExample() {
        pattern = Pattern.compile(PHONE_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
