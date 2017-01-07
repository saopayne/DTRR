package com.tracchis.saopayne.dtrr.ui.activities;


import com.tracchis.saopayne.dtrr.data.model.WeatherResponse;

import java.util.List;


public interface MainView {
    void showProgress();
    void hideProgress();
    void showWeatherClickedMessage(WeatherResponse s);
    void showWeathers(List<WeatherResponse> weathers);
    void showConnectionError();
}
