package com.example.ratedadeece;

import static org.junit.Assert.assertEquals;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ratedadeece.controller.ControllerActivity;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AddDishReviewInstrumentedTest {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<ControllerActivity>(ControllerActivity.class);


    /**
     * Test copied from MainViewInstrumented Test in order to navigate from menu
     */
    @Test
    public void testClickReviewButton() {
        // Check text
        ViewInteraction viItemsText = Espresso.onView(
                ViewMatchers.withId(R.id.deeceComments));

        // Check text
        viItemsText.check(
                ViewAssertions.matches(
                        ViewMatchers.withText(R.string.tbd)));

        Espresso.onView(ViewMatchers.withId(R.id.reviewButton))
                .perform(ViewActions.click());
    }
    @Test
    public void testReviewDish(){
        testClickReviewButton();

        ViewInteraction viItemsText = Espresso.onView(
                ViewMatchers.withTagValue(Matchers.is(""))); // todo insert food name


        // Views on Click
        Espresso.onView(ViewMatchers.withId(R.id.clickReview))
                .perform(ViewActions.click());
    }
    @Test
    public void testDishInfoButton(){

    }

}
