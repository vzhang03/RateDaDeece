package com.example.ratedadeece.persistence;

import com.example.ratedadeece.model.Forum;
import com.example.ratedadeece.model.Post;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class FirestoreFacade implements IPersistenceDeeceFacade {
    private static final String ALL_DISHES = "all dishes";
    private static final String CURRENT_MENU = "current menu";
    private static final String RATINGS = "ratings";
    private static final String FORUM = "forum";
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

//    @Override
//    public void addPost(Post post) {
//        CollectionReference cref = this.db.collection(FORUM);
//        cref.add(post.toMap());
//    }

    @Override
    public void saveForum(Forum forum) {
        CollectionReference cref = this.db.collection(FORUM);
        cref.add(forum.toMap());
    }

//    @Override
//    public Deece retrieveDeece() {
//        return null;
//    }
//
//    @Override
//    public Dish retrieveDish() {
//        return null;
//    }
//
//    @Override
//    public void saveUser(User user) {
//
//    }
//
//    @Override
//    public User retrieveUser() {
//        return null;
//    }
}
