package com.SpringProjects.ParkingLoT.Vehicle;

import com.SpringProjects.ParkingLoT.Enums.EnumSpotSize;
import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

public class Car implements IVehicle{
    private String vehicleNo;
    private EnumVehicleType vehicleType=EnumVehicleType.CAR;

    public Car(String vehicleNo){
        this.vehicleNo=vehicleNo;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNo;
    }

    @Override
    public EnumSpotSize getSpotSize() {
        return EnumSpotSize.MEDIUM;
    }

    @Override
    public EnumVehicleType getVehicleType(){
        return vehicleType;
    }
}
