package com.example.ratedadeece.view.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratedadeece.R;
import com.example.ratedadeece.model.Dish;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{
    private List<Dish> dishList;
    private HashMap<String, Boolean> hasRated;

    public interface OnItemClickListener {
        void onInfoButtonClick(Dish dish);
        void onReviewButtonClick(Dish dish);
    }

    private OnItemClickListener mListener;
    public MenuAdapter(HashMap<String, Dish> currentMenu, OnItemClickListener listener,
                        HashMap<String, Boolean> hasRated){
        this.dishList = new ArrayList<>(currentMenu.values());
        this.mListener = listener;
        this.hasRated = hasRated;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_view, parent, false);

        //setting padding
        view.setPadding(16, 10, 16, 10);
        // adjusting layout color
        view.setBackgroundColor(Color.parseColor("#E2CFEA"));

        // Create a GradientDrawable to apply rounded corners
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.parseColor("#E2CFEA"));
        gd.setCornerRadius(25);

        // Set the background drawable with rounded corners
        view.setBackground(gd);


        // setting margins between items
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 10); // left, top, right, bottom
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        // getting dish and dish info
        Dish dish = dishList.get(position);
        String dishName = dish.getName();
        // getting dish rated status
        Boolean alreadyReviewed = this.hasRated.containsKey(dishName);
        // setting contents of first box
        String dishInfo = dish.getName() + "\n@" + dish.getStation();
        holder.nameView.setText(dishInfo);
        holder.nameView.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onInfoButtonClick(dish);
            }
        });

        // setting formatting for first box
        holder.nameView.setBackgroundColor(Color.WHITE);
        holder.nameView.setPadding(5, 5, 5, 5);
        // settign contents of second box
        holder.stationView.setText(dish.summarizeRatingsConcise());
        holder.stationView.setOnClickListener(view -> {
            if (mListener != null) {
                // setting logic for if can review this dish
                if (alreadyReviewed){
                    String message = "You have already reviewed this dish today.";
                    Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
                    snackbar.show();
                } else mListener.onReviewButtonClick(dish);
            }
        });
        // setting formatting for second box
        holder.stationView.setPadding(5, 5, 5, 5);

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return this.dishList.size();
    }
    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        TextView stationView;

        public MenuViewHolder(@NonNull View itemView){
            super(itemView);
            this.nameView = itemView.findViewById(R.id.menuItemViewName);
            this.stationView = itemView.findViewById(R.id.menuItemViewStation);
        }
    }
}
