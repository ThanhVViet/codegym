package ss8_refactoring.CRUD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<Student>(100);

    static {
        students.add(new Student(1, "Meo", 9));
    }

    static Student std;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
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
                    System.out.println("Nhập vào id: ");
                    int id = inputId();
                    ListIterator<Student> s1 = students.listIterator();
                    while (s1.hasNext()) { // lap qua tat ca phan tu bang cach su hasNetx()
                        std = s1.next(); // lay phan tu tiep theo va gan vao bien std
                        do {
                            if (std.getId() == id) {
                                System.out.println("ID trùng!! Vui lòng nhập lại !!");
                                System.out.println("Nhập lại ID: ");
                                id = inputId();
                            }
                        } while (std.getId() == id);
                    }
                    System.out.println("Nhập vào tên học sinh: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhập điểm số: ");
                    double score = Double.parseDouble(scanner.nextLine());
                    students.add(new Student(id, name, score));
                    break;
                case 2:

                    if (students.isEmpty()) {
                        System.out.println("Hãy tạo học sinh");
                    } else {
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Bạn đang chọn chức năng Sửa");
                    System.out.println("Nhập vào id bạn muốn sửa thông tin: ");
                    int id1 = Integer.parseInt(scanner.nextLine());
                    ListIterator<Student> s = students.listIterator(); // duyệt qua các phân tu cua 1 list
                    while (s.hasNext()) { // lap qua tat ca phan tu bang cach su hasNetx()
                        std = s.next(); // lay phan tu tuep theo va gan vao bien std
                        if (std.getId() == id1) {
                            System.out.println("Tên cũ:" + std.getName());
                            System.out.println("Nhập vào tên mới học sinh: ");
                            String name1 = scanner1.nextLine();
                            System.out.println("Nhập điểm mới: ");
                            double score1 = Double.parseDouble(scanner.nextLine());
                            s.set(new Student(id1, name1, score1));
                        }
                    }
                    break;
                case 4:
                    boolean check = false;
                    System.out.println("Bạn đang chọn chức năng Xóa");
                    System.out.println("Nhập vào id bạn muốn xoá thông tin: ");
                    int delid = Integer.parseInt(scanner.nextLine());
                    Iterator i = students.iterator(); // lap qua tat ca
                    while (i.hasNext()) {
                        std = (Student) i.next();
                        if (std.getId() == delid) {
                            i.remove();
                            check = true;
                        }

                    }
                    if (check) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("Khong the tim thay");
                    }
                    System.out.println("----------------------------------");
            }

        } while (choose >= 1 && choose <= 4);
    }

    private static int inputId() {
        int id;
        id = Student.nhap();
        return id;
    }
}


