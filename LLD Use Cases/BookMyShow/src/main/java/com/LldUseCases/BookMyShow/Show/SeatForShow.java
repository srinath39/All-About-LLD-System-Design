package com.LldUseCases.BookMyShow.Show;

import com.LldUseCases.BookMyShow.Enums.EnumSeatStatus;
import com.LldUseCases.BookMyShow.Seat.Seat;

public class SeatForShow {
    private String seatForShowId;
    private Seat seat;
    private EnumSeatStatus enumSeatStatus=EnumSeatStatus.AVAILABLE;
    private Show show;

    public SeatForShow(String seatForShowId, Seat seat, Show show) {
        this.seatForShowId = seatForShowId;
        this.seat = seat;
        this.show = show;
    }

    public void blockSeat(){
        enumSeatStatus=EnumSeatStatus.BLOCKED;
    }

    public void makeSeatAvailable(){
        enumSeatStatus=EnumSeatStatus.AVAILABLE;
    }

    public void bookSeat(){
        enumSeatStatus=EnumSeatStatus.BOOKED;
    }
    public EnumSeatStatus getSeatStatus(){
        return enumSeatStatus;
    }

    public Seat getSeat(){
        return seat;
    }

    @Override
    public String toString() {
        return "SeatForShow{" +
                "seat=" + seat +
                ", enumSeatStatus=" + enumSeatStatus +
                '}';
    }
}
