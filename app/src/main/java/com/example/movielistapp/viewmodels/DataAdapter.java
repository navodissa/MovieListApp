package com.example.movielistapp.viewmodels;

import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.movielistapp.R;
import com.example.movielistapp.model.Movies;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<Movies> movieList;

    public DataAdapter(List<Movies> movieList) {
        this.movieList = movieList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.title.setText(movieList.get(position).getTitle());
        holder.director.setText(movieList.get(position).getDirector());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView director;

        public DataViewHolder(View view) {
            super(view);
/*            title = (TextView) view.findViewById(R.id.title);
            director = (TextView) view.findViewById(R.id.director);*/
        }
    }
}
