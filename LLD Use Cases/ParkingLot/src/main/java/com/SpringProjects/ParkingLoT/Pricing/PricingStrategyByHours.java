package com.SpringProjects.ParkingLoT.Pricing;

import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyByHours implements  IPricingStrategy {
    private static Map<EnumVehicleType, Double> map = new HashMap<>();

    {
        map.put(EnumVehicleType.Bike, Double.valueOf(25));   // per hour price for bike
        map.put(EnumVehicleType.CAR, Double.valueOf(50)); // per hour price for car
        map.put(EnumVehicleType.BUS, Double.valueOf(75)); // per hour price for bus
    }

    @Override
    public double calculateFareByVehicleTypeAndDurationInSeconds(EnumVehicleType vehicleType, long durationInSeconds){
        return (durationInSeconds/3600)*map.get(vehicleType);
    }
}
