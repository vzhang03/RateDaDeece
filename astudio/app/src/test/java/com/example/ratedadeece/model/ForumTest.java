package com.example.ratedadeece.model;

import junit.framework.TestCase;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ForumTest extends TestCase {

    @Test
    public void testAddMenu() {
        Forum forum = new Forum();
        forum.createMockForum();

        HashMap<String, ArrayList<Post>> todayPosts = forum.getTodaysForum();

        ArrayList<Post> postList = new ArrayList<>();

        for (String key : todayPosts.keySet()){
            ArrayList<Post> posts = todayPosts.get(key);
            assert posts != null;
            postList.addAll(posts);
        }

        System.out.println("does this work?");

        for (Post p : postList){
            System.out.println(p);
        }

    }
}