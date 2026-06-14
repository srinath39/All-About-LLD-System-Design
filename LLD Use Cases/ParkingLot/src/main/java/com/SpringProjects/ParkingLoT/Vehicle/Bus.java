package com.SpringProjects.ParkingLoT.Vehicle;

import com.SpringProjects.ParkingLoT.Enums.EnumSpotSize;
import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

public class Bus implements IVehicle{
    private String vehicleNo;
    private EnumVehicleType vehicleType=EnumVehicleType.BUS;

    public Bus(String vehicleNo){
        this.vehicleNo=vehicleNo;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNo;
    }

    @Override
    public EnumSpotSize getSpotSize() {
        return EnumSpotSize.LARGE;
    }

    @Override
    public EnumVehicleType getVehicleType(){
        return vehicleType;
    }
}
