package ss19_Regex.exercise.Validate_ClassName;

public class Main {
    private static ClassNameExample classNameExample;
    public static final String[] validClassName = new String[] { "C0318G" };
    public static final String[] invalidclassName = new String[] { "M0318G", "P0323A" };

    public static void main(String args[]) {
        classNameExample = new ClassNameExample();
        for (String className : validClassName) {
            boolean isvalid = classNameExample.validate(className);
            System.out.println("Class Name is " + className +" is valid: "+ isvalid);
        }
        for (String className : invalidclassName) {
            boolean isvalid = classNameExample.validate(className);
            System.out.println("Class Name is " + className +" is valid: "+ isvalid);
        }
    }
}
