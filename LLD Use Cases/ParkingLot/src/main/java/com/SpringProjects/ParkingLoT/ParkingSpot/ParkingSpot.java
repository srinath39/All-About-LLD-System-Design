package com.SpringProjects.ParkingLoT.ParkingSpot;

import com.SpringProjects.ParkingLoT.Enums.EnumSpotSize;
import com.SpringProjects.ParkingLoT.Enums.EnumSpotStatus;
import com.SpringProjects.ParkingLoT.Vehicle.IVehicle;

public class ParkingSpot {
    private String parkingSpotID;
    private EnumSpotSize enumSpotSize;
    private EnumSpotStatus enumSpotStatus=EnumSpotStatus.AVAILABLE;
    private IVehicle vehicle;

    public ParkingSpot(String parkingSpotID, EnumSpotSize enumSpotSize) {
        this.parkingSpotID = parkingSpotID;
        this.enumSpotSize = enumSpotSize;
        this.vehicle = null;
    }

    public String getParkingSpotID() {
        return parkingSpotID;
    }

    public EnumSpotSize getEnumSpotSize() {
        return enumSpotSize;
    }

    public boolean isAvailable() {
        return enumSpotStatus.equals(EnumSpotStatus.AVAILABLE);
    }

    public IVehicle getParkedVehicle() {
        return vehicle;
    }

    public void setEnumSpotStatus(EnumSpotStatus enumSpotStatus) {
        this.enumSpotStatus = enumSpotStatus;
    }

    public void assignVehicle(IVehicle vehicle) {
        if(!isAvailable()){
            throw new RuntimeException("ParkingSpot is unavailable");
        }
        this.vehicle = vehicle;
        enumSpotStatus=EnumSpotStatus.OCCUPIED;
    }

    private void removeVehicle(IVehicle vehicle) {
        this.vehicle = null;
        enumSpotStatus=EnumSpotStatus.AVAILABLE;
    }

    public void relaseVehicleAndFreeUpSpace(){
        this.removeVehicle(this.vehicle);
    }
}
