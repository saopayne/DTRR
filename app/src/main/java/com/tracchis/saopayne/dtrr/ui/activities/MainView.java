package com.tracchis.saopayne.dtrr.ui.activities;


import com.tracchis.saopayne.dtrr.data.model.ResponsePOJO;
import com.tracchis.saopayne.dtrr.data.model.WeatherResponse;


public interface MainView {
    void showProgress();
    void hideProgress();
    void showWeatherClickedMessage(WeatherResponse s);
    void showWeathers(ResponsePOJO responsePOJO);
    void showConnectionError();
}
