package com.tracchis.saopayne.dtrr.data.remote.utils;

import com.google.gson.GsonBuilder;
import com.tracchis.saopayne.dtrr.data.remote.RetrofitClient;
import com.tracchis.saopayne.dtrr.data.remote.service.SOService;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by saopayne on 12/19/16.
 */
public class ApiUtils {

    public static final String BASE_URL = "https://api.stackexchange.com/2.2";
    public static final String WEATHER_BASE_URL = "http://api.openweathermap.org/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
    public static <T> T getRetrofitCreatedInstance(Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WEATHER_BASE_URL).
                addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
        return retrofit.create(service);
    }
}
