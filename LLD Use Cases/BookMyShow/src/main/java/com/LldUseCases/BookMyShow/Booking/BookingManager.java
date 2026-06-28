package com.LldUseCases.BookMyShow.Booking;

import com.LldUseCases.BookMyShow.Discount.IDiscountCoupon;
import com.LldUseCases.BookMyShow.Enums.EnumBookingStatus;
import com.LldUseCases.BookMyShow.Enums.EnumPaymentStatus;
import com.LldUseCases.BookMyShow.Payment.IPaymentGateway;
import com.LldUseCases.BookMyShow.Show.SeatForShow;
import com.LldUseCases.BookMyShow.Show.Show;
import com.LldUseCases.BookMyShow.User.User;

import java.util.List;

public class BookingManager {
    private static BookingManager bookingManager;

    private BookingManager() {
    }

    public static BookingManager getInstance() {
        if (bookingManager == null) {
            bookingManager = new BookingManager();
        }
        return bookingManager;
    }

    public Booking bookTicketForShow(Show show, User user, List<String> seats, IPaymentGateway paymentGateway, IDiscountCoupon discountCoupon){
        try{
            // Seats is available or not
            List<SeatForShow> screenSeats =seats.stream().map((seat -> {
                if(show.getSeatForShows().containsKey(seat)){
                    return show.getSeatForShows().get(seat);
                }
                return null;
            })).toList();
            if(!(screenSeats.size()==seats.size())){
                throw new RuntimeException("All seats are not available");
            }
            // if available block the seats
            screenSeats.forEach(screenSeat -> {
                screenSeat.blockSeat();
            });
            // calculate the Amount
            double totalAmount = screenSeats.stream().map((seatForShow -> show.getSeatTypePrice().get(seatForShow.getSeat().getSeatType()))).reduce(0.0,(a,b)->{
               return a+b;
            }).doubleValue();

            // Apply Discount coupon on it
            double discountAmount=discountCoupon.applyDiscoun(totalAmount);
            // pay the amount
            EnumPaymentStatus paymentStatus=paymentGateway.payAmount(discountAmount);
            // if payment successful book the seats , and return booking with status success
            if(paymentStatus.equals(EnumPaymentStatus.SUCCESS)){
                screenSeats.forEach(screenSeat -> {
                    screenSeat.bookSeat();
                });
                return new Booking(user,show,seats,EnumBookingStatus.SUCCESFUL,discountAmount);
            }
            screenSeats.forEach(screenSeat -> {
                screenSeat.makeSeatAvailable();
            });
            return new Booking(user,show,seats,EnumBookingStatus.FAILED,discountAmount);
        }catch(Exception e){
            throw new RuntimeException("Booking not possible");
        }
    }
}
