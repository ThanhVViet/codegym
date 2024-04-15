package FuramaManager_CS2.controller;

import FuramaManager_CS2.model.Booking;
import FuramaManager_CS2.model.Customer;
import FuramaManager_CS2.service.PromotionService;
import FuramaManager_CS2.service.PromotionServiceImpl;

import java.util.List;
import java.util.Map;

public class PromotionController {
    private PromotionService promotionService= new PromotionServiceImpl();

    public List<Booking> getCustomerUseService(int year){
        return promotionService.getCustomerUseService(year);
    }

    public Map<Customer, Integer> getCustomerVoucher(int amountOfTenPercent, int amountOfTwentyPercent, int amountOfFiftyPercent){
        return promotionService.getCustomerVoucher(amountOfTenPercent, amountOfTwentyPercent, amountOfFiftyPercent);
    }
}