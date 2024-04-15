package Exam.controllers;

import Exam.models.AccountBank;
import Exam.models.PaymentAccount;
import Exam.models.SavingAccount;
import Exam.services.AccountServiceImpl;
import Exam.services.IAccountService;
import Exam.utils.BankUtil;

import java.util.List;
import java.util.ListIterator;

import java.util.Scanner;

import static Case_Study.utils.CommonUtil.inputWithOutEmpty;
import static Exam.utils.BankUtil.*;

public class AccountController {

    private static IAccountService iAccountService = new AccountServiceImpl();

    public static void displayMainMenu() {

        System.out.println("----- Bank Account Management Program  ------\n" +
                " 1. Add New Account\n" +
                " 2. Delete Account\n" +
                " 3. Display List Bank Account\n" +
                " 4. Searching Account\n" +
                " 5. Exit "
        );

        int choice = BankUtil.display(1, 5);

        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                int id = typeInteger("Enter ID: ");
                iAccountService.delete(id);
                System.out.println("Successfull !!!!!");
                break;
            case 3:
                if(iAccountService.findAll() != null) {
                    iAccountService.findAll().forEach(System.out::println);
                }
                break;
            case 4:
                int id1 = typeInteger("Enter ID: ");
                iAccountService.search(id1);
                break;
            case 5:
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

    private static void create() {
        System.out.println("1. Add New Saving Account");
        System.out.println("2. Add New Payment Account");
        System.out.println("3. Back To Main Menu");


        int choice = BankUtil.display(1, 3);

        if (choice == 3) {
            displayMainMenu();
        } else {


//            int id = typeInteger("Enter ID: ");
//
//            while (!findDuplicate(id)) {
//                System.out.println("Duplicate ID !!!!!!");
//                id = CommonUtil.typeInteger("Enter ID: ");
//            }

            int idNewPaymentAccount = new AccountServiceImpl().findAll().stream().filter(acc -> acc instanceof PaymentAccount)
                    .map(AccountBank::getId)
                    .max(Integer::compareTo)
                    .orElse(0) +1;


            int idNewSavingAccount = new AccountServiceImpl().findAll().stream().filter(acc -> acc instanceof SavingAccount)
                    .map(AccountBank::getId)
                    .max(Integer::compareTo)
                    .orElse(0) + 1;

            String code = inputWithOutEmpty("Account Code: ");
            String name = inputWithOutEmpty("Account Owner Name: ");
            String dayCreate = inputWithOutEmpty("Date Create Account: ");
            while (!isDate(dayCreate)) {
                System.out.println("Invalid day !!! Example 'dd/MM/yyyy'");
                dayCreate = inputWithOutEmpty("Enter again: ");
            }

            AccountBank accountBank = null;

            switch (choice) {
                case 1:
                    double moneySaving = typeDouble("Saving Money: ");

                    String daySaving = inputWithOutEmpty("Date Create Account: ");
                    while (!isDate(daySaving)) {
                        System.out.println("Invalid day !!! Example 'dd/MM/yyyy'");
                        daySaving = inputWithOutEmpty("Enter again: ");
                    }

                    double interest = typeDouble("Enter Interest: ");
                    int month = typeInteger("Enter tenor: ");
                    accountBank = new SavingAccount(idNewSavingAccount,code, name, dayCreate, moneySaving, daySaving, interest, month);

                    break;
                case 2:
                    String numberOfCard = inputWithOutEmpty("Card Number: ");
                    double moneyInAccount = typeDouble("Enter Money In Account: ");

                    accountBank = new PaymentAccount(idNewPaymentAccount,code, name, dayCreate, numberOfCard, moneyInAccount);
                    break;

            }

            iAccountService.create(accountBank);
            System.out.println("Succesful !!!");

        }
    }

    public static boolean findDuplicate(int input) {
        AccountBank accountBank;
        List<AccountBank> employees = iAccountService.findAll();
        ListIterator<AccountBank> s1 = employees.listIterator();
        while (s1.hasNext()) {
            accountBank = s1.next();
            do {
                if (accountBank.getId() == input) {
                    return false;
                }
            } while (accountBank.getId() == input);
        }
        return true;
    }

    public static void search(int id) {
        boolean found = false;
        ListIterator li = null;
        while (li.hasNext()) {
            AccountBank e = (AccountBank) li.next();
            if (e.getId() == id) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found)
            System.out.println("Record Not Found...!");
        System.out.println("-------------------------------------");
    }

}


