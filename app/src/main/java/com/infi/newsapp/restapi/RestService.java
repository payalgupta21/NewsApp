package com.infi.newsapp.restapi;

import com.infi.newsapp.model.NewsBean;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by payal on 10/29/2017.
 */

public interface RestService {
    @GET("/s/2iodh4vg0eortkl/facts.json")
    Call<NewsBean> getNews();

}
































