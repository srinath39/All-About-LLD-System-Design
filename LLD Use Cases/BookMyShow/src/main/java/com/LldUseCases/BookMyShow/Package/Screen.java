package com.LldUseCases.BookMyShow.Package;

import com.LldUseCases.BookMyShow.Enums.EnumSeatType;
import com.LldUseCases.BookMyShow.Seat.Seat;
import com.LldUseCases.BookMyShow.Show.Show;
import com.LldUseCases.BookMyShow.Theatre.Theatre;
import static com.LldUseCases.BookMyShow.Utils.GenerateUniqueId.getUniqueId;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Screen {
    private String screenId;
    private String screenName;
    private Theatre theatre;
    private List<Seat> seats=new ArrayList<>();
    private List<Show> shows=new ArrayList<>();

    public Screen(String screenId, String screenName, Theatre theatre) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.theatre = theatre;
        theatre.addScreen(this);
    }

    public String getScreenId() {
        return screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public List<Seat> getSeats(){
        return seats;
    }

    public void loadSeatsBasedOnSeatLayouts(EnumMap<EnumSeatType, Integer> seatLayout,int no_of_seats_row){
        Integer index=1;
        char ch='A';
        for(EnumMap.Entry<EnumSeatType, Integer> entry:seatLayout.entrySet()){
            EnumSeatType seatType=entry.getKey();
            int seatNos=entry.getValue();
            String seatLabel;
            for(int i=0;i<seatNos;++i){
                if(index==(no_of_seats_row+1)){
                    ch=(char)(ch+1);
                    index=1;
                }
                seatLabel=String.valueOf(ch+index.toString());
                seats.add(new Seat(getUniqueId(),seatLabel,this,seatType));
                ++index;
            }
        }
    }

    public void addShow(Show show) {
        shows.add(show);
    }
}
