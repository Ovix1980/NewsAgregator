package com.example.ovix.newsagregator;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ovix on 1/30/19.
 */

public interface NewsAPIClient {

    String base_url = "https://newsapi.org/v2/";

    Retrofit client = new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("top-headlines")
    Call<status> getAllArticle(@Query("country") String country_id,
                               @Query("apiKey") String api_key);

}
