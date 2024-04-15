package ss1_intro.exemple;
import java.util.Scanner;

public class Input_Output {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);// nhập dữ liệu từ bàn phím
            System.out.print("Nhập vào tuổi: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập vào tên của bạn : ");
            String name = scanner.nextLine();
            System.out.println(" tên của bạn là : " + name);
            System.out.println("tuổi :"+ age);
    }
}
