package com.example.movielistapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.*;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.example.movielistapp.R;
import com.example.movielistapp.model.Movies;
import com.example.movielistapp.viewmodels.DataAdapter;
import com.example.movielistapp.viewmodels.LoginViewModel;
import com.example.movielistapp.databinding.ActivityMainBinding;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    public static final String EXTRA_MESSAGE = "com.example.movielistapp.MESSAGE";
    private List<Movies> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        activityMainBinding.setViewModel(new LoginViewModel());
//        activityMainBinding.executePendingBindings();

        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

        mAdapter = new DataAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        initmovieData();
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMovieList.class);
        EditText editText = (EditText) findViewById(R.id.inEmail);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
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
