package com.SpringProjects.ParkingLoT.Gates;

import com.SpringProjects.ParkingLoT.ParkingLot.ParkingLot;
import com.SpringProjects.ParkingLoT.ParkingSpot.ParkingSpot;
import com.SpringProjects.ParkingLoT.Ticket.Ticket;
import com.SpringProjects.ParkingLoT.Vehicle.IVehicle;

import java.util.Date;

import static com.SpringProjects.ParkingLoT.Utils.GenerateRandomID.generateRandomID;

public class EntryGate extends Gate {

    public EntryGate(String gateId,boolean isOperational, ParkingLot parkingLot) {
        super(gateId,isOperational,parkingLot);
    }

    public Ticket processVehicleEntry(IVehicle vehicle){
        // check if the vehicle is null;
        if(vehicle==null){
            return null;
        }

        // check if the gate isoperational or not
        if(!isGateOperational()){
            throw  new RuntimeException("GATE is not operational");
        }

        // check if there is any parking Spot with spot size or larger available
        ParkingSpot spot=getParkingLot().getAvailableParingSpotBySpotSize(vehicle.getSpotSize());
        if(spot==null){
            throw  new RuntimeException("SPOT is not available");
        }

        // if yes, assign the vehicle to the spot
        spot.assignVehicle(vehicle);

        // create a ticket, with vehicle and spot detail and update the status
        Ticket ticket=new Ticket(generateRandomID(),
                vehicle.getVehicleNumber(),
                spot.getParkingSpotID()
                ,new Date());

        return ticket;
    }
}
