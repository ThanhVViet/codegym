package FuramaManager_CS2.view;


import FuramaManager_CS2.controller.CustomerController;
import FuramaManager_CS2.model.Customer;
import FuramaManager_CS2.model.Person;
import FuramaManager_CS2.util.CommonUtil;
import FuramaManager_CS2.util.ConstantUtil.*;

public class CustomerView {
    private static CustomerController customerController = new CustomerController();

    public static void show(){
        System.out.println("----- Customer Management ------\n"+
                "1. Display list customer\n"+
                "2. Add new customer\n"+
                "3. Edit customer\n"+
                "4. Return main menu");

        int choice= CommonUtil.getChoice(1,5);
        switch (choice) {
            case 1:
                customerController.findAll().forEach(System.out::println);
                break;
            case 2:
                String code = CommonUtil.inputWithOutEmpty("Code");
                Customer newCustomer = input();
                newCustomer.setCode(code);
                customerController.create(newCustomer);
                System.out.println("Create successfully...!");
                break;
            case 3:
                System.out.print("Input code to edit: ");
                String editCode = CommonUtil.getScanner().nextLine();
                Customer editCustomer = input();
                editCustomer.setCode(editCode);
                customerController.update(editCustomer);
                System.out.println("Update successfully...!");
                break;
            case 4:
                HomeView.displayHomeMenu();
                break;
            case 5:
                String editCode1 = CommonUtil.getScanner().nextLine();
                customerController.get(editCode1);

        }
    }

    private static Customer input() {
        Person person = CommonUtil.inputPerson();
        TypeCustomer typeCustomer = CommonUtil.inputToEnum(TypeCustomer.class, "Type Customer");

        return new Customer(person.getFullName(), person.getBirthday(), person.getGender(), person.getPhone(), person.getEmail(), person.getAddress(), typeCustomer);
    }
}
