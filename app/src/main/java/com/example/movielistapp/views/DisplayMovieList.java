package com.example.movielistapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.movielistapp.R;
import com.example.movielistapp.model.Movies;
import com.example.movielistapp.viewmodels.DataAdapter;

import java.util.ArrayList;
import java.util.List;

public class DisplayMovieList extends Activity {

    private List<Movies> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie_list);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mAdapter = new DataAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        initmovieData();
    }

    private void initmovieData() {
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
    }
}
