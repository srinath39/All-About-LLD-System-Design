package com.SpringProjects.ParkingLoT.Vehicle;

import com.SpringProjects.ParkingLoT.Enums.EnumSpotSize;
import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

public class Bike implements IVehicle{

    private String vehicleNo;
    private EnumVehicleType vehicleType=EnumVehicleType.Bike;

    public Bike(String vehicleNo){
        this.vehicleNo=vehicleNo;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNo;
    }

    @Override
    public EnumSpotSize getSpotSize() {
        return EnumSpotSize.SMALL;
    }

    @Override
    public EnumVehicleType getVehicleType(){
        return vehicleType;
    }
}
