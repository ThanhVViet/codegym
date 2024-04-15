package Case_Study.services;

import Case_Study.models.Customer;
import Case_Study.utils.PATH;
import Case_Study.utils.ReadAndWrite;
import Case_Study.utils.ConstantUtil.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private static List<Customer> customers = new LinkedList<>();
    private static ReadAndWrite<Customer> file = new ReadAndWrite();

    static {
        customers = showCustomer();
    }

    @Override
    public void create(Customer customer) {
        customers.add(customer);
        file.write(PATH.StringPath.CUSTOMER, customers, false);
    }

    @Override
    public void edit(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCode().equals(customer.getCode())) {
                customers.set(i, customer);
                break;
            }
        }
        file.write(PATH.StringPath.CUSTOMER, customers, false);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    private static List<Customer> showCustomer() {
        List<Customer> result = new LinkedList<>();
        List<String> lines = file.readFile(PATH.StringPath.CUSTOMER);

        for (String line : lines) {
            String[] tmp = line.split(",");
            String code = tmp[0];
            String fullName = tmp[1];
            String birthday = tmp[2];
            Gender gender = Gender.valueOf(tmp[3]);
            String phone = tmp[4];
            String email = tmp[5];
            String address = tmp[6];
            TypeCustomer typeCustomer = TypeCustomer.valueOf(tmp[7]);

            Customer employee = new Customer(code, fullName, birthday, gender, phone, email, address, typeCustomer);
            result.add(employee);
        }

        return result;
    }

    @Override
    public Optional<Customer> get(String code) {
        return customers.stream().filter(e-> e.getCode().equals(code)).findFirst();
    }
}
