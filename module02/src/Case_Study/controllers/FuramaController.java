package Case_Study.controllers;

import Case_Study.utils.CommonUtil;

import java.util.Scanner;

public class FuramaController {

    public static void displayMainMenu() {


        System.out.println("----- Welcome To Furama Resort Management System ------\n" +
                " 1. Employee Management\n" +
                " 2. Customer Management\n" +
                " 3. Facility Management\n" +
                " 4. Booking Management\n" +
                " 5. Promotion Management\n" +
                " 6. Exit "
        );

        int choice = CommonUtil.display(1, 6);

        switch (choice) {
            case 1 -> EmployeeController.show();

            case 2 -> CustomerController.show();

            case 3 -> FacilityController.show();

            case 4 -> BookingController.show();

            case 5 -> PromotionController.show();

            case 6 -> System.exit(0);
        }
        backToHomeMenu();

    }

    private static void backToHomeMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you back to main menu (Y/N): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("y")) {
            displayMainMenu();
        } else {
            System.exit(0);
        }
    }

}

