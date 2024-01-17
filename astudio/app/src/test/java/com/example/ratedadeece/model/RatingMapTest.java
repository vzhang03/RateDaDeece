package com.example.ratedadeece.model;

import junit.framework.TestCase;

public class RatingMapTest extends TestCase {


    public void testSummarizeRatings(){
        RatingMap ratingMap = new RatingMap();
        Rating r1 = new Rating(4.5F, "good!", "2032032020");

        ratingMap.addRating(r1);
        assertEquals("4.5 average stars with a total of 1 reviews", ratingMap.summarizeRatings());

        Rating r2 = new Rating(3.5F, "", "4343");

        ratingMap.addRating(r2);
        assertEquals("4.0 average stars with a total of 2 reviews", ratingMap.summarizeRatings());

    }

}