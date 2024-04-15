package Case_Study.controllers;

import Case_Study.models.Customer;
import Case_Study.services.PromotionService;
import Case_Study.services.PromotionServiceImpl;
import Case_Study.utils.CommonUtil;

import java.util.Map;

public class PromotionController {
    private static PromotionService promotionService = new PromotionServiceImpl();

    public static void show() {
        System.out.println("----- Promotion Management ------\n" +
                "1. Display list customers use service\n" +
                "2. Display list customers get voucher\n" +
                "3. Return main menu");

        int choose = CommonUtil.display(1, 3);

        switch (choose) {
            case 1:
                int year = Integer.parseInt(CommonUtil.inputWithOutEmpty("Enter year: "));
                promotionService.getCustomerUseService(year);
                break;
            case 2:
                int amountOfTenPercent = CommonUtil.typeInteger("Input amount 10% discount voucher");
                int amountOfTwentyPercent = CommonUtil.typeInteger("Input amount 20% discount voucher");
                int amountOfFiftyPercent = CommonUtil.typeInteger("Input amount 50% discount voucher");
                Map<Customer, Integer> promotions = promotionService.getCustomerVoucher(amountOfTenPercent, amountOfTwentyPercent, amountOfFiftyPercent);

                promotions.entrySet().forEach(e -> System.out.println(e.getKey() + ". Voucher:" + e.getValue() + "%"));
                break;
            case 3:
                FuramaController.displayMainMenu();
        }
    }
}
