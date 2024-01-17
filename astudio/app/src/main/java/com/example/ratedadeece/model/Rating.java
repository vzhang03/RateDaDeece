package com.example.ratedadeece.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Rating implements Serializable {

    private static final String REVIEW = "review";
    private static final String STARS = "stars";
    protected String date;
    protected float stars;
    protected String review;
    protected String id;

    public Rating (){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.date = today.toString();
    }
    public Rating(float stars, String review){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.date = today.toString();
        this.stars = stars;
        this.review = review;
    }

    public Rating(float stars, String review, String id){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.id = id;
        this.date = today.toString();
        this.stars = stars;
        this.review = review;
    }

    public String getDate(){ return this.date; }

    public float getStars(){ return this.stars; }

    public String getComment(){ return this.review; }

    public String getId() { return this.id; }

//    @NonNull
//    public Map<String, Object> toMap() {
//        Map<String, Object> map = new HashMap<>();
//
//        map.put(REVIEW, this.review);
//        map.put(STARS, this.stars);
//
//        return map;
//    }
//
//    @NonNull
//    public static Rating fromMap(Map<String, Object> map) {
//        String review = (String) map.get(REVIEW);
//        float stars = (float)(long) map.get(STARS);
//
//        return new Rating(stars, review);
//    }

//    @NonNull
//    public Map<String, Object> toMap() {
//        Map<String, Object> map = new HashMap<>();
//
//        List<Map<String,Object>> dishList = new LinkedList<>();
//        for (Dish : this.rating)  sliList.add(sli.toMap());
//        map.put(LINE_ITEMS, sliList);
//
//        return map;
//
//    }

    public static void main(String[] args){
        int rating = 5;
        String review = "this food rocks!";
        Rating test = new Rating(rating, review);

        System.out.println("Get Date -- " + test.getDate());
        System.out.println("Get Rating -- " + test.getStars());
        System.out.println("Get review -- " + test.getComment());
    }
}
