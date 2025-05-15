package com.pluralsight;
public class House extends Asset {
    // Properties specific to House
    private String address;
    private int condition; // 1 - excellent, 2 - good, 3 - fair, 4 - poor
    private int squareFoot;
    private int lotSize;

    // Constructor
    public House(String description, String dateAcquired, double originalCost,
                 String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost); // Call Asset constructor
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    // Getters for House-specific properties
    public String getAddress() {
        return address;
    }

    public int getCondition() {
        return condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    // Setters for House-specific properties
    public void setAddress(String address) {
        this.address = address;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    // Override getValue for House
    @Override
    public double getValue() {
        double valuePerSqFt;
        switch (this.condition) {
            case 1: // Excellent
                valuePerSqFt = 180.00;
                break;
            case 2: // Good
                valuePerSqFt = 130.00;
                break;
            case 3: // Fair
                valuePerSqFt = 90.00;
                break;
            case 4: // Poor
                valuePerSqFt = 80.00;
                break;
            default:
                valuePerSqFt = 0.00; // Or throw an exception for invalid condition
                System.err.println("Warning: Invalid condition for house: " + getAddress());
                break;
        }
        double houseValue = valuePerSqFt * this.squareFoot;
        double lotValue = 0.25 * this.lotSize;
        return houseValue + lotValue;
    }
}
