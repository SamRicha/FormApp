package com.example.toolb.formapp;


import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @After
    public void tearDown() {
        // mActivity = null;
    }


    private String Name = "Sam";
    private String age = "23";
    private String Job = "student";
    private String Bio = "I'm doing alright";


    @Test
    public void testName() {
        onView(withId(R.id.nameTextEdit)).perform(typeText(Name));
        closeSoftKeyboard();
        onView(withId(R.id.SubmitButton)).perform(click());
        onView(withId(R.id.nameTextEdit)).check(matches(withText(Name)));
    }


    @Test
    public void testOccupation() {
        onView(withId(R.id.jobTextEdit)).perform(typeText(Job));
        closeSoftKeyboard();
        onView(withId(R.id.SubmitButton)).perform(click());
        onView(withId(R.id.jobTextEdit)).check(matches(withText(Job)));
    }

    @Test
    public void testBio() {
        onView(withId(R.id.descriptionTextEdit)).perform(typeText(Bio));
        closeSoftKeyboard();
        onView(withId(R.id.SubmitButton)).perform(click());
        onView(withId(R.id.descriptionTextEdit)).check(matches(withText(Bio)));
    }

    @Test
    public void testAge() {
        onView(withId(R.id.ageTextEdit)).perform(typeText(age));
        closeSoftKeyboard();
        onView(withId(R.id.SubmitButton)).perform(click());
        onView(withId(R.id.ageTextEdit)).check(matches(withText(age)));
    }

    @Test
    public void testSubmitButton() {

        onView(withId(R.id.nameTextEdit)).perform(typeText(Name));
        closeSoftKeyboard();

        onView(withId(R.id.jobTextEdit)).perform(typeText(Job));
        closeSoftKeyboard();

        onView(withId(R.id.ageTextEdit)).perform(typeText(age));
        closeSoftKeyboard();

        onView(withId(R.id.descriptionTextEdit)).perform(typeText(Bio));
        closeSoftKeyboard();

        onView(withId(R.id.SubmitButton)).perform(click());

        /*
        onView(withId(R.id.nameDisplayTextView)).check(matches(withText(Name)));
        onView(withId(R.id.ageDisplayTextView)).check(matches(withText(age)));
        onView(withId(R.id.jobTextEdit)).check(matches(withText(Job)));
        onView(withId(R.id.descriptionDisplayTextView)).check(matches(withText(Bio)));
        */
    }


}