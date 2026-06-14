package com.SpringProjects.ParkingLoT.Pricing;

import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

public interface IPricingStrategy {
    public double calculateFareByVehicleTypeAndDurationInSeconds(EnumVehicleType vehicleType, long durationInHours);
}
