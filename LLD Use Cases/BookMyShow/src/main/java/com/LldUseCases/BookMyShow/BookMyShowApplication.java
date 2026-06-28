package com.LldUseCases.BookMyShow;

import com.LldUseCases.BookMyShow.Booking.Booking;
import com.LldUseCases.BookMyShow.Booking.BookingManager;
import com.LldUseCases.BookMyShow.City.City;
import com.LldUseCases.BookMyShow.Discount.CouponCode;
import com.LldUseCases.BookMyShow.Enums.EnumSeatType;
import com.LldUseCases.BookMyShow.Package.Screen;
import com.LldUseCases.BookMyShow.Payment.UpiPayment;
import com.LldUseCases.BookMyShow.Show.Show;
import com.LldUseCases.BookMyShow.Theatre.Theatre;
import com.LldUseCases.BookMyShow.User.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;

import static com.LldUseCases.BookMyShow.Utils.GenerateUniqueId.getUniqueId;

@SpringBootApplication
public class BookMyShowApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);

		City city=new City(getUniqueId(),"Hyderabad");

		Theatre theatre=new Theatre(getUniqueId(),"AMB",city);

		Screen screen=new Screen(getUniqueId(),"Screen1",theatre);

		EnumMap<EnumSeatType,Integer> enumMap=new EnumMap<>(EnumSeatType.class);
		enumMap.put(EnumSeatType.SILVER,30);
		enumMap.put(EnumSeatType.GOLD,20);
		enumMap.put(EnumSeatType.PLATINUM,10);
		screen.loadSeatsBasedOnSeatLayouts(enumMap,10);

//		screen.getSeats().stream().forEach(System.out::println);


		EnumMap<EnumSeatType,Double> enumMapPrice=new EnumMap<>(EnumSeatType.class);
		enumMapPrice.put(EnumSeatType.SILVER,Double.valueOf(150.0));
		enumMapPrice.put(EnumSeatType.GOLD,Double.valueOf(200.0));
		enumMapPrice.put(EnumSeatType.PLATINUM,Double.valueOf(250.0));
		Show show=new Show(getUniqueId(),"KGF",screen,new Date(),theatre,enumMapPrice);



		User user=new User(getUniqueId(),"Srinath");

		BookingManager bookingManager=BookingManager.getInstance();
		Booking booking = bookingManager.bookTicketForShow(show,user, new ArrayList<>(Arrays.asList("A1","A2")) ,new UpiPayment(),new CouponCode());

		Show show2=new Show(getUniqueId(),"KGF",screen,new Date(),theatre,enumMapPrice);
		User user2=new User(getUniqueId(),"Bala");
		bookingManager.bookTicketForShow(show2,user2, new ArrayList<>(Arrays.asList("E1","E2")) ,new UpiPayment(),new CouponCode());

		show2.getSeats().stream().forEach(System.out::println);


		// pending
		// Explore Factory Pattern in payment and Discount
		// Explore Adapter pattern in payment and Discount
		// Explore Observer pattern for notification service
		//  other Design patterns too

	}

}
