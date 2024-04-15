package FuramaManager_CS2.controller;

import FuramaManager_CS2.model.Employee;
import FuramaManager_CS2.service.EmployeeService;
import FuramaManager_CS2.service.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    public void create(Employee e) {
        employeeService.create(e);
    }

    public void update(Employee e) {
        employeeService.update(e);
    }

    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}