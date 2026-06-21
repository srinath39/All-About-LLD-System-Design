package com.LldUseCases.BookMyShow.Seat;

import com.LldUseCases.BookMyShow.Enums.EnumSeatType;
import com.LldUseCases.BookMyShow.Package.Screen;

public class Seat {
    private String seatNo;
    private String seatLabel;
    private Screen screen;
    private EnumSeatType  seatType;

    public Seat(String seatNo, String seatLabel, Screen screen, EnumSeatType seatType) {
        this.seatNo = seatNo;
        this.seatLabel = seatLabel;
        this.screen = screen;
        this.seatType = seatType;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public String getSeatLabel() {
        return seatLabel;
    }

    public EnumSeatType getSeatType() {
        return seatType;
    }


    @Override
    public String toString() {
        return "Seat{" +
                ", seatLabel='" + seatLabel + '\'' +
                ", seatType=" + seatType +
                '}';
    }
}
