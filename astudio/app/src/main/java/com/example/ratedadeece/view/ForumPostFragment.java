package com.example.ratedadeece.view;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ratedadeece.R;
import com.example.ratedadeece.databinding.FragmentForumPostBinding;
import com.example.ratedadeece.databinding.FragmentViewForumBinding;
import com.example.ratedadeece.model.Forum;
import com.example.ratedadeece.model.Post;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ForumPostFragment extends Fragment implements IForumPost{
    FragmentForumPostBinding binding;
    Listener listener;

    ArrayList<String> subjects = new ArrayList<String>();

    public ForumPostFragment(@NonNull Listener listener){
        this.listener = listener;
        this.createSubjects();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        this.binding = FragmentForumPostBinding.inflate(inflater);

        // Get Spinner object
        Spinner spinner = this.binding.getRoot().findViewById(R.id.subjectSpinner);

        // Create an ArrayAdapter using the Subjects enum values
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, this.subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Sets spinner
        spinner.setAdapter(adapter);

        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        this.binding.postButton.setOnClickListener(v -> {
            // getting subject
            Spinner spinner = this.binding.getRoot().findViewById(R.id.subjectSpinner);
            String subject = spinner.getSelectedItem().toString();

            // Getting title
            Editable titleText = this.binding.titleText.getEditableText();
            String title = titleText.toString();

            // getting the text
            EditText text = this.binding.textInputLayout.getEditText();
            assert text != null;
            String postText = text.getText().toString();

            Post post = new Post(title, postText, subject);

            ForumPostFragment.this.listener.createPost(post);
        });

    }

    public void createSubjects() {
        subjects.add("GENERAL");
        subjects.add("DEECE");
        subjects.add("MISC");
    }
}
