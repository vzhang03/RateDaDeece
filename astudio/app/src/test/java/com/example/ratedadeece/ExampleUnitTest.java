package com.example.ratedadeece;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.example.ratedadeece.model.Deece;
import com.example.ratedadeece.model.Dish;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void deece_create_access() {
        // creating relevant deece and dishes
        Deece deece = new Deece ();
        Dish d1 = new Dish("Eggs", "Home", "329392932932");
        Dish d2 = new Dish("Tofu", "Root", "239293923");
        Dish d3 = new Dish("Burger", "Grill", "19392932932");
        // filling deece with dishes
        deece.addDish(d1);
        deece.addDish(d2);
        deece.addDish(d3);
        // testing dish access
        Dish testd1 = deece.getDish(d1.getName());
        Dish testd2 = deece.getDish(d2.getName());
        Dish testd3 = deece.getDish(d3.getName());
        // assertion of equality
        assertEquals(d1, testd1);
        assertEquals(d2, testd2);
        assertEquals(d3, testd3);
    }


}