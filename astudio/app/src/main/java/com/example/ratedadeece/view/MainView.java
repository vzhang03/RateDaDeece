package com.example.ratedadeece.view;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ratedadeece.databinding.MainBinding;


public class MainView implements IMainView{

    FragmentManager fmanager; // lets us perform fragment transitions
    MainBinding binding;
    Listener listener;

    public MainView(FragmentActivity activity, Context context, Listener listener){
        this.fmanager = activity.getSupportFragmentManager();
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
        this.listener = listener;

        this.binding.menuButton.setOnClickListener(v ->
                MainView.this.listener.onClickMenuButton());

        this.binding.reviewButton.setOnClickListener(v ->
                MainView.this.listener.onClickReviewButton());

        this.binding.forumButton.setOnClickListener(v ->
                MainView.this.listener.onClickForumButton());
    }

    /**
     * Retrieve the graphical widget (android view) at the root of the screen hierarchy
     *
     * @return the screen's root android view (widget)
     */
    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }

    /**
     * Replaces the contents of the screen's fragment with the one passed in
     *
     * @param fragment The fragment to be displayed
     * @param name     The name this transaction can be referred by
     */
    @Override
    public void displayFragment(Fragment fragment, boolean addToStack, String name) {
        FragmentTransaction ft = fmanager.beginTransaction();
        ft.replace(this.binding.fragmentContainer.getId(), fragment);
        if (addToStack)  ft.addToBackStack(name);
        ft.commit();
    }
}
