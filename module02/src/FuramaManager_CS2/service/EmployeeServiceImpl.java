package FuramaManager_CS2.service;

import FuramaManager_CS2.Helper;
import FuramaManager_CS2.model.Employee;
import FuramaManager_CS2.util.ConstantUtil.FilePath;
import FuramaManager_CS2.util.ConstantUtil.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private static List<Employee> employees;
    private static Helper<Employee> fileHelper = new Helper();

    static {
        employees = toEmployees();
    }

    @Override
    public void create(Employee employee) {
        employees.add(employee);
        fileHelper.write(FilePath.EMPLOYEE, employees, false);
    }

    @Override
    public void update(Employee employee) {
        int index = employees.indexOf(employee);
        employees.set(index, employee);
        fileHelper.write(FilePath.EMPLOYEE, employees, false);
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    private static List<Employee> toEmployees(){
        List<Employee> result = new ArrayList<>();
        List<String> lines = fileHelper.read(FilePath.EMPLOYEE);

        for(String line : lines){
            String[] tmp = line.split(",");
            String code = tmp[0];
            String fullName = tmp[1];
            String birthday = tmp[2];
            Gender gender = Gender.valueOf(tmp[3]);
            String phone = tmp[4];
            String email = tmp[5];
            String address = tmp[6];
            Degree degree = Degree.valueOf(tmp[7]);
            Position position = Position.valueOf(tmp[8]);
            double salary = Double.parseDouble(tmp[9]);

            Employee employee = new Employee(code, fullName, birthday, gender, phone, email, address, degree, position, salary);
            result.add(employee);
        }

        return result;
    }
}
