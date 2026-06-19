package com.SpringProjects.ParkingLoT.ParkingLot;

import com.SpringProjects.ParkingLoT.Enums.EnumSpotSize;
import com.SpringProjects.ParkingLoT.Gates.EntryGate;
import com.SpringProjects.ParkingLoT.Gates.ExitGate;
import com.SpringProjects.ParkingLoT.ParkingSpot.ParkingSpot;
import com.SpringProjects.ParkingLoT.Ticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String name;
    private Map<String, ParkingSpot> parkingSpots=new HashMap<>();
    private Map<EnumSpotSize, ArrayList<ParkingSpot>> spotsBySizeMap=new HashMap<>();
    private Map<String, EntryGate>  entryGates=new HashMap<>();
    private Map<String, ExitGate> exitGates=new HashMap<>();
    private Map<String, Ticket> tickets=new HashMap<>();

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpots.put(parkingSpot.getParkingSpotID(), parkingSpot);
        spotsBySizeMap.computeIfAbsent(parkingSpot.getEnumSpotSize(),key->new ArrayList<>()).add(parkingSpot);
    }

    public void addEntryGate(EntryGate entryGate){
        entryGates.put(entryGate.getGateId(),entryGate);
    }

    public void addExitGate(ExitGate exitGate){
        exitGates.put(exitGate.getGateId(),exitGate);
    }

    public void addTicket(Ticket ticket){
        tickets.put(ticket.getTicketId(),ticket);
    }

    public Ticket getTicket(String ticketId){
        return tickets.get(ticketId);
    }

    public void removeTicket(String ticketId){
        tickets.remove(ticketId);
    }

    public ParkingSpot getAvailableParingSpotBySpotSize(EnumSpotSize spotSize){
        if(spotSize==null){
            return null;
        }
        ArrayList<ParkingSpot> spots=spotsBySizeMap.get(spotSize);
        if(spots!=null && !spots.isEmpty()){
            for(int i=0;i<spots.size();++i){
                ParkingSpot parkingSpot=spots.get(i);
                if(parkingSpot.isAvailable()){
                    return parkingSpot;
                }
            }
        }
        return getAvailableParingSpotBySpotSize(EnumSpotSize.getNextGreaterSpotSize(spotSize));
    }

    public ParkingSpot getParkingSpotByTickeId(Ticket ticket) {
        return parkingSpots.get(ticket.getSpotId());
    }
}
