package FuramaManager_CS2.model;
import FuramaManager_CS2.util.ConstantUtil.RoomType;
import FuramaManager_CS2.util.ConstantUtil.RentType;

public class House extends Facility {
    private RoomType roomType;
    private int numberOfFloor;

    public House(RoomType roomType, int numberOfFloor) {
        this.roomType = roomType;
        this.numberOfFloor = numberOfFloor;
    }

    public House(String code, String name, double areaUsed, double price, int maxPeople, RentType rentType, RoomType roomType, int numberOfFloor) {
        super(code, name, areaUsed, price, maxPeople, rentType);
        this.roomType = roomType;
        this.numberOfFloor = numberOfFloor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomType=" + roomType +
                ", numberOfFloor=" + numberOfFloor +
                "} " + super.toString();
    }
}