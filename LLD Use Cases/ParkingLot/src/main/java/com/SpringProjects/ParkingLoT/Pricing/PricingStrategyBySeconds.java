package com.SpringProjects.ParkingLoT.Pricing;

import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyBySeconds implements  IPricingStrategy {

    private static Map<EnumVehicleType, Double> map = new HashMap<>();

    {
        map.put(EnumVehicleType.Bike, new Double(2));
        map.put(EnumVehicleType.CAR, new Double(4));
        map.put(EnumVehicleType.BUS, new Double(6));
    }

    @Override
    public double calculateFareByVehicleTypeAndDurationInSeconds(EnumVehicleType vehicleType, long durationInSeconds) {
        return map.get(vehicleType)*durationInSeconds;
    }
}
