package com.example.ratedadeece.model;
import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Map;

public class RatingMap implements Serializable {
    private static final String RATINGS = "ratings";
    public HashMap<String, ArrayList<Rating>> ratings = new HashMap<String, ArrayList<Rating>>();
    private Rating rating;
    // hashmap organized by the date and then the ratings
    public RatingMap(){}

    public void addRating (Rating r) {
        // lets you add ratings, checks to see if there is an entry for the date or not
        LocalDate today = LocalDate.now();
        String date = today.toString();

        if (!this.ratings.containsKey(date)){
            ArrayList<Rating> empty = new ArrayList<Rating>();
            empty.add(r);
            this.ratings.put(date, empty);
        }
        else {
            ArrayList<Rating> allRatings = this.ratings.get(date);
            allRatings.add(r);
            this.ratings.put(date, allRatings);
        }
    }

    public ArrayList<Rating> todayRatings(){
        // let's see today's ratings
        LocalDate today = LocalDate.now();
        String todayDate = today.toString();
        return this.ratings.get(todayDate);
    }
    public ArrayList<Rating> viewRatings (String date) {
        // this needs to have an error check
        return this.ratings.get(date);
    }

    public String summarizeRatings (){
        LocalDate today = LocalDate.now();
        String todayDate = today.toString();
        String res = "0 average stars with a total of 0 reviews";

        if (this.ratings.containsKey(todayDate)){
            ArrayList<Rating> todayRatings = this.ratings.get(todayDate);
            double stars = 0;
            int totRatings = 0;
            assert todayRatings != null;
            for (Rating item : todayRatings) {
                stars = stars + item.getStars();
                totRatings++;
            }

            double avg = (double) stars/totRatings;
            String concat = Double.toString(avg);

            if (concat.length() > 6) concat = concat.substring(0, 5);

            res = concat + " average stars with a total of " + totRatings + " reviews";
        }

        return res;
    }

    public String summarizeRatingsConcise (){
        LocalDate today = LocalDate.now();
        String todayDate = today.toString();
        String res = "0 stars \n(0 reviews)";

        if (this.ratings.containsKey(todayDate)){
            ArrayList<Rating> todayRatings = this.ratings.get(todayDate);
            double stars = 0;
            int totRatings = 0;
            assert todayRatings != null;
            for (Rating item : todayRatings) {
                stars = stars + item.getStars();
                totRatings++;
            }

            double avg = (double) stars/totRatings;
            String concat = Double.toString(avg);

            if (concat.length() > 6) concat = concat.substring(0, 5);

            res = concat + " stars \n(" + totRatings + " reviews)";
        }

        return res;
    }

    public String summarizeComments(){
        LocalDate today = LocalDate.now();
        String todayDate = today.toString();
        StringBuilder res = new StringBuilder();

        if (this.ratings.containsKey(todayDate)){
            ArrayList<Rating> todaysRatings = this.ratings.get(todayDate);

            assert todaysRatings != null;
            for (Rating rating : todaysRatings) {
                String comment = rating.getComment();

                if (!comment.equals("")){
                    res.append("* ").append(comment).append("\n");
                }
            }
        }

        return res.toString();
    }

    @NonNull
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(RATINGS, this.ratings);

        return map;
    }

    @NonNull
    public static RatingMap fromMap(@NonNull Map<String,Object> map) {
        @SuppressWarnings("unchecked")
        HashMap<String, ArrayList<Rating>> ratings = (HashMap<String, ArrayList<Rating>>) map.get(RATINGS);
        return new RatingMap();
    }

    // edit reviews

    // delete reviews

    // create an iterator to easily test
    public static void main(String[] args){
        // date
        LocalDate today = LocalDate.now();
        String todayDate = today.toString();
        // creating Rating Map
        RatingMap rMap = new RatingMap();
        // Creating and adding Reviews
        Rating rating1 = new Rating(5, "tastes good!");
        rMap.addRating(rating1);
        Rating rating2 = new Rating(1, "sucks!");
        rMap.addRating(rating2);


        // viewing ratings
        ArrayList<Rating> allRatings = rMap.viewRatings(todayDate);
        System.out.println(rating1);
        System.out.println(rating2);
        System.out.println(allRatings);
        System.out.println(rMap.todayRatings());
    }
}
