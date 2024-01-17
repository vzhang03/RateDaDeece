package com.example.ratedadeece.view;

import com.example.ratedadeece.model.Dish;

public interface IViewMenu {

    interface Listener {

        void pickDishInfo(Dish d);

        void pickDishReview(Dish dish);

    }


}
