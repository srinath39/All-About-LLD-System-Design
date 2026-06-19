package com.SpringProjects.ParkingLoT.Pricing;

import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyBySeconds implements  IPricingStrategy {

    private static Map<EnumVehicleType, Double> map = new HashMap<>();

    {
        map.put(EnumVehicleType.Bike, Double.valueOf(2));   // per second price for bike
        map.put(EnumVehicleType.CAR, Double.valueOf(4)); // per second price for car
        map.put(EnumVehicleType.BUS, Double.valueOf(6)); // per second price for bus
    }

    @Override
    public double calculateFareByVehicleTypeAndDurationInSeconds(EnumVehicleType vehicleType, long durationInSeconds) {
        return map.get(vehicleType)*durationInSeconds;
    }
}
