package com.example.ratedadeece.model;
import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Dish implements java.io.Serializable {
    private static final String NAME = "name";
    private static final String RATINGS = "rating";
    private static final String STATION = "station";
    String name = "";
    String station = "";

    String id = "";
    RatingMap ratings = new RatingMap();

    public void addRating (Rating r){
        this.ratings.addRating(r);
    }
    public Dish(String name, String station, String id){
        this.id = id;
        this.name = name;
        this.station = station;
    }

    public Dish(String name, String station, RatingMap ratings) {
        this.name = name;
        this.station = station;
        this.ratings = ratings;
    }

    public String getName(){ return this.name; }

    public String getStation() { return this.station; }

    public String getId() { return this.id; }

    // dish id number
    public void addDishID(String id) { this.id = id; }

    public String summarizeRatings(){
        return this.ratings.summarizeRatings();
    }

    public String summarizeRatingsConcise(){ return this.ratings.summarizeRatingsConcise(); }

    public String summarizeComments() { return this.ratings.summarizeComments(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) &&
                Objects.equals(station, dish.station) &&
                Objects.equals(id, dish.id);
    }

    @NonNull
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        map.put(NAME, this.name);
        map.put(RATINGS, this.ratings);
        map.put(STATION, this.station);

        return map;
    }

    @NonNull
    public static Dish fromMap(Map<String, Object> map) {
        String name = (String) map.get(NAME);
        String station = (String) map.get(STATION);
        RatingMap ratings = (RatingMap) map.get(RATINGS);

        return new Dish(name, station, ratings);
    }

}

