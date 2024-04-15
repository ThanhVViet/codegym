package Case_Study.services;

import Case_Study.models.Facility;
import Case_Study.models.House;
import Case_Study.models.Room;
import Case_Study.models.Villa;
import Case_Study.utils.ConstantUtil.RentType;
import Case_Study.utils.ConstantUtil.RoomStandard;
import Case_Study.utils.PATH;
import Case_Study.utils.ReadAndWrite;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static ReadAndWrite<Facility> file = new ReadAndWrite<>();

    static {
        House house = new House("HOU01", "Sweet House", 5, 55555, 5, RentType.MONTH, RoomStandard.STANDARD, 3);
        Room room = new Room("ROM1", "Single Room", 20, 20, 1, RentType.DAY, "massage");
        Villa villa = new Villa("VIL01", "Aston Villa", 12, 123, 10, RentType.MONTH, RoomStandard.DELUXE, 234, 3);
        Villa villa2 = new Villa("VIL02", "Aston Villa", 12, 123, 10, RentType.MONTH, RoomStandard.DELUXE, 234, 3);

        facilityIntegerMap.put(house, 0);
        facilityIntegerMap.put(room, 0);
        facilityIntegerMap.put(villa, 0);
        facilityIntegerMap.put(villa2, 0);

       // facilityIntegerMap = file.aggregateByKeys(PATH.StringPath.FACILITY);
    }

    @Override
    public void create(Facility facility) {
        facilityIntegerMap.put(facility, 0);
        file.write(PATH.StringPath.FACILITY, facilityIntegerMap.keySet().stream().toList(), false);
    }

    @Override
    public void edit(Facility facility) {
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (entry.getKey().getID().equals(facility.getID())) {
                facilityIntegerMap.put(facility, entry.getValue() + 1);
                break;
            }
        }
    }

    @Override
    public List<Facility> findAll() {
        return facilityIntegerMap.keySet().stream().toList();
    }

    @Override
    public Map<Facility, Integer> findAllMaintaince() {
        return facilityIntegerMap;
    }

    @Override
    public Optional<Facility> find(String ID) {
        return findAll().stream().filter(e -> e.getID().equals(ID)).findFirst();
    }

    private static Map<Facility, Integer> toEmployees() {
        Map<Facility, Integer> result = new LinkedHashMap<>();

    //    List<String> lines = file.readFile(PATH.StringPath.FACILITY);

        Map<Facility, Integer> files =file.aggregateByKeys(PATH.StringPath.FACILITY);

//        if (result instanceof Villa) {
//
//            for (String line : lines) {
//                String[] tmp = line.split(",");
//                String code = tmp[0];
//                String fullName = tmp[1];
//                double areaUsed = Double.parseDouble(tmp[2]);
//                double cost = Double.parseDouble(tmp[3]);
//                int maxPeople = Integer.parseInt(tmp[4]);
//                ConstantUtil.RentType rentType = ConstantUtil.RentType.valueOf(tmp[5]);
//                ConstantUtil.RoomStandard roomStandard = ConstantUtil.RoomStandard.valueOf(tmp[6]);
//                double areaPool = Double.parseDouble(tmp[7]);
//                int numberOfFloor = Integer.parseInt(tmp[8]);
//
//
//                Villa villa = new Villa(code, fullName, areaUsed, cost,
//                        maxPeople, rentType, roomStandard, areaPool, numberOfFloor);
//                result.put(villa, 0);
   //         }
   //     }

        return result;
    }
}
