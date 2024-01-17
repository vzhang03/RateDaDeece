package com.example.ratedadeece.view;

import android.view.View;

import androidx.fragment.app.Fragment;
public interface IMainView {

    interface Listener {

        /**
         * Called when user clicks button to access menu screen
         */
        void onClickMenuButton();

        /**
         * Called when user clicks button to access review screen
         */
        void onClickReviewButton();

        void onClickForumButton();
    }

    /**
     * Retrieve the graphical widget (android view) at the root of the screen hierarchy
     * @return the screen's root android view (widget)
     */
    View getRootView();

    /**
     * Replaces the contents of the screen's fragment with the one passed in
     *
     * @param fragment The fragment to be displayed
     * @param name The name this transaction can be referred by
     */
    void displayFragment(Fragment fragment, boolean addToStack, String name);

}
