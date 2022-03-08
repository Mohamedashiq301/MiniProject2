package com.example.myappimdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.MovieHolder>{

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movies){
        this.context=context;
        movieList=movies;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie=movieList.get(position);
        holder.rating.setText(movie.getRating().toString());
        holder.title.setText(movie.getTitle());
        holder.overview.setText(movie.getOverview());
        Glide.with(context).load(movie.getPoster()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title,overview,rating;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.poster_image);
            title=itemView.findViewById(R.id.movie_name);
            overview=itemView.findViewById(R.id.overview_tv);
            rating=itemView.findViewById(R.id.mRating);
        }
    }

}
