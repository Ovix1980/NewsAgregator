package com.example.ovix.newsagregator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<article> state_ok;
    String country = "id";
    String api_key = "a182b89ccc6e4b48a99cd9544d314663";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        NewsAPIClient newsApiService = NewsAPIClient.client.create(NewsAPIClient.class);

        Call<status> call = newsApiService.getAllArticle("id","a182b89ccc6e4b48a99cd9544d314663");

        call.enqueue(new Callback<status>() {
            @Override
            public void onResponse(Call<status> call, Response<status> response) {

                status state = response.body();



                if(state.getStatus().equals("ok")) {

                    for(int i=0; i<state.getArticles().size();i++){

                        String judul_raw = String.valueOf(state.getArticles().get(i).getTitle());
                        String[] judul = judul_raw.split("-");

                        Log.d("----------------------------------------------------------------------------"," ");
                        Log.d("Media ",String.valueOf(state.getArticles().get(i).getSource().getName()));
                        Log.d("Judul Berita ",judul[0]);
                        Log.d("Deskripsi ",String.valueOf(state.getArticles().get(i).getDescription()));
                        Log.d("Isi Berita ",String.valueOf(state.getArticles().get(i).getContent()));
                        Log.d("----------------------------------------------------------------------------"," ");

                    }

                }

               //state_ok = state.getArticles();

               //Log.d("List isi Artikel :",String.valueOf(state_ok.size()));

            }

            @Override
            public void onFailure(Call<status> call, Throwable t) {

            }
        });
    }
}
