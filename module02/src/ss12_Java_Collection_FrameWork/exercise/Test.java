package ss12_Java_Collection_FrameWork.exercise;

import java.util.Scanner;

    public class Test {
        private static Scanner scanner = new Scanner(System.in);
        private static ProductManager productManager = new ProductManager();

        public static void main(String[] args) {
            while(true){
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
                        detele();
                        break;
                    case 4:
                        display();
                        break;
                    case 5:
                        searchByName();
                        break;
                    case 6:
                        sort();
                        break;
                    case 7:
                        System.exit(0);
                }
            }
        }

        private static void sort() {
            System.out.print("Do you want sort price by?\n1. ASC\n2. DESC\n");
            int choice = Integer.parseInt(input("Enter your choice:"));
            productManager.sort(choice == 1);
        }

        private static void searchByName() {
            String name = input("Please enter name to search");
//        List<Product> products = productManager.search(name);
//        for (Product product : products) {
//            System.out.println(product);
//        }

            productManager.search(name).forEach(System.out::println);
        }

        private static void display() {
//        List<Product> products = productManager.findAll();
//        for (Product product : products) {
//            System.out.println(product);
//        }

            productManager.findAll().forEach(System.out::println);
        }

        private static void detele() {
            display();
            int id = Integer.parseInt(input("Please enter id to delete"));
            productManager.delete(id);
            System.out.println("Delete successfully...");
        }

        private static void update() {
            display();
            int id = Integer.parseInt(input("Please enter id to edit"));
            String name = input("Name");
            double price = Double.parseDouble(input("Price"));
            Product product = new Product(id, name, price);
            productManager.update(product);
            System.out.println("Updated successfully...");
        }

        private static void create() {
            int id = Integer.parseInt(input("Id"));
            String name = input("Name");
            double price = Double.parseDouble(input("Price"));
            Product product = new Product(id, name, price);
            productManager.create(product);
            System.out.println("Created successfully...");
        }

        private static String input(String field) {
            System.out.print(field + ": ");
            return scanner.nextLine();
        }
    }


