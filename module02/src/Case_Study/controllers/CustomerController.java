package Case_Study.controllers;

import Case_Study.models.Customer;
import Case_Study.models.Person;
import Case_Study.services.CustomerService;
import Case_Study.services.CustomerServiceImpl;
import Case_Study.utils.CommonUtil;
import Case_Study.utils.ConstantUtil.*;
import Case_Study.utils.TableList;

import java.util.List;

public class CustomerController {
    private static CustomerService customerService = new CustomerServiceImpl();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void show() {
        System.out.println(ANSI_YELLOW + "----- Customer Management ------\n" + ANSI_RESET +
                "1. Display list customer\n" +
                "2. Add new customer\n" +
                "3. Edit customer\n" +
                "4. Return main menu");

        int choose = CommonUtil.display(1, 4);

        switch (choose) {
            case 1:
                display(customerService.findAll());
                break;
            case 2:
                String code = CommonUtil.inputWithOutEmpty("Enter customer ID: ");
                Customer customer = cuCustomer();
                customer.setCode(code);
                customerService.create(customer);
                System.out.println("Add new customer successfull !!");
                break;
            case 3:
                String editID = CommonUtil.inputWithOutEmpty("Enter customer ID you want to update info: ");
                Customer editCustomer = cuCustomer();
                editCustomer.setCode(editID);
                customerService.edit(editCustomer);
                System.out.println("Edit info customer successfull !!");
                break;
            case 4:
                FuramaController.displayMainMenu();
        }
    }

    public static void display(List<Customer> customers) {
        if (customers.size() > 0) {
            TableList tl = new TableList(8, "CODE", "FULL NAME", "BIRTHDAY", "GENDER", "PHONE",
                    "EMAIL", "ADDRESS", "TYPE CUSTOMER")
                    .sortBy(0)
                    .withUnicode(true);

            customers.forEach(element -> tl.addRow(element.getCode(),
                    element.getFullName(), element.getBirthday(),
                    element.getGender().toString(), element.getPhone(), element.getEmail(), element.getAddress(),
                    element.getTypeCustomer().toString()));
            tl.print();
        } else {
            System.out.println("Please add some information !!!");
        }
    }

    private static Customer cuCustomer() {
        Person person = CommonUtil.createPerson();
        TypeCustomer typeCustomer = CommonUtil.inputToEnum(TypeCustomer.class, "Enter Type of Customer: ");

        return new Customer(person.getCode(), person.getFullName(), person.getBirthday(), person.getGender(), person.getPhone()
                , person.getEmail(), person.getAddress(), typeCustomer);
    }
}
