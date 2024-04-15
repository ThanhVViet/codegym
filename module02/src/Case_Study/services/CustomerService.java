package Case_Study.services;

import Case_Study.models.Customer;

import java.util.Optional;

public interface CustomerService extends OriginalService<Customer>{
    Optional<Customer> get(String code);
}
