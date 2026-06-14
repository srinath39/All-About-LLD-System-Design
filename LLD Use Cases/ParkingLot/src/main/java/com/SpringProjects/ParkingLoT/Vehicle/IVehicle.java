package com.SpringProjects.ParkingLoT.Vehicle;

import com.SpringProjects.ParkingLoT.Enums.EnumSpotSize;
import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

public interface IVehicle {
    public String getVehicleNumber();
    public EnumSpotSize getSpotSize();
    public EnumVehicleType getVehicleType();
}
