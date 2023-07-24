package com.example.craxinno1;

import com.example.craxinno1.model.ApiResponse;
import com.example.craxinno1.model.NewApiResponse;
import com.example.craxinno1.model.Register_link;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("demo_agneda_list")
    Call<ApiResponse> getAgendas(@Field("eid") String eventId, @Field("pid") String participantId);

    @GET("demo_agenda_detail")
    Call<NewApiResponse> getAgendaDetails(
            @Query("sid") String sid,
            @Query("eid") String eventId,
            @Query("pid") String participantId,
            @Query("aid") String aid
    );
}


