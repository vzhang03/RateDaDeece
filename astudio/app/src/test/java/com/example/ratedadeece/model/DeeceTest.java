package com.example.ratedadeece.model;

import junit.framework.TestCase;

public class DeeceTest extends TestCase {
    /**
     * Tests add dish and get dish methods
     */
    public void testAddDish(){
        Deece deece = new Deece();
        Dish d1 = new Dish("Eggs", "Home", "23193923");
        Dish d2 = new Dish("Tofu", "Root", "3232399239");
        Dish d3 = new Dish("Burger", "Grill", "2019394");
        deece.addDish(d1);
        deece.addDish(d2);
        deece.addDish(d3);

        assertTrue(deece.menuContainsDish(d1.getName()));
        assertNotNull(deece.getDish(d1.getName()));
        assertTrue(deece.menuContainsDish(d2.getName()));
        assertNotNull(deece.getDish(d2.getName()));
        assertTrue(deece.menuContainsDish(d3.getName()));
        assertNotNull(deece.getDish(d3.getName()));
    }

    /**
     * Tests getMenuString and that returns a non-empty object
     */
    public void testGetMenuString(){
        Deece deece = new Deece();
        Dish d1 = new Dish("Rice", "Home", "23094723");
        deece.addDish(d1);

        assertNotNull(deece.getMenuString());
    // test passed yippee
    }

    /**
     * Tests adding reviews to the Deece and that is able to update based
     * on the number of reviews as well as the star ratings of those reviews
     */
    public void testAddDeeceRating(){
        // test addDeeceRating and  get rating ?
        Deece deece = new Deece();
        Rating r = new Rating(4.5F, "", "3994294292");

        deece.addDeeceRating(r);
        assertEquals("4.5 average stars with a total of 1 reviews", deece.summarizeRatings());

        Rating r2 = new Rating(3.5F, "", "4343");

        deece.addDeeceRating(r2);
        assertEquals("4.0 average stars with a total of 2 reviews", deece.summarizeRatings());
    }

    /**
     * Tests add dish rating and menuContainsDish
     */
    public void testAddDishRating(){
        // testing menu contains dish and testadddishRating
        // test getDish and maybe run a dish test
        Deece deece = new Deece();
        Dish eggs = new Dish("Eggs", "Home", "3232354542");
        deece.addDish(eggs);

        if (deece.menuContainsDish(eggs.getName())){
            Rating r = new Rating(4.5F, "tasty!", "230203230");
            deece.addDishRating(eggs.getName(), r);
        }

        assertEquals("4.5 average stars with a total of 1 reviews", eggs.summarizeRatings());

    }


}