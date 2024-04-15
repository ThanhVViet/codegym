package ss12_Java_Collection_FrameWork.exercise;

import ss8_refactoring.CRUD.Student;

import java.util.ListIterator;
import java.util.Scanner;

public class Test1 {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager1 productManager = new ProductManager1();


    public static void main(String[] args) {
        while (true) {
            System.out.println("----- Menu Product -----");
            System.out.println("1. Create\n2. Update\n3. Delete\n4. Display\n5. Search by name\n6. Sort");
            int choice = Integer.parseInt(input("Enter your choice"));

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    //  productManager.display();
                    display();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    sort();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private static String input(String field) {
        System.out.print(field + ": ");
        return scanner.nextLine();
    }

    public static void create() {
        System.out.println("Nhập vào id sản phẩm: ");
        int id = productManager.nhap();
//        ListIterator<Product1> s1 = ProductManager1.products.listIterator();
//        while (s1.hasNext()) { // lap qua tat ca phan tu bang cach su hasNetx()
//            std = s1.next(); // lay phan tu tiep theo va gan vao bien std
//            do {
//                if (std.getId() == id) {
//                    System.out.println("ID trùng!! Vui lòng nhập lại !!");
//                    System.out.println("Nhập lại ID: ");
//                    id = inputId();
//                }
//            } while (std.getId() == id);
//        }
        System.out.println("Nhập vào tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá của sản phẩm: ");
        double score = Double.parseDouble(scanner.nextLine());
        Product1 p1 = new Product1(id, name, score);
        productManager.addProduct(p1);
    }

    public static void display() {
        productManager.findAll().forEach(System.out::println);
    }

    public static void update() {
        display();
        int id = Integer.parseInt(input("Please enter id to edit"));
        String name = input("Name");
        double price = Double.parseDouble(input("Price"));
        Product1 p1 = new Product1(id, name, price);
        productManager.update(p1);
        System.out.println("Update successfully ......");
    }

    public static void delete() {
        display();
        int id = Integer.parseInt(input("Please enter id to delete"));
        productManager.delete(id);
        System.out.println("Delete successfully ......");
    }

    public static void search() {
        String name = input("Enter a name you want to find: ");
        productManager.searchByName(name).forEach(System.out::println);
    }

    public static void sort() {
        System.out.print("Do you want sort price by?\n1. ASC\n2. DESC\n");
        int choice = Integer.parseInt(input("Enter your choice:"));
        productManager.sort(choice == 1);
    }


}
