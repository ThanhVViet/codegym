package Case_Study.models;

import Case_Study.utils.ConstantUtil.*;

public class Customer extends Person {
    private TypeCustomer typeCustomer;

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public Customer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public Customer(String fullName, String birthday, Gender gender, String phone, String email, String address, TypeCustomer typeCustomer) {
        super(fullName, birthday, gender, phone, email, address);
        this.typeCustomer = typeCustomer;
    }

    public Customer(String code, String fullName, String birthday, Gender gender, String phone, String email, String address, TypeCustomer typeCustomer) {
        super(code, fullName, birthday, gender, phone, email, address);
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s"
                , getCode(), getFullName(), getBirthday(), getGender().name(), getPhone(), getEmail(), getAddress(), getTypeCustomer().name());
    }
}
