package Case_Study.controllers;

import Case_Study.models.Booking;
import Case_Study.models.Contract;
import Case_Study.services.*;
import Case_Study.utils.CommonUtil;
import Case_Study.utils.PATH;
import Case_Study.utils.TableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BookingController {
    private static BookingService bookingService = new BookingServiceImpl();

    private static CustomerService customerService = new CustomerServiceImpl();
    private static FacilityService facilityService = new FacilityServiceImpl();

    private static ContractService contractService = new ContractServiceImpl();

    public static void show() {
        System.out.println("----- Booking Management ------\n" +
                "1. Add new booking\n" +
                "2. Display list booking\n" +
                "3. Create new contract\n" +
                "4. Display list contracts\n" +
                "5. Edit contracts\n" +
                "6. Return main menu");

        int choose = CommonUtil.display(1, 6);

        switch (choose) {
            case 1:
                String ID = CommonUtil.inputWithOutEmpty("Enter booking ID: ");
                while (!PATH.Regex.BOOKING.equals(ID)) {
                    System.out.println("Invalid value !! Enter following format: B1,B2...");
                    ID = CommonUtil.inputWithOutEmpty("Enter again: ");
                }
                String startDate = CommonUtil.inputWithOutEmpty("Enter date booking: ");
                LocalDate sDate = LocalDate.parse(startDate, CommonUtil.getDateFormat());
                while (!CommonUtil.isDate(startDate)) {
                    System.out.println("Invalid value !! Please enter following format: dd/MM/yyyy !!!");
                    startDate = CommonUtil.inputWithOutEmpty("Enter again: ");
                }
                String endDate = CommonUtil.inputWithOutEmpty("Enter date end booking: ");
                LocalDate eDate = LocalDate.parse(endDate, CommonUtil.getDateFormat());
                while (!CommonUtil.isDate(endDate)) {
                    System.out.println("Invalid value !! Please enter following format: dd/MM/yyyy !!!");
                    endDate = CommonUtil.inputWithOutEmpty("Enter again: ");
                }
                System.out.println("--------List Customer--------");
                CustomerController.display(customerService.findAll());
                String customerID = CommonUtil.inputWithOutEmpty("Enter customer ID: ");

                System.out.println("--------List Service--------");
                facilityService.findAll().forEach(System.out::println);
                String facilityID = CommonUtil.inputWithOutEmpty("Enter facility ID");

                Booking booking = new Booking(ID, sDate, eDate, customerID, facilityID);
                bookingService.create(booking);
                break;
            case 2:
                displayBookingList(bookingService.findAll());
                break;
            case 3:

                Deque<Booking> bookings = new ArrayDeque<>(bookingService.findAll());
                while (!bookings.isEmpty()) {
                    Booking booking1 = bookings.pollLast();
                    if (!booking1.isContract()) {
                        String bookCode = booking1.getCode();
                        String cusCode = booking1.getCustomerCode();
                        System.out.println("Please create contract for " + bookCode);
                        String code = CommonUtil.inputWithOutEmpty("Contract Code");
                        double down = CommonUtil.typeDouble("Down Payment");
                        double total = CommonUtil.typeDouble("Total Payment");

                        Contract contract = new Contract(code, booking1.getCode(), down, total, cusCode);
                        contractService.create(contract);
                        booking1.setContract(true);
                        System.out.println("Created successful for " + bookCode);
                    }
                }

                System.out.println("No Bookings for create contract");

                break;
            case 4:
                displayContractList(contractService.findAll());
                break;
            case 5:
                System.out.println("------ LIST CONTRACT ------");
                displayContractList(contractService.findAll());

                String code = CommonUtil.inputWithOutEmpty("Enter contract code to edit");
                double down = CommonUtil.typeDouble("Down Payment");
                double total = CommonUtil.typeDouble("Total Payment");
                System.out.println("----- List customer ---");
                customerService.findAll().forEach(System.out::println);
                String cusCode = CommonUtil.inputWithOutEmpty("Enter customer code to booking");
                System.out.println("----- List booking ---");
                bookingService.findAll().forEach(System.out::println);
                String bookCode = CommonUtil.inputWithOutEmpty("Enter booking code to edit");
                Contract contract = new Contract(code, bookCode, down, total, cusCode);
                contractService.edit(contract);
                System.out.println("Updated successfully!");
                break;
            case 6:
                FuramaController.displayMainMenu();
        }
    }

    private static void displayBookingList(List<Booking> bookingList) {
        if (bookingList.size() > 0) {
            TableList tableList = new TableList(6, "BOOKING ID", "START DATE", "END DATE", "CUSTOMER ID", "FACILITY ID")
                    .sortBy(0)
                    .withUnicode(true);

            bookingList.forEach(element -> tableList.addRow(element.getCode()
                    , element.getStartDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    , element.getEndDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    , element.getCustomerCode(), element.getFacilityCode()));
            tableList.print();


        } else {
            System.out.println("Empty List !!!!");
        }
    }

    private static void displayContractList(List<Contract> contractList) {
        if (contractList.size() > 0) {
            TableList tableList = new TableList(6, "CONTRACT ID", "BOOKING ID", "DOWN PAYMENT",
                    "CUSTOMER ID", "TOTAL BILL")
                    .sortBy(0)
                    .withUnicode(true);

            contractList.forEach(element -> tableList.addRow(element.getCode()
                    , element.getBookingCode()
                    , String.valueOf(element.getDownPayment())
                    , element.getCustomerCode(), String.valueOf(element.getTotalPayment())));
            tableList.print();


        } else {
            System.out.println("Empty List !!!!");
        }

    }

}
