package com.example.ratedadeece.view;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ratedadeece.R;
import com.example.ratedadeece.databinding.FragmentReviewDishBinding;
import com.example.ratedadeece.model.Dish;
import com.google.android.material.snackbar.Snackbar;

public class ReviewDishFragment extends Fragment implements IReviewDish {
    FragmentReviewDishBinding binding; // reference to graphical widgets
    Listener listener; // observer to be notified of events of interest
    Dish dish;

    public ReviewDishFragment(@NonNull Listener listener){
        this.listener = listener;
    }

    public ReviewDishFragment(@NonNull Listener listener, Dish dish){
        this.listener = listener;
        this.dish = dish;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentReviewDishBinding.inflate(inflater);

        String dishName = this.dish.getName();
        String station = this.dish.getStation();
        String ratings = this.dish.summarizeRatings();
        String formattedInfo = getString(R.string.dish_information_format, dishName, station, ratings);
        this.binding.dishInformation.setText(formattedInfo);
        this.binding.dishInformation.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        this.binding.dishSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // retrieve star count
                final RatingBar starsRating = ReviewDishFragment.this.binding.dishStars;
                final float stars = ReviewDishFragment.this.binding.dishStars.getRating();

                // retrieve written comment
                final Editable dishComment = ReviewDishFragment.this.binding.dishComment.getEditableText();
                final String comment = dishComment.toString();

                if (stars == 0){ // figure out whether we want in-between star reviews, and how to check
                    Snackbar.make(v, v.getContext().getString(R.string.missing_item_fields_error),
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                starsRating.setRating(0);
                dishComment.clear();

                Log.i("MyTag", ReviewDishFragment.this.dish.getName());
                Log.i("MyTag", String.valueOf(stars));
                Log.i("MyTag", comment);

                // call the star field
                ReviewDishFragment.this.listener.onReviewDish(ReviewDishFragment.this.dish.getName(), stars, comment);
                ReviewDishFragment.this.updateDishName();
                Snackbar.make(v, "sucessfully entered dish", Snackbar.LENGTH_INDEFINITE).show();
            }
        });

    }
    public void updateDishName(){
        String dishName = this.dish.getName();
        String station = this.dish.getStation();
        String ratings = this.dish.summarizeRatings();
        String formattedInfo = getString(R.string.dish_information_format, dishName, station, ratings);
        this.binding.dishInformation.setText(formattedInfo);
    }

}
