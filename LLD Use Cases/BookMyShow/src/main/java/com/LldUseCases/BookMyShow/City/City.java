package com.LldUseCases.BookMyShow.City;

import com.LldUseCases.BookMyShow.Theatre.Theatre;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String cityId;
    private String cityName;
    private List<Theatre> theatres=new ArrayList<>();

    public City(String cityId, String cityName) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }
}
