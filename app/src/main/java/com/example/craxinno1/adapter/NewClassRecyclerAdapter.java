package com.example.craxinno1.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.craxinno1.Docs_file;
import com.example.craxinno1.R;
import com.example.craxinno1.model.Agenda_doc;
import com.example.craxinno1.model.Agenda_speak;
import com.example.craxinno1.model.Attendee;
import com.example.craxinno1.model.FinalAgendaModel;
import com.example.craxinno1.model.Register_link;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NewClassRecyclerAdapter extends RecyclerView.Adapter<NewClassRecyclerAdapter.ViewHolder> {

    private FinalAgendaModel agendaModelList;
    private Context context;

    public NewClassRecyclerAdapter(FinalAgendaModel agendaModelList, Context context) {
        this.agendaModelList = agendaModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewClassRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_custom_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewClassRecyclerAdapter.ViewHolder holder, int position) {

        holder.title.setText(agendaModelList.getName());
        holder.location.setText(agendaModelList.getLocationName());
        holder.Address.setText(agendaModelList.getLocationName());

        List<Attendee> attendeeList = agendaModelList.getAttendees();

        if (attendeeList != null) {
            AttendeeAdapter attendeeAdapter = new AttendeeAdapter(attendeeList);
            holder.recyclerViewAttendee.setAdapter(attendeeAdapter);
        }

        List<Agenda_speak> agenda_speakList = agendaModelList.getAgenda_speaks();

        if (agenda_speakList != null) {
            speakerAdapter speakerAdapter = new speakerAdapter(agenda_speakList);
            holder.recyclerViewSpeaker.setAdapter(speakerAdapter);
        }

        String date = agendaModelList.getStartDate();
        Instant instant = Instant.parse(date);
        LocalDate localDate = instant.atZone(ZoneId.of("UTC")).toLocalDate();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String formattedDate = dtf.format(localDate);
        holder.startDate.setText(formattedDate);

        String time1 = agendaModelList.getStartDate();
        String time2 = agendaModelList.getEndDate();
        Instant instant1 = Instant.parse(time1);
        Instant instant2 = Instant.parse(time2);
        ZonedDateTime zonedDateTime1 = instant1.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime zonedDateTime2 = instant2.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("America/New_York"));
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm a");
        String formattedTime1 = dtf1.format(zonedDateTime1);
        String formattedTime2 = dtf1.format(zonedDateTime2);
        String time = formattedTime1 + "-" + formattedTime2 + " EST";
        holder.time.setText(time);

        List<Register_link> registerLinks = agendaModelList.getRegister_links();
        String link = registerLinks.get(position).getRegister_link();
        String link_text = registerLinks.get(position).getRegister_text();
        holder.name_of_company.setText(link_text);
        holder.name_of_company.setOnClickListener(view -> {
            openWebPage(link);
        });

        List<Agenda_doc> agenda_docs = agendaModelList.getAgenda_docs();
        String link1 = agenda_docs.get(position).getDoc_file();
        holder.document.setOnClickListener(view -> {
            Intent i = new Intent(context.getApplicationContext(), Docs_file.class);
            i.putExtra("image", link1);
            context.startActivity(i);
        });

        String htmlText = agendaModelList.getDescription();
        Spanned spannedText = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY);
        holder.description.setText(spannedText);

        if (agendaModelList.getSponserName().isEmpty()) {
            holder.company_text.setVisibility(View.GONE);
        } else {
            holder.company_text.setText(agendaModelList.getSponserName());
        }
        if (agendaModelList.getSponserImage().isEmpty()) {
            holder.comapany.setVisibility(View.GONE);
        } else {
            String url = agendaModelList.getSponserImage();

            RequestOptions requestOptions = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(holder.comapany.getContext())
                    .load(url)
                    .apply(requestOptions)
                    .into(holder.comapany);
            holder.comapany.setClipToOutline(true);
        }
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, startDate, time, location, Address, description, company_text;
        private Button name_of_company, document;

        private ImageView comapany;
        private RecyclerView recyclerViewAttendee, recyclerViewSpeaker;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            recyclerViewAttendee = itemView.findViewById(R.id.recyclerViewAttendee);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerViewAttendee.setLayoutManager(layoutManager);
            recyclerViewSpeaker = itemView.findViewById(R.id.recyclerViewSpeaker);
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerViewSpeaker.setLayoutManager(layoutManager1);
            description = itemView.findViewById(R.id.description);
            startDate = itemView.findViewById(R.id.Start_date);
            time = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.location);
            Address = itemView.findViewById(R.id.Address);
            name_of_company = itemView.findViewById(R.id.nameOfCompany);
            document = itemView.findViewById(R.id.documents);
            comapany = itemView.findViewById(R.id.CompanyImage);
            company_text = itemView.findViewById(R.id.company_text);
        }
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            // Handle the situation where there's no activity to handle the Intent.
        }
    }
}
