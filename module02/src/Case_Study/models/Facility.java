package Case_Study.models;

import Case_Study.utils.ConstantUtil.RentType;

public  class Facility {
    private String ID;
    private String name;
    private double areaUsed;
    private double cost;
    private int maxPeople;
    private RentType rentType;

    public Facility() {
    }

    public Facility(String name, double areaUsed, double cost, int maxPeople, RentType rentType) {
        this.name = name;
        this.areaUsed = areaUsed;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public Facility(String ID, String name, double areaUsed, double cost, int maxPeople, RentType rentType) {
        this.ID = ID;
        this.name = name;
        this.areaUsed = areaUsed;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public double getCost() {
        return cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s"
                ,getID(), getName(), getAreaUsed(), getCost(), getMaxPeople(), getRentType().name());
    }
}
