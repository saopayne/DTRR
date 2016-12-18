package com.tracchis.saopayne.dtrr.data.model.service;

import com.tracchis.saopayne.dtrr.data.model.Weather;

import java.util.List;

/**
 * Created by saopayne on 12/18/16.
 */
public interface WeatherApi {

    interface WeatherServiceCallback<T>{
        void onSuccess(T weathers);
        void onFailure();
    }

    void getAllWeathers(WeatherServiceCallback<List<Weather>> callback);
}
