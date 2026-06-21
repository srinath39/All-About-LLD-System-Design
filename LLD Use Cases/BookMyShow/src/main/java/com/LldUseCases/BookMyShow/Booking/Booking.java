package com.LldUseCases.BookMyShow.Booking;

import com.LldUseCases.BookMyShow.Enums.EnumBookingStatus;
import com.LldUseCases.BookMyShow.Show.Show;
import com.LldUseCases.BookMyShow.User.User;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String bookingId;
    private User user;
    private Show show;
    private List<String> seats=new ArrayList<>();
    private EnumBookingStatus bookingStatus=EnumBookingStatus.SUCCESFUL;
    private Double Amount;

    public Booking(User user, Show show, List<String> seats, EnumBookingStatus bookingStatus, Double Amount) {
        this.user=user;
        this.show=show;
        this.seats=seats;
        this.bookingStatus=bookingStatus;
        this.Amount=Amount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<String> getSeats() {
        return seats;
    }

    public EnumBookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Double getAmount() {
        return Amount;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", user=" + user +
                ", show=" + show +
                ", seats=" + seats +
                ", bookingStatus=" + bookingStatus +
                ", Amount=" + Amount +
                '}';
    }

}
