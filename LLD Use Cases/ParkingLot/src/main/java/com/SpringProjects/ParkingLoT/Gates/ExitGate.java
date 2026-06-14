package com.SpringProjects.ParkingLoT.Gates;

import com.SpringProjects.ParkingLoT.Enums.EnumPaymentStatus;
import com.SpringProjects.ParkingLoT.Enums.EnumTicketStatus;
import com.SpringProjects.ParkingLoT.ParkingLot.ParkingLot;
import com.SpringProjects.ParkingLoT.ParkingSpot.ParkingSpot;
import com.SpringProjects.ParkingLoT.Payment.IPayment;
import com.SpringProjects.ParkingLoT.Pricing.IPricingStrategy;
import com.SpringProjects.ParkingLoT.Ticket.Ticket;
import com.SpringProjects.ParkingLoT.Vehicle.IVehicle;

import java.util.Date;

public class ExitGate extends  Gate {
    public ExitGate(String gateId,boolean isOperational, ParkingLot parkingLot) {
        super(gateId,isOperational,parkingLot);
    }

    public void processVehicleExit(String ticketId, IPricingStrategy  pricingStrategy, IPayment payment){
        // check the gate is operational
        if(!isGateOperational()){
            throw  new RuntimeException("GATE is not operational");
        }
        Ticket ticket=getParkingLot().getTicket(ticketId);


        if(ticket==null || ticket.getTicketStatus().equals(EnumTicketStatus.TERMINATED)){
            throw new NullPointerException("Ticket is not valid");
        }

        ticket.setExitTime(new Date());

        // retrieve the spot and vehicle details from the ticket
        ParkingSpot spot=getParkingLot().getParkingSpotByTickeId(ticket);

        // calculate the fare based on the vehicle type and pricing strategy
        IVehicle vehicle=spot.getParkedVehicle();

        // amount
        double amount=pricingStrategy.calculateFareByVehicleTypeAndDurationInSeconds(vehicle.getVehicleType(),ticket.getDurationInSeconds());
        ticket.setAmount(amount);

        // pay the bill
        EnumPaymentStatus paymentStatus=payment.payBill(ticket.getAmount());
        if(paymentStatus.equals(EnumPaymentStatus.FAILED)){
            throw new RuntimeException("Payment failed");
        }
        ticket.setEnumTicketStatus(EnumTicketStatus.PAID);

        // unassign the vehicle from the spot
        spot.relaseVehicleAndFreeUpSpace();

        // update the ticket status to complete
        ticket.setEnumTicketStatus(EnumTicketStatus.TERMINATED);
    }

}
