package ss19_Regex.practice.Validate_SDT;

public class Main {
    private static PhoneExample phoneExample;
    public static final String[] validClassName = new String[] { "(84)-(0978489648)" };
    public static final String[] invalidclassName = new String[] { "(a8)-(22222222)" };

    public static void main(String args[]) {
        phoneExample = new PhoneExample();
        for (String className : validClassName) {
            boolean isvalid = phoneExample.validate(className);
            System.out.println("Phone is " + className +" is valid: "+ isvalid);
        }
        for (String className : invalidclassName) {
            boolean isvalid = phoneExample.validate(className);
            System.out.println("Phone is " + className +" is valid: "+ isvalid);
        }
    }
}
