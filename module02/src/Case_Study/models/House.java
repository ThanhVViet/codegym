package Case_Study.models;

import Case_Study.utils.ConstantUtil;
import Case_Study.utils.ConstantUtil.RoomStandard;

public class House extends Facility {
    private RoomStandard roomStandard;
    private int numberOfFloor;

    public RoomStandard getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(RoomStandard roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public House(String ID, String name, double areaUsed, double cost, int maxPeople, ConstantUtil.RentType rentType, RoomStandard roomStandard, int numberOfFloor) {
        super(ID, name, areaUsed, cost, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getID(), getName(), getAreaUsed(), getCost(), getMaxPeople(), getRentType().name(),
                getRoomStandard().name());
    }
}
