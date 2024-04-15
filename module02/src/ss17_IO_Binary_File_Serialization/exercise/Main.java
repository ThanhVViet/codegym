package ss17_IO_Binary_File_Serialization.exercise;


import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productService = new ProductServiceImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----- Menu Product -----");
            System.out.println("1. Create\n2. Display\n3. Search\n4. Sort\n5. Exit");
            int choice = Integer.parseInt(input("Enter your choice"));

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    display(productService.findAll().stream().collect(Collectors.toSet()));
                    // display(Set.of((Product) productService.findAll()));
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    //  sort();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static String input(String field) {
        System.out.print(field + ": ");
        return scanner.nextLine();
    }

    private static void create() {
        String Id = input("Enter ID");
        String name = input("Name");
        double price = Double.parseDouble(input("Price"));
        String manufacter = input("Manufacter ");
        String description = input("Description ");
        Product product = new Product(Id, name, manufacter, price, description);
        productService.create(product);
        System.out.println("Created successfully...");
    }

    private static void display(Set<Product> products) {
        if (products.size() > 0) {
            for (Product e : products) {
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %n"
                        , e.getId(), e.getName(), e.getPrice(), e.getManufacturer(), e.getDescription());
            }
        } else {
            System.out.println("Empty List !!!!");
        }

    }

    private static void search() {
        String Id = input("Enter ID of product you want to find ");
        Optional<Product> product = productService.get(Id);
        product.get();
        System.out.println(product);
    }
}
