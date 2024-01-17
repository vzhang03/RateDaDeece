package com.example.ratedadeece.view.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratedadeece.R;
import com.example.ratedadeece.model.Dish;
import com.example.ratedadeece.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ForumViewHolder> {

    private List<Post> postList;

    public interface OnItemClickListener {
        void onPostInfoClick(Post p);
    }

    private ForumAdapter.OnItemClickListener listener;
    public ForumAdapter (HashMap<String, ArrayList<Post>> currentForum, ForumAdapter.OnItemClickListener listener){
        this.postList = new ArrayList<>();

        for (String key : currentForum.keySet()){
            ArrayList<Post> posts = currentForum.get(key);
            assert posts != null;
            this.postList.addAll(posts);
        }

        this.listener = listener;
    }

    @NonNull
    @Override
    public ForumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_view, parent, false);

        //setting padding
        view.setPadding(16, 10, 16, 10);
        // adjusting layout color
        view.setBackgroundColor(Color.parseColor("#E2CFEA"));

        // Create a GradientDrawable to apply rounded corners
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.parseColor("#E2CFEA"));
        gd.setCornerRadius(25);

        // Set the background drawable with rounded corners
        view.setBackground(gd);


        // setting margins between items
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 10); // left, top, right, bottom
        return new ForumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumViewHolder holder, int position) {
        Post post = this.postList.get(position);

        String postInfo = post.getTitle() + "\n@" + post.getSubject();

        // todo figure out text and how to get this to display right
        holder.nameView.setText(postInfo);
        holder.nameView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onPostInfoClick(post);
            }
        });
        holder.nameView.setBackgroundColor(Color.WHITE);
        holder.nameView.setPadding(5, 5, 5, 5);

        holder.stationView.setText(post.getPost());
        holder.stationView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onPostInfoClick(post);
            }
        });
        // todo figure out how to make this prettier
//        holder.stationView.setBackgroundColor(Color.WHITE);
        holder.stationView.setPadding(5, 5, 5, 5);

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return this.postList.size();
    }
    public static class ForumViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        TextView stationView;

        public ForumViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nameView = itemView.findViewById(R.id.menuItemViewName);
            this.stationView = itemView.findViewById(R.id.menuItemViewStation);
        }
    }
}
