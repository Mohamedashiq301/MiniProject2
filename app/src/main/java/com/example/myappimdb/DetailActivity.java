package com.example.myappimdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView=findViewById(R.id.poster_image);
        TextView title=findViewById(R.id.movie_name);
        TextView rating=findViewById(R.id.mRating);
        TextView overview=findViewById(R.id.overview_tv);

        Bundle bundle=getIntent().getExtras();

        String mtitle=bundle.getString("title");
        String mPoster=bundle.getString("poster_image");
        String mOverView = bundle.getString("overview");
        double mRating = bundle.getDouble("rating");

        Glide.with(this).load(mPoster).into(imageView);
        rating.setText(Double.toString(mRating));
        title.setText(mtitle);
        overview.setText(mOverView);


    }
}