package com.tracchis.saopayne.dtrr.ui.presenter;



import com.tracchis.saopayne.dtrr.data.model.WeatherResponse;

public interface MainPresenter{
    void loadWeatherData();
    void clickWeatherItem(WeatherResponse item);
}
