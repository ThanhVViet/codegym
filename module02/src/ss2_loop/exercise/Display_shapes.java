package ss2_loop.exercise;

import java.util.Scanner;

public class Display_shapes {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle ");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter the width of the rectangle: ");
                    int width = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the height of the rectangle: ");
                    int height = Integer.parseInt(scanner.nextLine());
                    System.out.println("Your rectangle: ");
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }

                    break;
                case 2:
                    int triangle = -1;
                    while (triangle != 0) {
                        System.out.println("Chọn tam giác vuông với vị trí góc vuông bạn muốn :");
                        System.out.println("1. Bottom-Left");
                        System.out.println("2. Bottom-Right");
                        System.out.println("3. Top-Left");
                        System.out.println("4. Top-Right");
                        System.out.println("Enter your choice: ");
                        triangle = Integer.parseInt(scanner.nextLine());
                        switch (triangle) {
                            case 1:
                                for (int i = 0; i <= 7; i++) { //quy dinh so hang
                                    for (int j = 0; j <= i; j++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 2:
                                int a = 0;
                                for (int i = 7; i >= 0; i--) {
                                    for (int j = 0; j <= i; j++) {
                                        System.out.print(" ");
                                    }
                                    for (int v = 0; v <= a; v++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                    a++;
                                }
                                break;
                            case 3:
                                for (int i = 7; i >= 0; i--) {
                                    for (int j = 0; j <= i; j++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 4:
                                int b = 0;
                                for (int i = 0; i <= 7; i++) {
                                    for (int j = 0; j <= i; j++) {
                                        System.out.print(" ");
                                    }
                                    for (int v = 7; v >= b; v--) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                    b++;
                                }
                                break;
                        }
                    }
                case 3:

                    System.out.println("Enter the height of the isosceles triangle: ");
                    int h = Integer.parseInt(scanner.nextLine());
                    System.out.println("Your isosceles triangle : ");
                    for (int i = 1; i <= h; i++) {
                        {
                            for (int j = 1; j <= h - i; j++) {
                                System.out.print(" ");
                            }
                            for (int j = 1; j <= 2 * i - 1; j++) {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Error !!!");
            }


        }
    }

}

