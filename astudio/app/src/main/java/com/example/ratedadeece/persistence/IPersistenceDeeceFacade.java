package com.example.ratedadeece.persistence;

import com.example.ratedadeece.model.Forum;
import com.example.ratedadeece.model.Post;

public interface IPersistenceDeeceFacade {


//    public void addPost(@NonNull Post post);
//    public Forum retrieveForum();
////    public void addRating();
//    Deece retrieveDeece();
//    Dish retrieveDish();

    void saveForum(Forum forum);
}
