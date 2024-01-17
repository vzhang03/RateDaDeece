package com.example.ratedadeece.view;

import com.example.ratedadeece.model.Deece;

public interface IReviewDeece {

    interface Listener {


//        void onClickReview (); do not think this is necessary so i commented it out

        void onReviewDeece (float stars, String comment);
    }

}
