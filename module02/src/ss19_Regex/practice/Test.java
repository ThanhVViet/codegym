package ss19_Regex.practice;

public class Test {
    public static void main(String[] args) {
        boolean a = "Java is fun".matches("Java.*");
        boolean b = "Java is cool".matches("Java.*");
        boolean c = "Java is powerful".matches("Java.*");

        System.out.println("a:" +  a);
        System.out.println("b:" +  b);
        System.out.println("c:" +  c);
    }
}
