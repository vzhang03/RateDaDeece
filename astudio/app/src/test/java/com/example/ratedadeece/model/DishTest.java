package com.example.ratedadeece.model;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class DishTest extends TestCase {

    /**
     * Tests constructor, getName, getStation, getID methods
     */
    public void testGetMethods(){
        String name = "Scrambled Eggs";
        String station = "Home";
        String id = "3030405060";

        Dish dish = new Dish(name, station, id);

        assertEquals(name, dish.getName());
        assertEquals(station, dish.getStation());
        assertEquals(id, dish.getId());
    }

    /**
     * Tests equals method
     */
    public void testEquals(){
        Dish dish1 = new Dish("Eggs", "Home", "3030405060");
        Dish dish2 = new Dish("Eggs", "Home", "3030405060");
        Dish dish3 = new Dish("Sausage", "Home", "43248239482");

        assertEquals(dish1, dish2);
        assertNotEquals(dish1, dish3);
    }
}