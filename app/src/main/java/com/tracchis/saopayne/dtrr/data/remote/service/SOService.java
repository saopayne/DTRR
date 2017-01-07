package com.tracchis.saopayne.dtrr.data.remote.service;

import com.tracchis.saopayne.dtrr.data.model.SOAnswersResponse;
import com.tracchis.saopayne.dtrr.data.model.WeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by saopayne on 12/19/16.
 */
public interface SOService {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers(@Query("tagged") String tags);

    @Headers("")
    @GET("")
    Call<List<WeatherResponse>> getListOfWeatherDetails();
}
