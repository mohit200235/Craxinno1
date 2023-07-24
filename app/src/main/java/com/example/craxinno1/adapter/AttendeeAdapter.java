package com.example.craxinno1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.craxinno1.R;
import com.example.craxinno1.model.Attendee;

import java.util.List;

public class AttendeeAdapter extends RecyclerView.Adapter<AttendeeAdapter.ViewHolder> {

    private List<Attendee> attendeesList;

    public AttendeeAdapter(List<Attendee> attendeesList) {
        this.attendeesList = attendeesList;
    }

    @NonNull
    @Override
    public AttendeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multiple_attendee, parent, false);
        return new AttendeeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendeeAdapter.ViewHolder holder, int position) {
        Attendee attendee = attendeesList.get(position);
        String imageUrl = attendee.getImage();
        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);
        holder.imageView.setClipToOutline(true);

    }

    @Override
    public int getItemCount() {
        return attendeesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mainImage1);
        }
    }
}
