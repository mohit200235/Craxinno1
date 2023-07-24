package com.example.craxinno1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.craxinno1.NewActivity;
import com.example.craxinno1.R;
import com.example.craxinno1.model.AgendaItem;
import com.example.craxinno1.model.Agenda_speak;
import com.example.craxinno1.model.Attendee;

import java.text.SimpleDateFormat;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<AgendaItem> agendaList;
    private Context context;

    public RecyclerViewAdapter(List<AgendaItem> agendaList, Context context) {
        this.agendaList = agendaList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        AgendaItem agendaItem = (AgendaItem) agendaList.get(position);
        String name = agendaItem.getName();
        holder.title.setText(name);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        String formattedStartTime = sdf.format(agendaItem.getStartDate());
        String formattedEndTime = sdf.format(agendaItem.getEndDate());
        holder.date.setText(formattedStartTime + "-" + formattedEndTime);

        List<Attendee> attendeeList = agendaItem.getAttendees();

        if (attendeeList != null) {
            ImageAdapter imageAdapter = new ImageAdapter(attendeeList);
            holder.recyclerView.setAdapter(imageAdapter);
        }

    }


    @Override
    public int getItemCount() {
        return agendaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title, date;
        private ImageView imageView;

        private RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.Title);
            date = itemView.findViewById(R.id.date);
//            imageView = itemView.findViewById(R.id.person_image);
            recyclerView = itemView.findViewById(R.id.recyclerView1);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            title.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            AgendaItem agendaItemId = agendaList.get(position);

            Intent intent = new Intent(context, NewActivity.class);
            intent.putExtra("selectedItem", position);
            intent.putExtra("ItemId", agendaItemId.getId());

            context.startActivity(intent);
        }
    }
}
