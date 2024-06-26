package FuramaManager_CS2.view;


import FuramaManager_CS2.controller.EmployeeController;
import FuramaManager_CS2.model.Employee;
import FuramaManager_CS2.model.Person;
import FuramaManager_CS2.util.CommonUtil;
import FuramaManager_CS2.util.ConstantUtil.*;
import FuramaManager_CS2.util.TableList;

import java.util.List;

public class EmployeeView {
    private static EmployeeController employeeController = new EmployeeController();

    public static void show(){
        System.out.println("----- Employee View: ------\n"+
                "1. Display list employees\n"+
                "2. Add new employee\n"+
                "3. Edit employee\n"+
                "4. Return main menu");

        int choice= CommonUtil.getChoice(1,4);

        switch (choice) {
            case 1 -> display1(employeeController.findAll());
            case 2 -> {
                String code = CommonUtil.inputWithOutEmpty("Code");
                Employee newEmployee = input();
                newEmployee.setCode(code);
                employeeController.create(newEmployee);
                System.out.println("Create successfully...!");
            }
            case 3 -> {
                System.out.print("Input code to edit: ");
                String editCode = CommonUtil.getScanner().nextLine();
                Employee editEmployee = input();
                editEmployee.setCode(editCode);
                employeeController.update(editEmployee);
                System.out.println("Update successfully...!");
            }
            case 4 -> HomeView.displayHomeMenu();
        }
    }

    private static  Employee input() {
        Person person = CommonUtil.inputPerson();
        Degree degree = CommonUtil.inputToEnum(Degree.class,"Degree");
        Position position = CommonUtil.inputToEnum(Position.class, "Position");
        double salary = CommonUtil.inputToDouble("Salary");

        return new Employee(person.getFullName(), person.getBirthday(), person.getGender(), person.getPhone()
                , person.getEmail(), person.getAddress(), degree, position, salary);
    }
    private static void display1(List<Employee> employees) {
        if (employees.size() > 0) {
            TableList tl = new TableList(10, "CODE", "FULL NAME", "BIRTHDAY", "GENDER", "PHONE",
                    "EMAIL", "ADDRESS", "DEGREE", "POSITION", "SALARY")
                    .sortBy(0)
                    .withUnicode(true);
            employees.forEach(element -> tl.addRow(element.getCode(),
                    element.getFullName(), element.getBirthday(),
                    element.getGender().toString(),element.getPhone(),element.getEmail(),element.getAddress(),
                    element.getDegree().toString(),element.getPosition().toString(),String.valueOf(element.getSalary())));
            tl.print();
        } else {
            System.out.println("emty");
        }
    }

    private static void display(List<Employee> employees){
        if(employees.size() > 0){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %20s %n", "CODE", "FULL NAME"
                    , "BIRTHDAY", "GENDER", "PHONE", "EMAIL", "ADDRESS", "DEGREE", "POSITION", "SALARY");
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------------------------------------------------------");

            for(Employee e: employees){
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %20s %n"
                        , e.getCode(), e.getFullName(), e.getBirthday(), e.getGender().name(), e.getPhone(), e.getEmail()
                        , e.getAddress(), e.getDegree().name(), e.getPosition().name(), e.getSalary());
            }
        }
        else {
            System.out.println("Empty list...");
        }
    }
}
