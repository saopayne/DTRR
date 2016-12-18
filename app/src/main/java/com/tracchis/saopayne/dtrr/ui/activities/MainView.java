package com.tracchis.saopayne.dtrr.ui.activities;

import com.tracchis.saopayne.dtrr.data.model.Weather;

import java.util.List;


public interface MainView {
    void showProgress();
    void hideProgress();
    void showWeatherClickedMessage(Weather s);
    void showWeathers(List<Weather> weathers);
    void showConnectionError();
}
