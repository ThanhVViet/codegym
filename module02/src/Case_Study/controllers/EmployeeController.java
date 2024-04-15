package Case_Study.controllers;

import Case_Study.models.Employee;
import Case_Study.models.Person;
import Case_Study.services.EmployeeService;
import Case_Study.services.EmployeeServiceImpl;
import Case_Study.utils.CommonUtil;
import Case_Study.utils.ConstantUtil.*;
import Case_Study.utils.TableList;
import Case_Study.utils.ConstantUtil.Degree;
import Case_Study.utils.ConstantUtil.Position;
import Case_Study.utils.Validation;

import java.util.List;
import java.util.ListIterator;

import static Case_Study.utils.CommonUtil.*;


public class EmployeeController {
    private static EmployeeService employeeService = new EmployeeServiceImpl();

    public static void show() {
        System.out.println("----- Employee Management ------\n" +
                "1. Display list employees\n" +
                "2. Add new employee\n" +
                "3. Edit employee\n" +
                "4. Return main menu");

        int choose = CommonUtil.display(1, 4);
        switch (choose) {
            case 1:
                System.out.println("                                      -------EMPLOYEE LIST------");
                display(employeeService.findAll());
                break;
            case 2:
                System.out.println(Color.BLUE_BOLD + "-------ADD NEW EMPLOYEE------" + Color.RESET);

                String code = inputWithOutEmpty("Enter ID: ").toUpperCase();

                if (inputID(code).equalsIgnoreCase(code)) {
                    while (!Validation.isEmployee(code)) {
                        code = inputWithOutEmpty("Enter ID (Example: 'E1', 'E2',...): ");
                    }
                }
                while (!findDuplicate(code)) {
                    System.out.println("ID trùng!! Vui lòng nhập lại !!");
                    code = inputWithOutEmpty("Enter ID: ");
                }

                Employee newEmployee = addEmployee();
                newEmployee.setCode(code);
                employeeService.create(newEmployee);
                System.out.println("Create successfully...!");
                break;
            case 3:
                display(employeeService.findAll());
                System.out.println("-------EDIT INFO EMPLOYEE------");
                String update;
                do {
                    update = inputWithOutEmpty("Enter ID you want to edit information: ").toUpperCase();
                } while (findDuplicate(update));
                Employee editEmployee = addEmployee();
                editEmployee.setCode(update);
                employeeService.edit(editEmployee);
                System.out.println("Successfully !!!");
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
        }
    }

    private static void display(List<Employee> employees) {
        if (employees.size() > 0) {
            TableList tl = new TableList(10, "CODE", "FULL NAME", "BIRTHDAY", "GENDER", "PHONE",
                    "EMAIL", "ADDRESS", "DEGREE", "POSITION", "SALARY")
                    .sortBy(0)
                    .withUnicode(true);

            employees.forEach(element -> tl.addRow(element.getCode(),
                    element.getFullName(), element.getBirthday(),
                    element.getGender().toString(), element.getPhone(), element.getEmail(), element.getAddress(),
                    element.getDegree().toString(), element.getPosition().toString(), String.valueOf(element.getSalary())));
            tl.print();
        } else {
            System.out.println("Please add some information !!!");
        }
    }

    private static Employee addEmployee() {
        Person person = createPerson();
        Degree degree = inputToEnum(Degree.class, "Enter Degree: ");
        Position position = inputToEnum(Position.class, "Enter position: ");
//        Position.valueOf(inputWithOutEmpty("Enter Position: "))
        double salary = typeDouble("Enter Salary: ");

        return new Employee(person.getFullName(), person.getBirthday(), person.getGender(), person.getPhone()
                , person.getEmail(), person.getAddress(), degree, position, salary);

    }

    public static boolean findDuplicate(String input) {
        Employee employee;
        List<Employee> employees = employeeService.findAll();
        ListIterator<Employee> s1 = employees.listIterator();
        while (s1.hasNext()) {
            employee = s1.next();
            do {
                if (employee.getCode().equals(input)) {
                    return false;
                }
            } while (employee.getCode().equals(input));
        }
        return true;
    }

    //    public static String inputID(String code) {
//        String code2 = null;
//        if (!Validation.isEmployee(code)) {
//            while (!Validation.isEmployee(code)) {
//                code2 = inputWithOutEmpty("Enter ID (Example: 'E1', 'E2',...): ");
//                return code2;
//            }
//        } else {
//            return code;
//        }
//        return code2;
//    }
    public static String inputID(String code) {
        if (!Validation.isEmployee(code)) {
            System.out.println("Invalid ID !!!!!");
        } else {
            return code;
        }
        return code;
    }


}
