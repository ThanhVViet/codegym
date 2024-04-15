package ss19_Regex.exercise.Validate_ClassName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameExample {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String CLASSNAME_REGEX = "[CAP]\\d{4}\\w*[GHIKLM]";

    public ClassNameExample() {
        pattern = Pattern.compile(CLASSNAME_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
