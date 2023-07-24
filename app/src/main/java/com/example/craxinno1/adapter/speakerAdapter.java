package com.example.craxinno1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.craxinno1.R;
import com.example.craxinno1.model.Agenda_speak;
import com.example.craxinno1.model.Attendee;

import java.util.List;

public class speakerAdapter extends RecyclerView.Adapter<speakerAdapter.ViewHolder> {

    private List<Agenda_speak> agenda_speakList1;

    public speakerAdapter(List<Agenda_speak> agenda_speakList1) {
        this.agenda_speakList1 = agenda_speakList1;
    }

    @NonNull
    @Override
    public speakerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.speaker_activity, parent, false);
        return new speakerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull speakerAdapter.ViewHolder holder, int position) {
        Agenda_speak agenda_speak = agenda_speakList1.get(position);
        String imageUrl = agenda_speak.getImage();
        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.profile_image);
        holder.profile_image.setClipToOutline(true);

        holder.name.setText(agenda_speak.getName());
        holder.title.setText(agenda_speak.getTitle());


    }

    @Override
    public int getItemCount() {
        return agenda_speakList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView profile_image;
        private TextView name, title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.proile_image);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.company_name);
        }
    }
}
