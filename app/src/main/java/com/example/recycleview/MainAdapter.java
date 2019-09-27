package com.example.recycleview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private ArrayList<ContentItem> items;

    private ItemClickListener itemClickListener;

    public MainAdapter(ArrayList<ContentItem> items, ItemClickListener itemClickListener) {
        super();
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_row_person, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        holder.bind(items.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;
        private ImageView image;
        private ImageView profileImage;
        private ImageButton share;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.imageView);
            profileImage = itemView.findViewById(R.id.imageView2);
            share = itemView.findViewById(R.id.imageButton);
        }


        public void bind(final ContentItem contentItem, final ItemClickListener itemClickListener) {
            title.setText(contentItem.getTitle());
            description.setText(contentItem.getDescription());
            image.setImageResource(R.drawable.androidpic);
            profileImage.setImageResource(R.mipmap.ic_launcher_round);
            if(itemClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        itemClickListener.onItemClick(contentItem);
                    }
                });
            }

        }
    }

    public interface ItemClickListener {
        void onItemClick(ContentItem contentItem);
    }
}
