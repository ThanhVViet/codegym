package ss9_mvc.View;


import ss9_mvc.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        int choose;

        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Tạo Học Sinh");
            System.out.println("2. Xem Danh Sách Học Sinh");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Nhấn số bất kỳ khác trên để thoát");

            System.out.println("Mời cưng chọn chức năng: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    System.out.println();
                    Student student = new Student();
             //       iStudentService.save(student);
                    break;
                case 2:
              //      iStudentService.display();
                    break;
                case 3:
                 //   iStudentService.save();
//                    System.out.println("Bạn đang chọn chức năng Sửa");
//                    iStudentService.edit();
                    break;
                case 4:
                    System.out.println("Bạn đang chọn chức năng Xóa");
//                    iStudentService.del();
//                    iStudentService.display();
                    break;
            }
        } while (choose >= 1 && choose <= 4);
    }
}
