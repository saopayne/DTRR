package com.tracchis.saopayne.dtrr.ui.presenter;


import com.tracchis.saopayne.dtrr.data.model.Weather;

public interface MainPresenter{
    void loadWeatherData();
    void clickWeatherItem(Weather item);
}
