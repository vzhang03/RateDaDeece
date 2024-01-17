package com.example.ratedadeece.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ratedadeece.R;
import com.example.ratedadeece.databinding.FragmentViewDishInfoBinding;
import com.example.ratedadeece.model.Dish;

import java.util.zip.Inflater;

public class ViewDishInfoFragment extends Fragment implements IViewDishInfo {
    FragmentViewDishInfoBinding binding;
    Listener listener;
    Dish dish;
    Boolean hasRatedDish;

    public ViewDishInfoFragment (Listener listener, Dish dish, Boolean hasRatedDish) {
        this.listener = listener;
        this.dish = dish;
        this.hasRatedDish = hasRatedDish;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        this.binding = FragmentViewDishInfoBinding.inflate(inflater);

        this.binding.dishInfo.setText(this.generateDishString());
        this.binding.dishInfo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        this.binding.commentsDisplay.setText(this.generateComments());
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (this.hasRatedDish) {
            this.binding.clickReview.setText(R.string.menu_button);
            this.binding.clickReview.setOnClickListener(v -> {
                ViewDishInfoFragment.this.listener.onReturnMenu();
            });
        } else {
            this.binding.clickReview.setOnClickListener(v -> {
                ViewDishInfoFragment.this.listener.onClickReview(ViewDishInfoFragment.this.dish);
            });
        }

    }


    public String generateDishString(){
        String dishName = this.dish.getName();
        String station = this.dish.getStation();
        String ratings = this.dish.summarizeRatings();
        return getString(R.string.dish_information_format, dishName, station, ratings);
    }

    public String generateComments(){
        return this.dish.summarizeComments();
    }

}
