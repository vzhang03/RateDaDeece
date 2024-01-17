package com.example.ratedadeece.model;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class UserTest extends TestCase {

    /**
     * tests the constructor to make sure the ids generated are unique
     * also tests the getID method
     */
    public void testUnique(){
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        assertNotEquals(user1.getID(), user2.getID());
        assertNotEquals(user2.getID(), user3.getID());

        assertEquals(user1.getID(), user1.getID());
        assertEquals(user2.getID(), user2.getID());
        assertEquals(user3.getID(), user3.getID());
    }
}