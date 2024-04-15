package Case_Study.services;

import Case_Study.models.Booking;
import Case_Study.models.Customer;
import Case_Study.utils.PATH;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PromotionServiceImpl implements PromotionService {

    private BookingService bookingService = new BookingServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    public List<Booking> getCustomerUseService(int year) {
        return bookingService.findAll().stream().filter(e -> e.getStartDate().getYear() == year).collect(Collectors.toList());
    }

    @Override
    public Map<Customer, Integer> getCustomerVoucher(int amountOfTenPercent, int amountOfTwentyPercent, int amountOfFiftyPercent) {
        Map<Customer, Integer> res = new LinkedHashMap<>();
        LocalDate now = LocalDate.now();

        int totalVoucher = amountOfTenPercent + amountOfTwentyPercent + amountOfFiftyPercent;
        Stack<Booking> promotionBookings = new Stack<>();
        bookingService.findAll().stream().filter(e -> e.getStartDate().getYear() == now.getYear() && e.getStartDate().getMonth() == now.getMonth())
                .collect(Collectors.toSet()).stream().sorted(Comparator.comparing(Booking::getStartDate)).limit(totalVoucher).forEach(f -> promotionBookings.add(f));

        while (!promotionBookings.isEmpty()) {
            Customer customer = customerService.get(promotionBookings.pop().getCustomerCode()).get();

            if (res.size() < amountOfTenPercent) {
                res.put(customer, PATH.PROMOTION.TEN_PERCENT);
            } else if (res.size() < amountOfTenPercent + amountOfTwentyPercent) {
                res.put(customer, PATH.PROMOTION.TWENTY_PERCENT);
            } else {
                res.put(customer, PATH.PROMOTION.FIFTY_PERCENT);
            }
        }
        return res;
    }
}
