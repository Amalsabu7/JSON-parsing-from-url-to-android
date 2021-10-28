package com.amalsabu.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.amalsabu.json.databinding.ActivityDetailedBinding;
import com.bumptech.glide.Glide;

public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding=ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle=getIntent().getExtras();

        //Data collection
        String mHeading=bundle.getString("heading");
        String mDescription=bundle.getString("description");
        String mCoverImage=bundle.getString("cover_image");
        Double mRating=bundle.getDouble("rating");
        Double mRatingText=bundle.getDouble("rating");

        binding.exploreHeading.setText(mHeading);
        binding.exploreDesc.setText(mDescription);
        Glide.with(this).load(mCoverImage).into(binding.exploreImage);
        binding.exploreRatingText.setText(mRatingText.toString());
        binding.exploreRating.setRating(Float.parseFloat(mRating.toString()));
    }
}