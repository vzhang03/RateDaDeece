package com.example.ratedadeece;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ratedadeece.controller.ControllerActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainViewInstrumentedTest {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<ControllerActivity>(ControllerActivity.class);

    @Test
    public void testClickMenuButton(){
        // Check text
        ViewInteraction viItemsText = Espresso.onView(
                ViewMatchers.withId(R.id.deeceComments));

        // Check text
        viItemsText.check(
                ViewAssertions.matches(
                        ViewMatchers.withText(R.string.tbd)));

        Espresso.onView(ViewMatchers.withId(R.id.menuButton))
                .perform(ViewActions.click());
    }

    @Test
    public void testClickReviewButton(){
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
}
