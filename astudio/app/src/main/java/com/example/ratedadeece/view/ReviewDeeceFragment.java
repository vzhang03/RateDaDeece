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
import com.example.ratedadeece.databinding.FragmentReviewDeeceBinding;
import com.example.ratedadeece.model.Deece;
import com.google.android.material.snackbar.Snackbar;

public class ReviewDeeceFragment extends Fragment implements IReviewDeece {

    FragmentReviewDeeceBinding binding;

    Listener listener;

    public ReviewDeeceFragment(@NonNull Listener listener) { this.listener = listener; }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentReviewDeeceBinding.inflate(inflater);
//        String ratings = this.deece.summarizeRatings();
//        String formattedInfo = getString(R.string.rate_deece_format, ratings);
//        this.binding.deeceTitle.setText(formattedInfo);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        this.binding.deeceSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //retrieve deece star count
                final RatingBar starsRating = ReviewDeeceFragment.this.binding.deeceStars;
                final float stars = ReviewDeeceFragment.this.binding.deeceStars.getRating();

                // retrieve written comment
                final Editable deeceComment = ReviewDeeceFragment.this.binding.deeceComment.getEditableText();
                final String comment = deeceComment.toString();

                if (stars == 0){ // figure out whether we want in-between star reviews, and how to check
                    Snackbar.make(v, v.getContext().getString(R.string.deece_missing_item_fields_error),
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                starsRating.setRating(0);
                deeceComment.clear();

//                Log.i("MyTag", ReviewDeeceFragment.this.dish.getName());
                Log.i("MyTag", String.valueOf(stars));
                Log.i("MyTag", comment);

                // call the star field
                ReviewDeeceFragment.this.listener.onReviewDeece(stars, comment);
//                ReviewDeeceFragment.this.updateDeeceTitle();
                Snackbar.make(v, "Successfully rated deece!", Snackbar.LENGTH_INDEFINITE).show();


//                ReviewDeeceFragment.this.listener.onReviewDeece();
            }
        });

    }

}
