package com.example.ratedadeece.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Post {
    public static final String TITLE = "title";
    public static final String SUBJECT = "subject";
    public static final String POST = "post";
    String title;
    String post;
    int interactions;
    String subject;
    String date;
    String userID;

    public Post(String title, String post, String subject){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.date = today.toString();

        this.title = title;
        this.post = post;
        this.interactions = 0;
        this.subject = String.valueOf(subject);
    }
    public Post(String title, String post, String subject, String userID){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.date = today.toString();
        this.userID = userID;

        this.title = title;
        this.post = post;
        this.interactions = 0;
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getInteractions() {
        return interactions;
    }

    public void setInteractions(int interactions) {
        this.interactions = interactions;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    @NonNull
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        map.put(TITLE, this.title);
        map.put(SUBJECT, this.subject);
        map.put(POST, this.post);

        return map;
    }

    @NonNull
    public static Post fromMap(Map<String, Object> map) {
        String title = (String) map.get(TITLE);
        String subject = (String) map.get(SUBJECT);
        String post = (String) map.get(POST);

        return new Post(title,post,subject);
    }

}
