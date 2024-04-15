package FuramaManager_CS2.service;

import FuramaManager_CS2.model.Customer;

import java.util.Optional;

public interface CustomerService extends BaseService<Customer> {
    Optional<Customer> get(String code);
}
