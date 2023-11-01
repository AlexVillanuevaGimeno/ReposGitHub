package com.example.videomovies.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videomovies.R;

import java.util.List;

public class ActorslistAdapter extends RecyclerView.Adapter<ActorslistAdapter.ViewHolder> {
    List<String> images;
    Context context;

    public ActorslistAdapter(List<String> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ActorslistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_actors,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorslistAdapter.ViewHolder holder, int position) {
    Glide.with(context)
            .load(images.get(position))
            .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        pic=itemView.findViewById(R.id.itemImages);
        }
    }
}
