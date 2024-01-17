package com.example.ratedadeece.model;

import junit.framework.TestCase;

import java.time.LocalDate;

public class RatingTest extends TestCase {

    /**
     * Tests constructor, getId, getDate, getStars methods
     */
    public void testGetMethods(){
        String date = LocalDate.now().toString();

        float stars = 4.5F;
        String comment = "tastes good";
        String id = "user92999394945";

        Rating testRating = new Rating(stars, comment, id);
        assertEquals(date, testRating.getDate());
        assertEquals(stars, testRating.getStars());
        assertEquals(comment, testRating.getComment());
        assertEquals(id, testRating.getId());
    }
}