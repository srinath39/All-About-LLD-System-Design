package com.SpringProjects.ParkingLoT.Ticket;

import com.SpringProjects.ParkingLoT.Enums.EnumTicketStatus;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private String vehicleNo;
    private String spotId;
    private EnumTicketStatus enumTicketStatus=EnumTicketStatus.ACTIVE;
    private Date entryTime;
    private Date exitTime=null;
    private double amount;

    public Ticket(String ticketId, String vehicleNo, String spotId, Date entryTime) {
        this.ticketId = ticketId;
        this.vehicleNo = vehicleNo;
        this.spotId = spotId;
        this.entryTime = entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getSpotId() {
        return spotId;
    }

    public EnumTicketStatus getTicketStatus() {
        return enumTicketStatus;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setEnumTicketStatus(EnumTicketStatus enumTicketStatus) {
        this.enumTicketStatus = enumTicketStatus;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getDurationInSeconds(){
        return (exitTime.getTime()-entryTime.getTime())/1000;
    }
}
