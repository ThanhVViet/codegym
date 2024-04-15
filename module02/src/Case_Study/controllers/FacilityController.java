package Case_Study.controllers;

import Case_Study.models.Facility;
import Case_Study.models.House;
import Case_Study.models.Room;
import Case_Study.models.Villa;
import Case_Study.services.FacilityService;
import Case_Study.services.FacilityServiceImpl;
import Case_Study.utils.CommonUtil;
import Case_Study.utils.ConstantUtil.RentType;
import Case_Study.utils.ConstantUtil.RoomStandard;
import Case_Study.utils.TableList;
import Case_Study.utils.Validation;

import java.util.List;

public class FacilityController {
    private static FacilityService facilityService = new FacilityServiceImpl();

    public static void show() {
        System.out.println("------ Facility Management ------\n" +
                "1. Display list facility\n" +
                "2. Add new facility\n" +
                "3. Display list facility maintenance\n" +
                "4. Return main menu");

        int choose = CommonUtil.display(1, 4);

        switch (choose) {
            case 1:
               displayListFacility(facilityService.findAll());
               // facilityService.findAll().forEach(System.out::println);
                break;
            case 2:
                displayFunctionAdd();
                break;
            case 3:
                facilityService.findAllMaintaince().entrySet().forEach(e ->
                        System.out.println(e.getKey() + "\nBooking count: " + e.getValue()));
                break;
            case 4:
                FuramaController.displayMainMenu();
        }
    }

    public static void displayFunctionAdd() {
        System.out.println("1. Add new villa");
        System.out.println("2. Add new house");
        System.out.println("3. Add new room");
        System.out.println("4. Back to menu");

        int choose = CommonUtil.display(1, 4);

        if (choose == 4) {
            show();
        } else {

            String code = CommonUtil.inputWithOutEmpty("Code: ");
            if (choose == 1) {
                while (!Validation.isVilla(code)) {
                    System.out.printf("Invalid format. Please input again\n");
                    code = CommonUtil.inputWithOutEmpty("Code: ");
                }
            } else if (choose == 2) {
                while (!Validation.isHouse(code)) {
                    System.out.printf("Invalid format. Please input again\n");
                    code = CommonUtil.inputWithOutEmpty("Code: ");
                }
            } else {
                while (!Validation.isRoom(code)) {
                    System.out.printf("Invalid format. Please input again\n");
                    code = CommonUtil.inputWithOutEmpty("Code: ");
                }
            }

            String name = CommonUtil.inputWithOutEmpty("Name: ");
            while (!Validation.isServiceName(name)) {
                System.out.println("Invalid format. Please input again");
                name = CommonUtil.inputWithOutEmpty("Name: ");
            }

            double areaUsed = Double.parseDouble(CommonUtil.inputWithOutEmpty("Area Used: "));
            while (!Validation.checkArea(areaUsed)) {
                System.out.println("Area Used have to greater than 30 m2. Please input again");
                areaUsed = CommonUtil.typeDouble("Area Used: ");
            }

            double price = Double.parseDouble(CommonUtil.inputWithOutEmpty("Price: "));
            while (!Validation.checkCost(price)) {
                System.out.println("Price have to greater than 0. Please input again");
                price = CommonUtil.typeDouble("Price: ");
            }


            int maxPeople = CommonUtil.typeInteger("Max People: ");
            while (!Validation.checkMaxPeople(maxPeople)) {
                System.out.println("Max people have to from 0 to 20. Please input again");
                maxPeople = CommonUtil.typeInteger("Max People: ");
            }

            RentType rentType = CommonUtil.inputToEnum(RentType.class, "Rent Type: ");

            Facility facility = null;
            RoomStandard roomType;
            int numberOfFloor;

            switch (choose) {
                case 1 -> {
                    roomType = CommonUtil.inputToEnum(RoomStandard.class, "Room Type: ");

                    double areaPool = CommonUtil.typeDouble("Area Pool: ");
                    while (!Validation.checkArea(areaPool)) {
                        System.out.println("Area Pool have to greater than 30 m2. Please input again");
                        areaPool = CommonUtil.typeDouble("Area Pool: ");
                    }

                    numberOfFloor = CommonUtil.typeInteger("Number Of Floor: ");
                    while (!Validation.isFloor(numberOfFloor)) {
                        System.out.println("Number of floor have to greater than 0. Please input again");
                        numberOfFloor = CommonUtil.typeInteger("Number Of Floor: ");
                    }

                    facility = new Villa(code, name, areaUsed, price, maxPeople, rentType, roomType, areaPool, numberOfFloor);
                }
                case 2 -> {
                    roomType = CommonUtil.inputToEnum(RoomStandard.class, "Room Type: ");
                    numberOfFloor = CommonUtil.typeInteger("Number Of Floor: ");
                    facility = new House(code, name, areaUsed, price, maxPeople, rentType, roomType, numberOfFloor);
                }
                case 3 -> {
                    String freeAttachService = CommonUtil.inputWithOutEmpty("Free Attach Service: ");
                    facility = new Room(code, name, areaUsed, price, maxPeople, rentType, freeAttachService);
                }
            }

            facilityService.create(facility);
            System.out.println("Create successfully!");
        }

    }

    private static void displayListFacility(List<Facility> facilityList) {
        if (facilityList.size() > 0) {
            TableList tl = new TableList(6, "ID", "FACILITY NAME", "AREA USED", "COST", "MAX PEOPLE",
                    "RENT TYPE")
                    .sortBy(0)
                    .withUnicode(true);

            facilityList.forEach(element -> tl.addRow(element.getID(),
                    element.getName(), String.valueOf(element.getAreaUsed()),
                    String.valueOf(element.getCost()), String.valueOf(element.getMaxPeople()),
                    element.getRentType().toString()));
            tl.print();
        } else {
            System.out.println("Empty list !!!!");
        }

    }

//    private static Villa addNewVilla(){
//        Facility facility = CommonUtil.createFacility();
//        String code = CommonUtil.inputWithOutEmpty("Enter ID of Villa: ");
//        while (!code.equals(PATH.Regex.VILLA)){
//            code = CommonUtil.inputWithOutEmpty("Invalid value !! Enter in the following format: ");
//        }
//        RoomStandard roomStandard = CommonUtil.inputToEnum(RoomStandard.class, "Enter room standard: ");
//
//        Double areaPool = CommonUtil.typeDouble("Enter the area of pool: ");
//        Integer floor = CommonUtil.typeInteger("Enter number of floor: ");
//
//    }


}
