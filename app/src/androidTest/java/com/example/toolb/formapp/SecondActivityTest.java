package com.example.toolb.formapp;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SecondActivityTest {

    @Rule
    public ActivityTestRule<SecondActivity> activityTestRule
            = new ActivityTestRule<SecondActivity>(SecondActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Intent intentToTest = new Intent();
            intentToTest.putExtra(Constants.KEY_NAME, "Sam");
            intentToTest.putExtra(Constants.KEY_AGE, "23");
            intentToTest.putExtra(Constants.KEY_JOB, "student");
            intentToTest.putExtra(Constants.KEY_DESC, "I doing well");
            return intentToTest;
        }
    };


    @Test
    public void testThatImageExists() {
        onView(withId(R.id.pic))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testThatNameExists() {
        onView(withId(R.id.nameDisplayTextView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testThatAgeExists() {
        onView(withId(R.id.ageDisplayTextView))
                .check(matches(isDisplayed()));
    }


    @Test
    public void testThatOccupationExists() {
        onView(withId(R.id.occupationDisplayTextView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testThatBioExists() {
        onView(withId(R.id.descriptionDisplayTextView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testSubmitButton() {
        onView(withId(R.id.goBackButton)).perform(click());
    }

}
