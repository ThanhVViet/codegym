package Exam.View;

import Exam.controllers.AccountController;

public class Main {
    public static void main(String[] args) {
        AccountController accountController = new AccountController();
        accountController.displayMainMenu();
    }
}
