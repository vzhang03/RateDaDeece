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
public class ReviewDeeceInstrumentedTest {
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);

    @Test
    public void testReviewDeece() {

        // get a ViewInteraction for the deece Comment text
        ViewInteraction viItemsText = Espresso.onView(
                ViewMatchers.withId(R.id.deeceComment));

        // check the text matches the default one from strings.xml
        viItemsText.check(
                ViewAssertions.matches(
                        ViewMatchers.withText(R.string.rate_deece_prompt_comment)));

        // find keyboard and type written deece review
        ViewInteraction viItemName = Espresso.onView(ViewMatchers.withId(R.id.deeceComment));
        viItemName.perform(ViewActions.typeText("not a good day for deece"));

        Espresso.closeSoftKeyboard();

        // find review button and click it
        Espresso.onView(ViewMatchers.withId(R.id.deeceSubmit))
                .perform(ViewActions.click());
    }

    /**
     * Tests that we're able to move on to the menu screen after submitting Deece review.
     */
    @Test
    public void testGoingBackToMenu(){

        // find and click the submit button
        Espresso.onView(ViewMatchers.withText(R.string.rate_deece_submit_button))
                .perform(ViewActions.click());

        // confirm we're in the menu screen by checking that a "submit review" button exists
        Espresso.onView(ViewMatchers.withId(R.id.deeceSubmit));
    }
}
