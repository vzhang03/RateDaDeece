package com.example.ratedadeece.persistence;

import android.util.Log;

import com.example.ratedadeece.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class LocalStorageUserFacade implements IPersistenceUserFacade {

    private final File userFile; // where files are to be stored
    private static final String USER_FNAME = "user.ratedadeeece";

    public LocalStorageUserFacade(File directory) {
        this.userFile = new File(directory, USER_FNAME);
    }

    @Override
    public User retrieveUser() {
        User user = null; // null to begin with to check for negative outcomes

        if (userFile.isFile()){

            try {
                FileInputStream fileInStream = new FileInputStream(userFile);
                ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);
                user = (User) objectInStream.readObject();
            } catch (IOException e){
                final String emsg = String.format("I/O error writing to %s", this.userFile);
                Log.e("ratedadeece", emsg);
                e.printStackTrace();
            } catch (ClassNotFoundException e){
                final String emsg = String.format("Can't find class of oject from %s", this.userFile);
                Log.e("ratedadeece", emsg);
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public void saveUser(User user) {
        try {
            FileOutputStream fos = new FileOutputStream(this.userFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user); // write object to file
        } catch (IOException e){
            final String emsg = String.format("I/O error writing to %s", this.userFile);
            Log.e("ratedadeece", emsg);
            e.printStackTrace();
        }
    }


}
