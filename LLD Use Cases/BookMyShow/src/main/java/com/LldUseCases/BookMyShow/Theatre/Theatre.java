package com.LldUseCases.BookMyShow.Theatre;

import com.LldUseCases.BookMyShow.City.City;
import com.LldUseCases.BookMyShow.Package.Screen;
import com.LldUseCases.BookMyShow.Show.Show;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private String theatreId;
    private String theatreName;
    private City city;
    private List<Screen> screens=new ArrayList<>();
    private List<Show> shows=new ArrayList<>();

    public Theatre(String theatreId, String theatreName, City city) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
        city.addTheatre(this);
    }

    public String getTheatreId() {
        return theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public City getCity() {
        return city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public void addShow(Show show) {
        shows.add(show);
    }
}
