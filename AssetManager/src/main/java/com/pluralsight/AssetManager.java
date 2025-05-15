package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class AssetManager {

    public static void main(String[] args) {
        // Create an ArrayList of Asset objects
        List<Asset> assets = new ArrayList<>();

        // Load it with Assets
        // Houses
        assets.add(new House(
                "My primary residence", "2010-05-15", 250000.00,
                "123 Main St, Anytown, USA", 1, 2200, 8000
        ));
        assets.add(new House(
                "Vacation cabin", "2018-11-01", 120000.00,
                "456 Lake Rd, Lakeside, USA", 2, 1200, 20000
        ));

        // Vehicles
        assets.add(new Vehicle(
                "My daily driver", "2022-01-20", 35000.00,
                "Toyota Camry", 2022, 25000
        ));
        assets.add(new Vehicle(
                "Tom's old truck", "2015-07-10", 22000.00,
                "Ford F-150", 2012, 155000 // Over 10 years old (assuming current year 2023+), high mileage
        ));
        assets.add(new Vehicle(
                "Sarah's commuter", "2021-03-05", 18000.00,
                "Honda Civic", 2019, 110000 // High mileage, but Honda
        ));


        // Loop through the Asset collection and display information
        System.out.println("--- ASSET PORTFOLIO ---");
        for (Asset asset : assets) {
            System.out.println("------------------------------------------");
            System.out.printf("Description:    %s\n", asset.getDescription());
            System.out.printf("Date Acquired:  %s\n", asset.getDateAcquired());
            System.out.printf("Original Cost:  $%,.2f\n", asset.getOriginalCost());
            System.out.printf("Current Value:  $%,.2f\n", asset.getValue()); // Polymorphism!

            // Use instanceof to detect the type and downcast to access specific methods
            if (asset instanceof House) {
                House house = (House) asset; // Downcasting
                System.out.printf("Type:           House\n");
                System.out.printf("Address:        %s\n", house.getAddress());
                System.out.printf("Condition:      %d (1=Exc, 2=Good, 3=Fair, 4=Poor)\n", house.getCondition());
                System.out.printf("Sq. Footage:    %d sq ft\n", house.getSquareFoot());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset; // Downcasting
                System.out.printf("Type:           Vehicle\n");
                System.out.printf("Make/Model:     %s\n", vehicle.getMakeModel());
                System.out.printf("Year:           %d\n", vehicle.getYear());
                System.out.printf("Odometer:       %,d miles\n", vehicle.getOdometer());
            }
            System.out.println("------------------------------------------");
        }
    }
}