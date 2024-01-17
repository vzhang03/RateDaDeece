package com.example.ratedadeece.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratedadeece.R;
import com.example.ratedadeece.databinding.FragmentViewMenuBinding;
import com.example.ratedadeece.model.Dish;
import com.example.ratedadeece.view.adapters.MenuAdapter;

import java.util.HashMap;

public class ViewMenuFragment extends Fragment implements IViewMenu {

    FragmentViewMenuBinding binding;
    Listener listener;
    HashMap<String, Dish> currentMenu;
    HashMap<String, Boolean> hasRated;
    public ViewMenuFragment(@NonNull Listener listener, HashMap<String, Dish> currentMenu,
                            HashMap<String, Boolean> hasRated){
        this.listener = listener;
        this.currentMenu = currentMenu;
        this.hasRated = hasRated;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        this.binding = FragmentViewMenuBinding.inflate(inflater);

        RecyclerView recyclerView = this.binding.getRoot().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MenuAdapter menuAdapter = new MenuAdapter(this.currentMenu, (MenuAdapter.OnItemClickListener) listener,
                                                    hasRated);

        recyclerView.setAdapter(menuAdapter);

        return this.binding.getRoot();
    }

}