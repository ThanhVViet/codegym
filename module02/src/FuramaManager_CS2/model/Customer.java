package FuramaManager_CS2.model;
import FuramaManager_CS2.util.ConstantUtil.Gender;
import FuramaManager_CS2.util.ConstantUtil.TypeCustomer;

public class Customer extends Person {
    private TypeCustomer typeCustomer;

    public Customer(String fullName, String birthday, Gender gender, String phone, String email, String address, TypeCustomer typeCustomer) {
        super(fullName, birthday, gender, phone, email, address);
        this.typeCustomer = typeCustomer;
    }

    public Customer(String code, String fullName, String birthday, Gender gender, String phone, String email, String address, TypeCustomer typeCustomer) {
        super(code, fullName, birthday, gender, phone, email, address);
        this.typeCustomer = typeCustomer;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "typeCustomer=" + typeCustomer +
                "} " + super.toString();
    }
}
