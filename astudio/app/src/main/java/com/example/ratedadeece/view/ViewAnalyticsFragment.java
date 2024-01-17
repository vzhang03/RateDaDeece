package com.example.ratedadeece.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ratedadeece.databinding.FragmentViewAnalyticsBinding;
import com.example.ratedadeece.model.Deece;
import com.example.ratedadeece.model.MenuController;

public class ViewAnalyticsFragment extends Fragment implements IViewAnalytics {
    FragmentViewAnalyticsBinding binding;
    Listener listener;
    MenuController menuController;

    public ViewAnalyticsFragment(@NonNull Listener listener, MenuController menuController){
        this.listener = listener;
        this.menuController = menuController;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        this.binding = FragmentViewAnalyticsBinding.inflate(inflater);

        Deece deece = menuController.getDeece();
        String ratings = "The Deece is " + deece.summarizeRatings();
        this.binding.deeceRatings.setText(ratings);

        String comments = deece.summarizeComments();
        String display = "Deece comments:\n" + comments;
        this.binding.deeceComments.setText(display);

        return this.binding.getRoot();
    }



}
