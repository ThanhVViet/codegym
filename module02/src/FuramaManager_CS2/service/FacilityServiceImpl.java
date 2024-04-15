package FuramaManager_CS2.service;

import FuramaManager_CS2.model.Facility;
import FuramaManager_CS2.model.House;
import FuramaManager_CS2.model.Room;
import FuramaManager_CS2.model.Villa;
import FuramaManager_CS2.util.ConstantUtil.RentType;
import FuramaManager_CS2.util.ConstantUtil.RoomType;


import java.util.*;

public class FacilityServiceImpl implements FacilityService{
    private static Map<Facility, Integer> facilitys = new LinkedHashMap<>();

    static {
        House house = new House("HOU01", "Sweet House", 5, 55555, 5, RentType.MONTH, RoomType.STANDARD, 3);
        Room room = new Room("ROM1", "Single Room", 20, 20, 1, RentType.DAY, "massage");
        Villa villa = new Villa("VIL01", "Aston Villa", 12, 123, 10, RentType.MONTH, RoomType.DELUXE, 234, 3);
        Villa villa2 = new Villa("VIL02", "Aston Villa", 12, 123, 10, RentType.MONTH, RoomType.DELUXE, 234, 3);

        facilitys.put(house, 0);
        facilitys.put(room, 0);
        facilitys.put(villa, 0);
        facilitys.put(villa2, 0);
    }

    @Override
    public void create(Facility facility) {
        facilitys.put(facility, 0);
    }

    @Override
    public void update(Facility facility) {
        for (Map.Entry<Facility, Integer> f : facilitys.entrySet()){
            if(f.getKey().equals(facility)){
                facilitys.put(facility, f.getValue() + 1);
                break;
            }
        }
    }

    @Override
    public List<Facility> findAll() {
        return facilitys.keySet().stream().toList();
    }

    @Override
    public Map<Facility, Integer> findAllMaintenance() {
        return facilitys;
    }

    @Override
    public Optional<Facility> get(String code) {
        return findAll().stream().filter(e -> e.getCode().equals(code)).findFirst();
    }
}
