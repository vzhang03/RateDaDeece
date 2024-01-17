package com.example.ratedadeece.persistence;

import com.example.ratedadeece.model.User;

public interface IPersistenceUserFacade {

    void saveUser(User user);

    User retrieveUser();
}

