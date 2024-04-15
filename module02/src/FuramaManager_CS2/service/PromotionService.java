package FuramaManager_CS2.service;

import FuramaManager_CS2.model.Booking;
import FuramaManager_CS2.model.Customer;

import java.util.List;
import java.util.Map;

public interface PromotionService {
    List<Booking> getCustomerUseService(int year);
    Map<Customer, Integer> getCustomerVoucher(int amountOfTenPercent, int amountOfTwentyPercent, int amountOfFiftyPercent);
}

