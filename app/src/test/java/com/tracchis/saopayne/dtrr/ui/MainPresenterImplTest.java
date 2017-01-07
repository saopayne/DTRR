package com.tracchis.saopayne.dtrr.ui;

import com.tracchis.saopayne.dtrr.data.model.WeatherResponse;
import com.tracchis.saopayne.dtrr.data.remote.service.WeatherApi;

import com.tracchis.saopayne.dtrr.ui.activities.MainView;
import com.tracchis.saopayne.dtrr.ui.presenter.MainPresenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by saopayne on 12/18/16.
 */
public class MainPresenterImplTest {

    @Mock
    private MainView mMainView;


    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture callback from background task and then perform assertion
     */
    @Captor
    private ArgumentCaptor<WeatherApi.WeatherServiceCallback> mWeatherServiceCallback;

    private MainPresenterImpl mMainPresenter;

    @Before
    public void setupMainPresenter() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadWeatherData_andSucceed() throws Exception {
        mMainPresenter.loadWeatherData();
        verify(mMainView).showProgress();

    }

    @Test
    public void testLoadWeatherData_andFailed() throws Exception {
        mMainPresenter.loadWeatherData();
        verify(mMainView).showProgress();

        mWeatherServiceCallback.getValue().onFailure();

        verify(mMainView).hideProgress();
        verify(mMainView).showConnectionError();
    }


}
