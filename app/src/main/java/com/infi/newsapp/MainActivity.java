package com.infi.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.infi.newsapp.adapter.NewsAdapter;
import com.infi.newsapp.model.NewsBean;
import com.infi.newsapp.model.Row;
import com.infi.newsapp.restapi.RestClient;
import com.infi.newsapp.restapi.RestService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private NewsBean mNewsArrayList;
    private TextView mDisconnected;
    private Row mNews;
    ProgressDialog mProgressDialog;
    private  SwipeRefreshLayout mSwipeContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mSwipeContainer = (SwipeRefreshLayout)findViewById(R.id.swipeContainer);

        //Configure the refreshing colors
        mSwipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);

        mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJSON();
                Toast.makeText(MainActivity.this, "News List Refreshed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews(){
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Fetching News........");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.smoothScrollToPosition(0);
        loadJSON();
    }

    private void loadJSON(){
        mDisconnected = (TextView) findViewById(R.id.disconnected);
        try{
            RestClient client = new RestClient();
            RestService request = RestClient.retrofitInstance.create(RestService.class);
            Call<NewsBean> call = request.getNews();
            call.enqueue(new Callback<NewsBean>() {
                @Override
                public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                    Log.d("newsurl", "response.raw().request().url();"+response.raw().request().url());
                    mNewsArrayList = response.body();
                    mRecyclerView.setAdapter(new NewsAdapter(getApplicationContext(), mNewsArrayList.getRows()));
                    mRecyclerView.smoothScrollToPosition(0);
                    mSwipeContainer.setRefreshing(false);
                    mProgressDialog.hide();
                }

                @Override
                public void onFailure(Call<NewsBean> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error Fetching mNews !", Toast.LENGTH_SHORT).show();
                    mDisconnected.setVisibility(View.VISIBLE);
                    mProgressDialog.hide();

                }
            });
        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}

































