package Case_Study.utils;

public interface PATH {
    interface StringPath{
        String EMPLOYEE = "/Users/thanhviet/Documents/codegym/module2/src/Case_Study/data/employee.csv";
        String CUSTOMER = "/Users/thanhviet/Documents/codegym/module2/src/Case_Study/data/customer.csv";
        String FACILITY = "/Users/thanhviet/Documents/codegym/module2/src/Case_Study/data/facility.csv";
        String VILLA = "/Users/thanhviet/Documents/codegym/module2/src/Case_Study/data/villa.csv";
        String HOUSE = "/Users/thanhviet/Documents/codegym/module2/src/Case_Study/data/house.csv";
        String ROOM = "/Users/thanhviet/Documents/codegym/module2/src/Case_Study/data/room.csv";
        String CONTRACT = "/Users/thanhviet/Documents/codegym/module2/src/Case_Study/data/contract.csv";

    }
    interface Regex{
        String VILLA = "SVVL-\\d{4}";
        String HOUSE = "SVHO-\\d{4}";
        String ROOM = "SVRO-\\d{4}";
        String SERVICE_NAME = "[A-Z][a-z]+";
        String EMPLOYEE = "E[0-9]";
        String BOOKING = "B[0-9]";
        String PHONE = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        String EMAIL =  "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    }
    interface PROMOTION{
        Integer TEN_PERCENT = 10;
        Integer TWENTY_PERCENT = 20;
        Integer FIFTY_PERCENT = 50;
    }
}
