package com.tracchis.saopayne.dtrr.ui.presenter;



import com.tracchis.saopayne.dtrr.data.model.ResponsePOJO;
import com.tracchis.saopayne.dtrr.data.model.WeatherResponse;
import com.tracchis.saopayne.dtrr.data.remote.service.SOService;

import com.tracchis.saopayne.dtrr.ui.BasePresenter;
import com.tracchis.saopayne.dtrr.ui.activities.MainView;
import com.tracchis.saopayne.dtrr.util.EspressoIdlingResource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * The implementation of the main presenter interface
 */

public class MainPresenterImpl extends BasePresenter implements MainPresenter {

    private final MainView mView;
    private final SOService mWeatherApi;

    public MainPresenterImpl(MainView view, SOService weatherApi) {
        mView = view;
        mWeatherApi = weatherApi;
    }

    @Override
    public void loadWeatherData() {
        mView.showProgress();
        EspressoIdlingResource.increment();
        Call<ResponsePOJO> getWeatherData = mWeatherApi.getWeatherDetails();
        getWeatherData.enqueue(new Callback<ResponsePOJO>() {

            @Override
            public void onResponse(Response<ResponsePOJO> response) {
                EspressoIdlingResource.decrement();
                mView.hideProgress();
                if (response.body()!=null){
                    mView.showWeathers(response.body());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                EspressoIdlingResource.decrement();
                mView.showConnectionError();
                mView.hideProgress();
            }

        });
    }


    @Override
    public void clickWeatherItem(WeatherResponse item) {
        mView.showWeatherClickedMessage(item);
    }
}
