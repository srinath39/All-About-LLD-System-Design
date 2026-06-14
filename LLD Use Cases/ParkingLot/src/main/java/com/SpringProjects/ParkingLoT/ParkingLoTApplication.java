package com.SpringProjects.ParkingLoT;

import com.SpringProjects.ParkingLoT.Enums.EnumSpotSize;
import com.SpringProjects.ParkingLoT.Enums.EnumVehicleType;
import com.SpringProjects.ParkingLoT.Gates.EntryGate;
import com.SpringProjects.ParkingLoT.Gates.ExitGate;
import com.SpringProjects.ParkingLoT.ParkingLot.ParkingLot;
import com.SpringProjects.ParkingLoT.ParkingSpot.ParkingSpot;
import com.SpringProjects.ParkingLoT.Payment.UpiPayment;
import com.SpringProjects.ParkingLoT.Pricing.PricingStrategyBySeconds;
import com.SpringProjects.ParkingLoT.Ticket.Ticket;
import com.SpringProjects.ParkingLoT.Vehicle.IVehicle;
import com.SpringProjects.ParkingLoT.Vehicle.VehicleFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.SpringProjects.ParkingLoT.Utils.GenerateRandomID.generateRandomID;

@SpringBootApplication
public class ParkingLoTApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingLoTApplication.class, args);
		// step 1: setup
		ParkingLot parkingLot=new ParkingLot();

		ParkingSpot bikeSpot1=new ParkingSpot(generateRandomID(), EnumSpotSize.SMALL);
		ParkingSpot bikeSpot2=new ParkingSpot(generateRandomID(), EnumSpotSize.SMALL);
		ParkingSpot bikeSpot3=new ParkingSpot(generateRandomID(), EnumSpotSize.SMALL);


		ParkingSpot carSpot1=new ParkingSpot(generateRandomID(), EnumSpotSize.MEDIUM);
		ParkingSpot carSpot2=new ParkingSpot(generateRandomID(), EnumSpotSize.MEDIUM);
		ParkingSpot carSpot3=new ParkingSpot(generateRandomID(), EnumSpotSize.MEDIUM);

		ParkingSpot busSpot1=new ParkingSpot(generateRandomID(), EnumSpotSize.LARGE);
		ParkingSpot busSpot2=new ParkingSpot(generateRandomID(), EnumSpotSize.LARGE);
		ParkingSpot busSpot3=new ParkingSpot(generateRandomID(), EnumSpotSize.LARGE);

		parkingLot.addParkingSpot(bikeSpot1);
		parkingLot.addParkingSpot(bikeSpot2);
		parkingLot.addParkingSpot(bikeSpot3);
		parkingLot.addParkingSpot(busSpot1);
		parkingLot.addParkingSpot(busSpot2);
		parkingLot.addParkingSpot(busSpot3);
		parkingLot.addParkingSpot(carSpot1);
		parkingLot.addParkingSpot(carSpot2);
		parkingLot.addParkingSpot(carSpot3);

		EntryGate entryGate=new EntryGate(generateRandomID(),true,parkingLot);
		parkingLot.addEntryGate(entryGate);

		ExitGate exitGate=new ExitGate(generateRandomID(),true,parkingLot);
		parkingLot.addExitGate(exitGate);


		// step 2 : Parking Management flow  - vehicle at entry Gate
		IVehicle vehicle= VehicleFactory.createVehicle(EnumVehicleType.BUS,generateRandomID());
		Ticket ticket=entryGate.processVehicleEntry(vehicle);
		parkingLot.addTicket(ticket);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // step3 : Parking Management flow - Vehicle at exit gate
		exitGate.processVehicleExit(ticket.getTicketId(),new PricingStrategyBySeconds(),new UpiPayment());



	}

}
