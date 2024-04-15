package Case_Study.services;

import Case_Study.models.Employee;
import Case_Study.utils.ConstantUtil.Degree;
import Case_Study.utils.ConstantUtil.Gender;
import Case_Study.utils.ConstantUtil.Position;
import Case_Study.utils.PATH.StringPath;
import Case_Study.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> employees;


    private static ReadAndWrite<Employee> file = new ReadAndWrite();

    static {
        employees = toEmployees();
    }


    @Override
    public void create(Employee employee) {
        employees.add(employee);
        file.write(StringPath.EMPLOYEE, employees, false);
    }

    @Override
    public void edit(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode().equals(employee.getCode())) {
                employees.set(i, employee);
                break;
            }
        }
        file.write(StringPath.EMPLOYEE, employees, false);
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }


    private static List<Employee> toEmployees() {
        List<Employee> result = new ArrayList<>();
        List<String> lines = file.readFile(StringPath.EMPLOYEE);

        for (String line : lines) {
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
