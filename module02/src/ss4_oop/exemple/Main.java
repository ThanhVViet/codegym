package ss4_oop.exemple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Nhập xuất với mảng student
        //Bước 1: Nhập n: số lượng pt của mảng
        //n phải là số nguyên dương
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Mời bạn nhập vào n: ");
            n = Integer.parseInt(scanner.nextLine());

            if (n < 0) {
                System.out.println("Giá trị của bạn nhập vào không hợp lệ (n >= 0), Xin nhập lại!!!");
            }
        } while (n < 0);

        // Bước 2: Khai báo mảng student
        Student[] studentList = new Student[n]; // null null

        //Bước 3: Nhập từng phần tử
        for(int i = 0; i < studentList.length; i++) {
            studentList[i] = new Student(); // cấp vùng nhớ trước khi chấm
            System.out.printf("Nhập vào sinh viên thứ %d: ", i + 1);

            System.out.print("Nhập vào tên: ");
            studentList[i].name = scanner.nextLine();

            System.out.print("Nhập vào điểm: ");
            studentList[i].score = Double.parseDouble(scanner.nextLine());
        }

        // Bước 4: Xuất mảng
        for(int i = 0; i < studentList.length; i++) {
            System.out.printf("Thông tin sinh viên thứ %d: ", i + 1);

            System.out.println("Tên: " + studentList[i].name);
            System.out.println("Điểm: " + studentList[i].score);
            studentList[i].run();
        }
    }
}
