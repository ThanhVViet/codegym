package FuramaManager_CS2.controller;

import FuramaManager_CS2.model.Customer;
import FuramaManager_CS2.service.CustomerService;
import FuramaManager_CS2.service.CustomerServiceImpl;

import java.util.List;
import java.util.Optional;

public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    public void create(Customer e) {
        customerService.create(e);
    }

    public void update(Customer e) {
        customerService.update(e);
    }

    public List<Customer> findAll() {
        return customerService.findAll();
    }

    public Optional<Customer> get(String code){return  customerService.get(code);}
}
