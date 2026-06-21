package com.LldUseCases.BookMyShow.Show;

import com.LldUseCases.BookMyShow.Enums.EnumSeatType;
import com.LldUseCases.BookMyShow.Package.Screen;
import com.LldUseCases.BookMyShow.Theatre.Theatre;
import static com.LldUseCases.BookMyShow.Utils.GenerateUniqueId.getUniqueId;

import java.util.*;

public class Show {
    private String showId;
    private String name;
    private Screen screen;
    private Date showStartDate;
    private Date showEndDate=null;
    private Theatre theatre;
    private Map<String,SeatForShow> seats=new HashMap<>();
    EnumMap<EnumSeatType,Double> seatTypePrice;

    public Show(String showId, String movieName, Screen screen, Date showStartDate, Theatre theatre,
                EnumMap<EnumSeatType,Double> seatTypePrice) {
        this.showId = showId;
        this.name = movieName;
        this.screen = screen;
        this.showStartDate = showStartDate;
        this.theatre = theatre;
        this.seatTypePrice=seatTypePrice;
        theatre.addShow(this);
        screen.addShow(this);
        screen.getSeats().stream().forEach(seat -> {
            seats.put(seat.getSeatLabel(),new SeatForShow(getUniqueId(),seat,this));
        });
    }

    public Map<String,SeatForShow> getSeatForShows(){
        return seats;
    }


    public Long getShowTimingsInHours(){
        return (showEndDate.getTime() - showStartDate.getTime())/(3600*3600);
    }

    public List<SeatForShow> getSeats() {
        return new ArrayList<>(seats.values());
    }

    public EnumMap<EnumSeatType,Double> getSeatTypePrice() {
        return seatTypePrice;
    }

}
