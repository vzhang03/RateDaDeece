package com.example.ratedadeece.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratedadeece.R;
import com.example.ratedadeece.databinding.FragmentViewForumBinding;
import com.example.ratedadeece.model.Dish;
import com.example.ratedadeece.model.Forum;
import com.example.ratedadeece.model.Post;
import com.example.ratedadeece.view.adapters.ForumAdapter;
import com.example.ratedadeece.view.adapters.MenuAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewForumFragment extends Fragment implements IViewForum {

    FragmentViewForumBinding binding;
    Listener listener;
    HashMap<String, ArrayList<Post>> currentForum;
    public ViewForumFragment(@NonNull Listener listener, HashMap<String, ArrayList<Post>> currentForum){
        this.listener = listener;
        this.currentForum = currentForum;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        this.binding = FragmentViewForumBinding.inflate(inflater);

        this.binding.postButton.setOnClickListener(v ->
                ViewForumFragment.this.listener.clickPostButton());

        RecyclerView recyclerView = this.binding.getRoot().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ForumAdapter forumAdapter = new ForumAdapter(this.currentForum, (ForumAdapter.OnItemClickListener) listener);
        recyclerView.setAdapter(forumAdapter);


        return this.binding.getRoot();
    }
}
