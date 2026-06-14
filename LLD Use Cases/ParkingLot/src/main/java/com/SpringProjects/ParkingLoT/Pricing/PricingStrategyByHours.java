package com.SpringProjects.ParkingLoT.Pricing;

import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyByHours implements  IPricingStrategy {
    private static Map<EnumVehicleType, Double> map = new HashMap<>();

    {
        map.put(EnumVehicleType.Bike, new Double(25));
        map.put(EnumVehicleType.CAR, new Double(50));
        map.put(EnumVehicleType.BUS, new Double(75));
    }

    @Override
    public double calculateFareByVehicleTypeAndDurationInSeconds(EnumVehicleType vehicleType, long durationInSeconds){
        return (durationInSeconds/3600)*map.get(vehicleType);
    }
}
