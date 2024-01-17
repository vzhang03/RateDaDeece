package com.example.ratedadeece.model;
import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Deece {
    private static final String CURRENT_MENU = "current menu";
    private static final String ALL_DISHES = "all dishes";
    private static final String RATINGS = "ratings";
    protected HashMap<String, Dish> currentMenu = new HashMap<String, Dish>();

    protected HashMap<String, Dish> allDishes = new HashMap<String, Dish>(); // cloud database vs user id (local)

    protected RatingMap ratings = new RatingMap();
    public Deece (){}

    public void resetMenu () { this.currentMenu = new HashMap<String, Dish>(); }

    /**
     * Returns the menu in string form with each dish as well as their station and average rating
     *
     * @return String containing the different menu offerings along with their station and average ratings over the total
     */
    public String getMenuString(){ // think about organizing by stations
        StringBuilder res = new StringBuilder();

        for (String key : currentMenu.keySet()) {
            Dish currentDish = currentMenu.get(key);
            assert currentDish != null;
            res.append(currentDish.name).append(": ").append(currentDish.station).append(" - ").append(currentDish.summarizeRatings()).append("\n");
        }

        return res.toString();
    }

    /**
     * Takes in a dish and implements logic to first see if it exists in the allDishesMenu, if so it accesses
     * that dish and adds it to the currentMenu. If it doesn't exist in the allDishesMenu, it appends the new
     * dish to the menu. Will probably need to adjust the logic or parameters.
     *
     * @param dish Takes in dish
     */
    public void addDish (Dish dish){
        // need to rework this to specify whether adding it to the currentMenu or all dishes menu
        // workflow will probably be to reset the dishes in the currentMenu, first look to see if a dish is in the all dishes menu
        // if not in all dishes menu will need to make a new one
        // otherwise will need to access it and add it to the list

        String nameLower = dish.name.toLowerCase();
        if (allDishes.containsKey(dish.name)) {
            this.currentMenu.put(nameLower, allDishes.get(dish.name));
        } else {
            this.allDishes.put(nameLower, dish);
            this.currentMenu.put(nameLower, dish);
        }
    }
    /* NEED TO WORK ON THIS AND HOW TO INTEGRATE SAMS PART WITH MY PART */

    /**
     * Takes in a Rating object about the Deece and adds it to the RatingMap.
     *
     * @param rating A rating object
     */
    public void addDeeceRating (Rating rating) {
        // todo save Deece rating to firestore

        this.ratings.addRating(rating);
    }

    public void addDishRating (String dishName, Rating r){
        // todo save dishRating to firestore

        dishName = dishName.toLowerCase();
        Dish dish = this.currentMenu.get(dishName);
        assert dish != null;
        dish.addRating(r);
    }

    public boolean menuContainsDish(String name){
        String lower = name.toLowerCase();
        return this.currentMenu.containsKey(lower);
    }

    public Dish getDish(String name){
        Dish res = null;
        String lower = name.toLowerCase();

        if (menuContainsDish(lower)){
            res = this.currentMenu.get(lower);
        }

        return res;
    }

    public String summarizeRatings(){
        return this.ratings.summarizeRatings();
    }
    public String getDeeceRating(){
        return this.ratings.summarizeRatings();
    }

    public String summarizeComments() { return this.ratings.summarizeComments(); }

    public HashMap<String,Dish> getCurrentMenu() { return this.currentMenu; }

    @NonNull
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(RATINGS, this.ratings);

        return map;
    }

    public static Deece fromMap(Map<String, Object> map) {
        Deece deece = new Deece();
        deece.ratings = RatingMap.fromMap((Map<String, Object>) map.get(RATINGS));

        return deece;
    }

    public static void main(String[] args) {

    }

}
