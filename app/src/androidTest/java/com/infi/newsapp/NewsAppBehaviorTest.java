package com.infi.newsapp;

/**
 * Created by Payal_gupta04 on 10/31/2017.
 */


import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import android.support.test.espresso.contrib.RecyclerViewActions;
import static android.support.test.espresso.action.ViewActions.click;

@RunWith(AndroidJUnit4.class)
public class NewsAppBehaviorTest {

    @Test
    public void checkDataOnView(){
     onView(withId(R.layout.activity_main));
    }

    @Test
    public void checkClickOnView(){
        onView(withId(R.id.recyclerView)).perform(click());
    }
    @Test
    public void clickOnImageViewAtRow() {
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }


}

