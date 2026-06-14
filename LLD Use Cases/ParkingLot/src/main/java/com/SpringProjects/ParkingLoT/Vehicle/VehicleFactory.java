package com.SpringProjects.ParkingLoT.Vehicle;

import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;

public class VehicleFactory {
    public static IVehicle createVehicle(EnumVehicleType vehicleType,String vehicleNumber){
        switch (vehicleType){
            case CAR:
                return new Car(vehicleNumber);
            case BUS:
                return new Bus(vehicleNumber);
            default:
                return new Bike(vehicleNumber);
        }
    }
}
