package com.pluralsight;
import java.util.Calendar; // For getting the current year

public class Vehicle extends Asset {
    // Properties specific to Vehicle
    private String makeModel;
    private int year;
    private int odometer;

    // Constructor
    public Vehicle(String description, String dateAcquired, double originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost); // Call Asset constructor
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // Getters for Vehicle-specific properties
    public String getMakeModel() {
        return makeModel;
    }

    public int getYear() {
        return year;
    }

    public int getOdometer() {
        return odometer;
    }

    // Setters for Vehicle-specific properties
    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // Override getValue for Vehicle
    @Override
    public double getValue() {
        double currentValue;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - this.year;

        if (age < 0) age = 0; // Handles cases where year might be in the future or data entry error

        if (age <= 3) { // 0-3 years old
            currentValue = getOriginalCost() * (1 - (0.03 * age));
        } else if (age <= 6) { // 4-6 years old
            currentValue = getOriginalCost() * (1 - (0.06 * age));
        } else if (age <= 10) { // 7-10 years old
            currentValue = getOriginalCost() * (1 - (0.08 * age));
        } else { // over 10 years old
            currentValue = 1000.00;
        }

        // Ensure value doesn't go below 0 from depreciation calculation if originalCost was low
        if (currentValue < 0 && age <=10) {
            currentValue = 0;
        }


        // MINUS reduce final value by 25% if over 100,000 miles
        // unless makeModel contains word Honda or Toyota
        if (this.odometer > 100000) {
            boolean isHondaOrToyota = this.makeModel.toLowerCase().contains("honda") ||
                    this.makeModel.toLowerCase().contains("toyota");
            if (!isHondaOrToyota) {
                currentValue *= 0.75; // Reduce by 25%
            }
        }
        return currentValue;
    }
}