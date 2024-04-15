package Case_Study.services;


import Case_Study.models.Booking;
import Case_Study.models.Customer;

import java.util.List;
import java.util.Map;

public interface PromotionService {
    List<Booking> getCustomerUseService(int year);
    Map<Customer, Integer> getCustomerVoucher(int amountOfTenPercent, int amountOfTwentyPercent, int amountOfFiftyPercent);
}
