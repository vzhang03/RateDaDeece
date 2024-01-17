package com.example.ratedadeece.controller;

import android.os.Bundle;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.ratedadeece.model.Dish;
import com.example.ratedadeece.model.Forum;
import com.example.ratedadeece.model.MenuController;
import com.example.ratedadeece.model.Post;
import com.example.ratedadeece.persistence.IPersistenceDeeceFacade;
import com.example.ratedadeece.view.ForumPostFragment;
import com.example.ratedadeece.view.IForumPost;
import com.example.ratedadeece.view.IMainView;
import com.example.ratedadeece.view.IReviewDeece;
import com.example.ratedadeece.view.IReviewDish;
import com.example.ratedadeece.view.IViewAnalytics;
import com.example.ratedadeece.view.IViewDishInfo;
import com.example.ratedadeece.view.IViewForum;
import com.example.ratedadeece.view.IViewMenu;
import com.example.ratedadeece.view.MainView;
import com.example.ratedadeece.view.adapters.ForumAdapter;
import com.example.ratedadeece.view.adapters.MenuAdapter;
import com.example.ratedadeece.view.ReviewDeeceFragment;
import com.example.ratedadeece.view.ReviewDishFragment;
import com.example.ratedadeece.view.ViewAnalyticsFragment;
import com.example.ratedadeece.view.ViewDishInfoFragment;
import com.example.ratedadeece.view.ViewForumFragment;
import com.example.ratedadeece.view.ViewMenuFragment;

import java.util.ArrayList;
import java.util.HashMap;
public class ControllerActivity
        extends AppCompatActivity
        implements IReviewDish.Listener, IMainView.Listener,
        IViewMenu.Listener, IReviewDeece.Listener, IViewAnalytics.Listener,
        IViewDishInfo.Listener, IViewForum.Listener, MenuAdapter.OnItemClickListener,
        IForumPost.Listener, ForumAdapter.OnItemClickListener {
    IMainView mainView;
    MenuController menuController;
    IPersistenceDeeceFacade persFacade;
    Forum forum;
    Fragment curFrag;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // start out with empty menuController
        this.menuController = new MenuController(this);
        this.menuController.loadMenu(); // this.menuController.createMockMenu(); // testing line
        this.menuController.createForum();

        // create mainView object
        this.mainView = new MainView(this, this, this);
        ViewAnalyticsFragment viewAnalyticsFragment = new ViewAnalyticsFragment(this, this.menuController);
        this.mainView.displayFragment(viewAnalyticsFragment, false, "view menu");

        // set screen contents
        setContentView(this.mainView.getRootView());
    }

    /**
     * IMainView: Switches to the menu screen when the "menu button" on the main binding
     */
    public void onClickMenuButton(){
        HashMap<String, Dish> currentMenu = this.menuController.getCurrentMenu();
        HashMap<String, Boolean> hasRated = this.menuController.getUserRatedInteractions();
        ViewMenuFragment viewMenuFragment = new ViewMenuFragment(this, currentMenu, hasRated); // why is this not accepting, when above it does (in onCreate())
        this.mainView.displayFragment(viewMenuFragment, false, "view menu");

    }


    /**
     * IMainView: Switches to the review screen when the "menu button" is clicked on the main binding
     * Note -- this does not let you review the deece multiple times and instead leads you
     * straight to menu screen
     */
    public void onClickReviewButton(){
       if (this.menuController.hasRatedDeece()){
           this.onClickMenuButton();
       }
       else {
           ReviewDeeceFragment reviewDeeceFragment = new ReviewDeeceFragment(this);
           this.mainView.displayFragment(reviewDeeceFragment, false, "review deece");
       }
    }

    /**
     * IMainView: Switches to the forum screen when the "forum" button is clicked on the main binding
     */
    public void onClickForumButton(){
        HashMap<String, ArrayList<Post>> currentForum = this.menuController.getTodaysForum();
        ViewForumFragment viewForumFragment = new ViewForumFragment(this, currentForum);
        this.mainView.displayFragment(viewForumFragment, false, "view forum");
    }

    /**
     * IViewDishInfo: switches to the review screen clicked
     * @param dish
     */
    public void onClickReview(Dish dish){
        this.pickDishReview(dish);
    }

    /**
     * IViewDishInfo: switches back to menu screen (case is triggered when dish has already been reviewed)
     */
    public void onReturnMenu(){
        this.onClickMenuButton();
    }

    /**
     * IReviewDishView: Called when review for a specific dish is to be added
     *
     * @param stars   stars given to a specific dish
     * @param comment written comment associated to specific dish
     */
    @Override
    public void onReviewDish(String dishName, float stars, String comment) {
        this.menuController.addDishRating(dishName, stars, comment);
        this.onClickMenuButton();
//        ViewAnalyticsFragment viewAnalyticsFragment = new ViewAnalyticsFragment(this, this.menuController);
//        this.mainView.displayFragment(viewAnalyticsFragment, false, "view menu");
    }

    public void pickDishInfo(Dish dish) {
        // testing to see if this dish has been rated
        String dishName = dish.getName();
        Boolean hasRatedDish = this.menuController.hasRatedDish(dishName);
        // loading fragment
        ViewDishInfoFragment viewDishInfoFragment = new ViewDishInfoFragment(this, dish, hasRatedDish);
        this.mainView.displayFragment(viewDishInfoFragment, false, "view dish info");
    }

    public void pickDishReview (Dish dish){
        ReviewDishFragment reviewDishFragment = new ReviewDishFragment(this, dish);
        this.mainView.displayFragment(reviewDishFragment, false, "review dish");
    }

    public void viewGraph(){
        // todo need to create a way to click into graph for deece to inspect more information
    }
    public void onReviewDeece(float stars, String comment){
        this.menuController.addDeeceRating(stars, comment);
        this.onClickMenuButton();
    }

    /**
     * Method called from the listener in the IViewForum listener interface
     * that is used to lead to create post screen
     *
     */
    public void clickPostButton(){
        ForumPostFragment forumPostFragment = new ForumPostFragment(this);
        this.mainView.displayFragment(forumPostFragment, false, "create forum post screen");
    }

    public void onPostInfoClick(Post p){
        // todo need to create a post screen where you can view individual posts
    }

    /**
     * Method called from the ForumPostFragment
     *
     * @param post
     */
    public void createPost(Post post) {
        this.menuController.addPost(post);
        this.onClickForumButton();
    }


    /*
    *
    *
    */
    public void onInfoButtonClick(Dish dish){
        // testing to see if this dish has been rated
        String dishName = dish.getName();
        Boolean hasRatedDish = this.menuController.hasRatedDish(dishName);
        // loading fragment
        ViewDishInfoFragment viewDishInfoFragment = new ViewDishInfoFragment(this, dish, hasRatedDish);
        this.mainView.displayFragment(viewDishInfoFragment, false, "view dish info");
    }
    public void onReviewButtonClick(Dish dish){
        ReviewDishFragment reviewDishFragment = new ReviewDishFragment(this, dish);
        this.mainView.displayFragment(reviewDishFragment, false, "review dish");
    }
}
