package com.example.craxinno1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.craxinno1.adapter.NewClassRecyclerAdapter;
import com.example.craxinno1.model.ApiResponse;
import com.example.craxinno1.model.FinalAgendaModel;
import com.example.craxinno1.model.NewApiResponse;
import com.example.craxinno1.model.Register_link;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    NewClassRecyclerAdapter newClassRecyclerAdapter;
    private static String EID = "1989";
    private ImageView header_image;
    private ImageView back_image;
    private static String PID = "117195";
    private static String SID = "1";
    NewApiResponse newApiResponse;


    FinalAgendaModel agendaModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
//
        header_image = findViewById(R.id.header_img);
        back_image = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();

        back_image.setOnClickListener(view -> {
            onBackPressed();
        });


        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ApiService apiService = retrofit.create(ApiService.class);
        if (intent != null) {
            String itemId = String.valueOf(intent.getIntExtra("ItemId", -1));

            Call<NewApiResponse> call = apiService.getAgendaDetails(SID, EID, PID, itemId);
            call.enqueue(new Callback<NewApiResponse>() {
                @Override
                public void onResponse(Call<NewApiResponse> call, Response<NewApiResponse> response) {
                    if (response.isSuccessful()) {
                        // Handle the successful response here
                        newApiResponse = response.body();
                        if (newApiResponse != null && newApiResponse.getReplyCode().equals("success")) {
//                            agendaModelList = new ArrayList<>();
                            agendaModelList = newApiResponse.getData();
                            logAgendaModelList();
                            logMessage();
                            newClassRecyclerAdapter = new NewClassRecyclerAdapter(agendaModelList, NewActivity.this);
                            recyclerView.setAdapter(newClassRecyclerAdapter);
                        } else {
                            Log.d("TAGMOH", "agendaModelList.toString()");
                        }
                        // Do something with the response data
                    } else {
                        Log.d("TAGMOHIT", "agendaModelList.toString()");
                        // Handle error response
                        // ...
                    }
                }

                @Override
                public void onFailure(@NonNull Call<NewApiResponse> call, Throwable t) {

                    Log.d("TAGMOHI", "complete error:");

                }


            });
        }

    }


    private void logAgendaModelList() {
        String url1 = agendaModelList.getHeaderImage();
        String url2 = newApiResponse.getImagePath();
        String url = url2 + url1;
        Log.d("TAG", url);
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(header_image.getContext())
                .load(url)
                .apply(requestOptions)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(header_image);
        header_image.setClipToOutline(true);
    }

    public void logMessage() {


        Log.d("TAG", agendaModelList.getAgenda_docs().toString());
    }

}