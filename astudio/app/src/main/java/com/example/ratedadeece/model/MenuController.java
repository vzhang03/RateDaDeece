package com.example.ratedadeece.model;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.ratedadeece.controller.ControllerActivity;
import com.example.ratedadeece.persistence.FirestoreFacade;
import com.example.ratedadeece.persistence.IPersistenceDeeceFacade;
import com.example.ratedadeece.persistence.IPersistenceUserFacade;
import com.example.ratedadeece.persistence.LocalStorageUserFacade;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuController {

    public Deece deece;
    public User user;
    protected MenuLoader menuLoader;
    public Forum forum;
    IPersistenceUserFacade persFacade;
    Context context;

    IPersistenceDeeceFacade persDeeceFacade;

    public MenuController(Context context) {
        this.context = context;

        // loads user from local storage
        this.persFacade = new LocalStorageUserFacade(context.getFilesDir());
        this.user = this.persFacade.retrieveUser();
        if (this.user == null) this.user = new User();
        // reset user reviews if needed (this is done between days
        this.user.initializeUser();
        this.user.setUserFunMode(false); // todo: if you want to set user logic (set false), if you want to leave inifite reviews to test multiple ratings (set true)

        this.persDeeceFacade = new FirestoreFacade();

//        // todo load forum object from firestore
        this.forum = new Forum();

        // todo load deece object from firestore
        this.deece = new Deece();
        this.menuLoader = new MenuLoader();
    }

    public HashMap<String, Dish> getCurrentMenu() {
        return deece.getCurrentMenu();
    }

    public void addDeeceRating(float stars, String review) {
        Rating r = new Rating(stars, review, this.user.getID());

        // adds rating to user and saves to local storage
        this.user.addDeeceRating(r);
        this.persFacade.saveUser(this.user);

        this.deece.addDeeceRating(r);
    }

    public boolean menuContainsDish(String dishName) {
        return this.deece.menuContainsDish(dishName.toLowerCase());
    }

    public void addDishRating(String dishName, float stars, String review) {
        Rating r = new Rating(stars, review, this.user.getID());

        // adding rating to user and saving to local storage
        this.user.addDishRating(r, dishName);

        this.persFacade.saveUser(this.user);

        this.deece.addDishRating(dishName.toLowerCase(), r);
    }

    public void loadMenu() {
        // check if menu is up to date -- if it is, don't do anything
        // otherwise call getMenu
        this.menuLoader.getMenu(this.deece);

        // save Deece CurrentMenu to firestore
    }

    public Deece getDeece() {
        return this.deece;
    }


    /**
     * Adds a post to the forum in the forum class
     *
     * @param p Post
     */
    public void addPost(Post p) {
        forum.addPost(p);
        this.persDeeceFacade.saveForum(this.forum);
    }

    /**
     * Creates mock forum from the forum class
     */
    public void createForum() {
         this.forum.createMockForum();
    }

    /**
     * @return a hashmap containing all of today's forums posts organized by subject
     */
    public HashMap<String, ArrayList<Post>> getTodaysForum() {
        return this.forum.getTodaysForum();
    }

    /**
     * @return a hashmap containing the different dishes and items that the user has rated
     */
    public HashMap<String, Boolean> getUserRatedInteractions(){
        return this.user.getUserRatedInteractions();
    }

    public Boolean hasRatedDeece(){
        return user.hasRatedDeece();
    }

    public Boolean hasRatedDish(String dishName){
        return user.hasRatedDish(dishName);
    }


}

