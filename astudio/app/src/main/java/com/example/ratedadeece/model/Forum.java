package com.example.ratedadeece.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Forum {

    private static final String POSTS = "posts";

    // first key: date; second key: subject
    HashMap<String, HashMap<String, ArrayList<Post>>> posts = new HashMap<String, HashMap<String, ArrayList<Post>>>();
    public Forum(){}

    public void addPost(Post post){
        // todo save this to firestore

        String date = post.getDate();
        String subject = post.getSubject();

        HashMap<String, ArrayList<Post>> subjectMap = null;
        ArrayList<Post> postList = null;

        // guarantees that there is a map for the date
        if (posts.containsKey(date)){
            subjectMap = posts.get(date);
        }
        else {
            subjectMap = new HashMap<String, ArrayList<Post>>();
        }

        // guarantees map within the date for the subject
        assert subjectMap != null;
        if (subjectMap.containsKey(subject)){
            postList = subjectMap.get(subject);
        }
        else {
            postList = new ArrayList<Post>();
        }

        // add post to right list
        assert postList != null;
        postList.add(post);

        subjectMap.put(subject, postList);
        // updating posts
        this.posts.put(date, subjectMap);
    }

    public HashMap<String, ArrayList<Post>> getTodaysForum(){
        String date = LocalDate.now().toString();
        return this.posts.get(date);
    }

    @NonNull
    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap();

        HashMap<String, ArrayList<Post>> todaysForum = this.getTodaysForum();
        Set<String> subjects = todaysForum.keySet();
        //new subject map
        Map<String, Object> newSubMap = new HashMap<>();
        for (String subject : subjects) {
            ArrayList<Post> postList = todaysForum.get(subject);
            ArrayList<Map<String, Object>> postMapList = new ArrayList<>();
            for(Post post : postList) {
                Map<String, Object> postMap = post.toMap();
                postMapList.add(postMap);
            }
            newSubMap.put(subject, postMapList);
        }
        map.put(LocalDate.now().toString(), newSubMap);
        return map;
    }

    @NonNull
    public static Forum fromMap(@NonNull Map<String, Object> map) {
        Forum forum = new Forum();

        HashMap<String, HashMap<String, ArrayList<Post>>> newPosts = new HashMap<>();
        @SuppressWarnings("unchecked")
        HashMap<String, ArrayList<Map<String, Object>>> subjectMap = (HashMap<String, ArrayList<Map<String, Object>>>)map.get(LocalDate.now().toString());
        Set<String> subjects = subjectMap.keySet();
        HashMap<String, ArrayList<Post>> newSubMap = new HashMap<>();
        for (String subject: subjects) {
            ArrayList<Map<String, Object>> postList = subjectMap.get(subject);
            ArrayList<Post> postMapList = new ArrayList<>();
            for (Map<String, Object> post: postList) {
                postMapList.add(Post.fromMap(post));
            }
            newSubMap.put(subject, postMapList);
        }
        newPosts.put(LocalDate.now().toString(), newSubMap);
        forum.posts = newPosts;
        return forum;
    }

    public void createMockForum(){
        Post p1 = new Post("New Dish!", "Today they had a new beef brisket that was really good!", "FOOD");
        Post p2 = new Post("Construction", "There was new construction outside that is blocking the two wheelchair entrances. Everyone watch out!","GENERAL");
        Post p3 = new Post("Missing Airpods", "Yo did someone find a pair of airpods with a dinosaur case?", "MISC");

        this.addPost(p1);
        this.addPost(p2);
        this.addPost(p3);
    }





}


