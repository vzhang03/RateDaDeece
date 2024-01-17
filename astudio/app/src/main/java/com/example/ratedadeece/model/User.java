package com.example.ratedadeece.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
public class User implements Serializable {
    String id;
    String lastReset;
    HashMap<String, Boolean> hasRated = new HashMap<>();
    RatingMap dishRatings = new RatingMap();
    RatingMap deeceRatings = new RatingMap();
    Boolean funMode = false;

    public User (){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.lastReset = today.toString();

        int userIdLength = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // You can include more characters if needed
        Random random = new Random();

        StringBuilder userId = new StringBuilder(userIdLength);
        for (int i = 0; i < userIdLength; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            userId.append(randomChar);
        }

        this.id = userId.toString();
    }

    public String getID(){ return this.id; }

    public void addDishRating(Rating r, String dishName){
        this.addReviewStatus(dishName);
        this.dishRatings.addRating(r);
    }

    public void addDeeceRating(Rating r){
        this.addReviewStatus("deece");
        this.deeceRatings.addRating(r);
    }

    /**
     * @param name name of the dish/deece
     * @return Boolean of whether dish has been reviewed or not
     */
    public boolean hasReviewed(String name){
        name = name.toLowerCase();
        return this.hasRated.containsKey(name);
    }

    /**
     * Sets reviews and containsKey to true so that when try to review again you are unable to
     *
     * @param name name of dish/deece
     */
    public void addReviewStatus(String name){
        this.hasRated.put(name, true);
    }

    /**
     * Allows to look at User and when map was reset to see when to reset next
     */
    public void initializeUser(){
        String date = LocalDate.now().toString();

        if (!this.lastReset.equals(date)) {
            this.lastReset = date;
            this.hasRated = new HashMap<>();
        }
    }

    public HashMap<String, Boolean> getUserRatedInteractions(){
        return this.hasRated;
    }

    public Boolean hasRatedDeece(){
        return this.hasRated.containsKey("deece");
    }

    public Boolean hasRatedDish(String dishName){
        if (this.funMode) return false;
        else return this.hasRated.containsKey(dishName);
    }

    /**
     * allows to do infinite reviews
     */
    public void setUserFunMode(Boolean set){
        this.funMode = set;
    }

    public static void main(String[] args){
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();

        System.out.println("User 1: " + u1.getID());
        System.out.println("User 2: " + u2.getID());
        System.out.println("User 3: " + u3.getID());
    }
}
