package com.infi.newsapp;

/**
 * Created by Payal_gupta04 on 11/4/2017.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.infi.newsapp.activity.NewsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.notNullValue;



@RunWith(AndroidJUnit4.class)
public class NewsLayoutTest {

    @Rule
    public ActivityTestRule<NewsActivity> mActivityRule =
            new ActivityTestRule<>(NewsActivity.class);
        @Test
        public void checkDataOnActivityView(){
            onView(withId(R.layout.activity_main)).check(matches((notNullValue())));
        }
        @Test
        public void checkClickOnView(){
            onView(withId(R.id.recyclerView)).perform(click());
        }




}
