package com.example.movielistapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import com.example.movielistapp.R;
import com.example.movielistapp.model.Movies;
import com.example.movielistapp.viewmodels.DataAdapter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.HttpURLConnection;

public class DisplayMovieList extends Activity {

    private List<Movies> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie_list);
/*        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        mAdapter = new DataAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);*/

        if (android.os.Build.VERSION.SDK_INT > 9)
        {

            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        String API_Output = doInBackground();
        System.out.println("This is ouside function : " + API_Output);
        TextView textView = findViewById(R.id.textView);
        textView.setText(API_Output);

//        initmovieData();
    }

/*    private void initmovieData() {
        Movies movie = new Movies("Hello Android", "Ed Burnette");
        movieList.add(movie);

        movie = new Movies("Beginning Android 3", "Mark Murphy");
        movieList.add(movie);

        movie = new Movies("Unlocking Android", " W. Frank Ableson");
        movieList.add(movie);

        movie = new Movies("Android Tablet Development", "Wei Meng Lee");
        movieList.add(movie);

        movie = new Movies("Android Apps Security", "Sheran Gunasekera");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }*/

    protected String doInBackground() {
        String api_url = "http://www.omdbapi.com/?apikey=";
        String API_KEY = "2f9c3869";
        // Do some validation here

        try {
            URL url = new URL(api_url + API_KEY+"&t=movie");


            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {


                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
