package com.amalsabu.json.HelperClass;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.amalsabu.json.DetailedActivity;
import com.amalsabu.json.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.viewHolder>{

    private Context context;
    private List<ExploreModel> list;

    public ExploreAdapter(Context context, List<ExploreModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.explore_card_design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        ExploreModel exploreModel=list.get(position);

        //bind data
        holder.exploreHeading.setText(exploreModel.getExplore_heading());
        holder.exploreDesc.setText(exploreModel.getExplore_desc());
        holder.exploreRatingText.setText(exploreModel.getRating_text().toString());
        holder.exploreRating.setRating(Float.parseFloat(exploreModel.getRating().toString()));
        Glide.with(context).load(exploreModel.getExplore_image()).into(holder.exploreImage);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailedActivity.class);
                //Bundle to pass data
                Bundle bundle= new Bundle();
                bundle.putString("heading",exploreModel.getExplore_heading());
                bundle.putString("cover_image",exploreModel.getExplore_image());
                bundle.putString("description",exploreModel.getExplore_desc());
                bundle.putDouble("rating",exploreModel.getRating());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder {

        ImageView exploreImage;
        TextView exploreHeading,exploreDesc,exploreRatingText;
        RatingBar exploreRating;
        ConstraintLayout constraintLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            exploreImage=itemView.findViewById(R.id.explore_image);
            exploreHeading=itemView.findViewById(R.id.explore_heading);
            exploreDesc=itemView.findViewById(R.id.explore_desc);
            exploreRatingText=itemView.findViewById(R.id.explore_rating_text);
            exploreRating=itemView.findViewById(R.id.explore_rating);
            constraintLayout=itemView.findViewById(R.id.main_layout);
        }
    }

}


