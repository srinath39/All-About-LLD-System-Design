package com.SpringProjects.ParkingLoT.Gates;

import com.SpringProjects.ParkingLoT.ParkingLot.ParkingLot;

public class Gate{
    private String gateId;
    private boolean isOperational=true;
    private ParkingLot parkingLot;

    public Gate(String gateId,boolean isOperational, ParkingLot parkingLot) {
        this.gateId = gateId;
        this.isOperational = isOperational;
        this.parkingLot = parkingLot;
    }

    public String getGateId() {
        return gateId;
    }

    public boolean isGateOperational() {
        return isOperational;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
