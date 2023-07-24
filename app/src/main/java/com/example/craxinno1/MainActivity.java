package com.example.craxinno1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.craxinno1.adapter.RecyclerViewAdapter;
import com.example.craxinno1.model.AgendaItem;
import com.example.craxinno1.model.ApiResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView today, tommorow, afterTommorrow;
    private RecyclerView recyclerView;
    List<AgendaItem> agendaItems;
    private ImageView imageView;

    private static String EID = "1989";
    private static String PID = "117195";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        today = findViewById(R.id.date);
        tommorow = findViewById(R.id.date1);
        afterTommorrow = findViewById(R.id.date2);
        recyclerView = findViewById(R.id.recyclerView);
        imageView = findViewById(R.id.person_image);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String date = getDate(0);
        String date1 = getDate(1);
        String date2 = getDate(2);
        today.setText(date);
        tommorow.setText(date1);
        afterTommorrow.setText(date2);

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ApiResponse> call = apiService.getAgendas(EID, PID);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();
                    if (apiResponse != null && apiResponse.getReplyCode().equals("success")) {
                        agendaItems = apiResponse.getData();

                        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(agendaItems, MainActivity.this);
                        recyclerView.setAdapter(recyclerViewAdapter);
                        Log.d("LOGMOHIT", agendaItems.toString());

                        // Update your RecyclerView adapter with the retrieved data
                        // adapter.setItems(agendaItems);
                        // adapter.notifyDataSetChanged(); // Call this if needed
                    } else {
                        // Handle API error here
                        Log.d("LOGMOHIT", "agendaItems.toString()");

                    }
                } else {
                    Log.d("LOGMOHIT", "BIG ERROR:");

                    // Handle API error here
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Handle network or other errors here
                Log.d("LOGMOHIT", "dsgxhs");
            }
        });
        logAgendaModelList();

    }

    public String getDate(int days) {
        LocalDate currentDate = LocalDate.now().plusDays(days);
        String pattern = "E, MMM d";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.US);
        String formattedDate = currentDate.format(formatter);

        return formattedDate;
    }

    private void logAgendaModelList() {

        String url = "https://eventowl.net/app/webroot/uploads/user_pictures/1687261775_user_image_1.jpeg";
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(imageView.getContext())
                .load(url)
                .apply(requestOptions)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        imageView.setClipToOutline(true);
    }
}