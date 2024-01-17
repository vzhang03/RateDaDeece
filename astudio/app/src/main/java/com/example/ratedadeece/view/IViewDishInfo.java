package com.example.ratedadeece.view;

import com.example.ratedadeece.model.Dish;

public interface IViewDishInfo {

    interface Listener {

        public void onReturnMenu();

        public void onClickReview(Dish dish);
    }

}
