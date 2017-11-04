package com.infi.newsapp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.infi.newsapp.R;
import com.infi.newsapp.fragment.NewsFragment;

public class NewsActivity extends AppCompatActivity {

    private NewsFragment mNewsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mNewsFragment = new NewsFragment();
            fragmentTransaction.add(R.id.fragment_container, mNewsFragment);
            fragmentTransaction.commit();
        }
    }

}

































