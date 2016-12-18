package com.tracchis.saopayne.dtrr.ui.presenter;


import com.tracchis.saopayne.dtrr.data.model.Weather;
import com.tracchis.saopayne.dtrr.data.model.service.WeatherApi;
import com.tracchis.saopayne.dtrr.data.model.service.WeatherServiceImpl;
import com.tracchis.saopayne.dtrr.ui.BasePresenter;
import com.tracchis.saopayne.dtrr.ui.activities.MainView;
import com.tracchis.saopayne.dtrr.ui.presenter.MainPresenter;
import com.tracchis.saopayne.dtrr.util.EspressoIdlingResource;

import java.util.List;



/**
 * The implementation of the main presenter interface
 */

public class MainPresenterImpl extends BasePresenter implements MainPresenter {

    private final MainView mView;
    private final WeatherServiceImpl mWeatherApi;

    public MainPresenterImpl(MainView view, WeatherServiceImpl weatherApi) {
        mView = view;
        mWeatherApi = weatherApi;
    }

    @Override
    public void loadWeatherData() {

        mView.showProgress();

        EspressoIdlingResource.increment();

        mWeatherApi.getAllWeathers(new WeatherApi.WeatherServiceCallback<List<Weather>>() {

            @Override
            public void onSuccess(List<Weather> weathers) {
                EspressoIdlingResource.decrement();
                mView.hideProgress();
                mView.showWeathers(weathers);
            }

            @Override
            public void onFailure() {
                EspressoIdlingResource.decrement();
                mView.showConnectionError();
                mView.hideProgress();
            }
        });
    }

    @Override
    public void clickWeatherItem(Weather item) {
        mView.showWeatherClickedMessage(item);
    }
}
