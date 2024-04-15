package Exam1.controller;

import Exam1.model.PhoneBook;
import Exam1.service.IPhoneBook;
import Exam1.service.PhoneBookImpl;
import Exam1.utils.ConstantUtil;
import Exam1.utils.PhoneBookUtil;
import Exam1.utils.TableList;
import Exam1.utils.Validation;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import static Exam1.utils.PhoneBookUtil.inputWithOutEmpty;
import static Exam1.utils.PhoneBookUtil.typeEnum;


public class PhoneBookController {

    private static IPhoneBook iPhoneBook = new PhoneBookImpl();

    public static void displayMainMenu() {

        System.out.println("----- Phone Book Management Program  ------\n" +
                " 1. Display Phone Book List\n" +
                " 2. Add New Phone Book\n" +
                " 3. Edit Phone Book\n" +
                " 4. Delete\n" +
                " 5. Searching Phone Book\n" +
                " 6. Read From File\n" +
                " 7. Write To File\n" +
                " 8. Exit "
        );

        int choice = PhoneBookUtil.display(1, 8);

        switch (choice) {
            case 1:
                System.out.println(ConstantUtil.Color.MAGENTA + "-------LIST PHONE BOOK------" + ConstantUtil.Color.RESET);
                display(iPhoneBook.findAll());
                break;
            case 2:
                System.out.println(ConstantUtil.Color.BLUE_BOLD + "-------ADD NEW PHONE BOOK------" + ConstantUtil.Color.RESET);
                PhoneBook phoneBook = add();
                iPhoneBook.create(phoneBook);
                System.out.println(ConstantUtil.Color.YELLOW_BOLD + "SUCCESSFULL !!!!!" + ConstantUtil.Color.RESET);
                break;
            case 3:
                System.out.println(ConstantUtil.Color.GREEN_BOLD + "-------EDIT INFO PHONE BOOK------" + ConstantUtil.Color.RESET);
                String phoneToEdit;
                do {
                    phoneToEdit = inputWithOutEmpty("Phone number to edit info: ");
                } while (!Validation.isPhoneNumber(phoneToEdit));

                while (findDuplicate(phoneToEdit)) {
                    System.out.println("No Record Found !!!");
                    phoneToEdit = inputWithOutEmpty("Enter again: ");
                }

                PhoneBook editPB = add();
                iPhoneBook.edit(editPB);
                System.out.println(ConstantUtil.Color.RED_UNDERLINED + "SUCCESSFULL !!!!!" + ConstantUtil.Color.RESET);
                break;
            case 4:
                String phoneToDelete;
                do {
                    phoneToDelete = inputWithOutEmpty("Enter phone number to edit info: ");
                } while (!Validation.isPhoneNumber(phoneToDelete));

                while (findDuplicate(phoneToDelete)) {
                    System.out.println("No Record Found !!!");
                    phoneToDelete = inputWithOutEmpty("Enter again: ");
                }

                iPhoneBook.delete(phoneToDelete);
                System.out.println(ConstantUtil.Color.YELLOW_UNDERLINED + "SUCCESSFULL !!!!!" + ConstantUtil.Color.RESET);
                break;
            case 5:
                String phoneToFind;
                do {
                    phoneToFind = inputWithOutEmpty("Enter phone number to edit info: ");
                } while (!Validation.isPhoneNumber(phoneToFind));

                while (findDuplicate(phoneToFind)) {
                    System.out.println("No Record Found !!!");
                    phoneToFind = inputWithOutEmpty("Enter again: ");
                }
                System.out.println(ConstantUtil.Color.GREEN_BRIGHT + "RECORD FOUND !!!!!" + ConstantUtil.Color.RESET);
                iPhoneBook.find(phoneToFind);
                break;

            case 6:
                System.out.println("I Dont't Understand !!!");
                break;
            case 7:
                System.out.println("I Dont't Understand !!!");
                break;
            case 8:
                System.exit(0);
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

    private static PhoneBook add() {
        String name = inputWithOutEmpty("Name: ");
        String contactGroup = inputWithOutEmpty("Contact Group: ");
        String birthday = inputWithOutEmpty("Day of birth: ");
        while (!Validation.dayOfBirth(birthday)) {
            System.out.println("Invalid day !!! Example 'dd/MM/yyyy': ");
            birthday = inputWithOutEmpty("Enter again: ");
        }

        ConstantUtil.Gender gender = typeEnum(ConstantUtil.Gender.class, "Gender(MALE/FEMALE): ");

        String phone;
        do {
            phone = inputWithOutEmpty("Phone number: ");
        } while (!Validation.isPhoneNumber(phone));

        String email = inputWithOutEmpty("Email: ");

        while (!Validation.isEmail(email)) {
            System.out.println("Invalid email !!");
            email = inputWithOutEmpty("Email: ");
        }


        String address = inputWithOutEmpty("Address: ");

        return new PhoneBook(name, birthday, contactGroup, phone, address, email, gender);
    }


    private static void display(List<PhoneBook> phoneBooks) {
        if (phoneBooks.size() > 0) {
            TableList tl = new TableList(7, "FULL NAME", "BIRTHDAY", "CONTACT GROUP", "PHONE"
                    , "ADDRESS", "EMAIL", "GENDER")
                    .sortBy(0)
                    .withUnicode(true);

            phoneBooks.forEach(element -> tl.addRow(element.getName(),
                    element.getBirthday(), element.getContactGroup(), element.getPhone(), element.getAddress(), element.getEmail(),
                    element.getGender().toString()
            ));
            tl.print();
        } else {
            System.out.println("Please add some information !!!");
        }
    }

    public static boolean findDuplicate(String input) {
        PhoneBook employee;
        List<PhoneBook> employees = iPhoneBook.findAll();
        ListIterator<PhoneBook> s1 = employees.listIterator();
        while (s1.hasNext()) {
            employee = s1.next();
            do {
                if (employee.getPhone().equals(input)) {
                    return false;
                }
            } while (employee.getPhone().equals(input));
        }
        return true;
    }

}
