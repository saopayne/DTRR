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
    @GET("/data/2.5/group?id=4362438,4369964,4373104,4373349,4385018,4394870,4397340,4428495,4270356,4303012,4326868,4350288,4354163,4360201,4262045,5134453,4140963,4148757,4151824,4160023,4167694,4177679,4184845,4259418,4259671,1880252,5128581,524901,703448,2643743,1642911&units=metric&APPID=81d9dfb9ffd6803adafaa96c52231d75")
    Call<List<WeatherResponse>> getListOfWeatherDetails();
}
