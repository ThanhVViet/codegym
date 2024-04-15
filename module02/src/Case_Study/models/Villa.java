package Case_Study.models;

import Case_Study.utils.ConstantUtil;
import Case_Study.utils.ConstantUtil.RoomStandard;

public class Villa extends Facility {
    private RoomStandard roomStandard;
    private double areaPool;
    private int numberOfFloor;

    public RoomStandard getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(RoomStandard roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public Villa(String ID, String name, double areaUsed, double cost, int maxPeople, ConstantUtil.RentType rentType, RoomStandard roomStandard, double areaPool, int numberOfFloor) {
        super(ID, name, areaUsed, cost, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.areaPool = areaPool;
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                getID(), getName(), getAreaUsed(), getCost(), getMaxPeople(), getRentType().name(), getRoomStandard().name()
                , getAreaPool(), getNumberOfFloor());
    }
}
