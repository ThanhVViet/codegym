package Case_Study.models;

import Case_Study.utils.ConstantUtil;

public class Room extends Facility {
    private String freeService;

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public Room(String ID, String name, double areaUsed, double cost, int maxPeople, ConstantUtil.RentType rentType, String freeService) {
        super(ID, name, areaUsed, cost, maxPeople, rentType);
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getID(), getName(), getAreaUsed(), getCost(), getMaxPeople(), getRentType().name()
                , getFreeService());
    }
}
