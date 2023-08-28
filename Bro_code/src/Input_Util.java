import java.util.Scanner;

public class Input_Util {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while(name.isEmpty()) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        }
        System.out.println("Welcome "+name);
    }
}
