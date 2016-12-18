package com.tracchis.saopayne.dtrr.ui;

import com.tracchis.saopayne.dtrr.data.model.Weather;
import com.tracchis.saopayne.dtrr.data.model.service.WeatherApi;
import com.tracchis.saopayne.dtrr.data.model.service.WeatherServiceImpl;
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

    @Mock
    private WeatherServiceImpl mWeatherApi;

    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture callback from background task and then perform assertion
     */
    @Captor
    private ArgumentCaptor<WeatherApi.WeatherServiceCallback> mWeatherServiceCallback;

    private MainPresenterImpl mMainPresenter;

    @Before
    public void setupMainPresenter() {
        MockitoAnnotations.initMocks(this);

        mMainPresenter = new MainPresenterImpl(mMainView, mWeatherApi);
    }

    @Test
    public void testLoadWeatherData_andSucceed() throws Exception {

        List<Weather> sample = generateSampleWeatherList();

        mMainPresenter.loadWeatherData();
        verify(mMainView).showProgress();
        verify(mWeatherApi).getAllWeathers(mWeatherServiceCallback.capture());

        mWeatherServiceCallback.getValue().onSuccess(sample);

        verify(mMainView).hideProgress();
        verify(mMainView).showWeathers(sample);

    }

    @Test
    public void testLoadWeatherData_andFailed() throws Exception {
        mMainPresenter.loadWeatherData();
        verify(mMainView).showProgress();

        verify(mWeatherApi).getAllWeathers(mWeatherServiceCallback.capture());
        mWeatherServiceCallback.getValue().onFailure();

        verify(mMainView).hideProgress();
        verify(mMainView).showConnectionError();
    }

    @Test
    public void testClickWeatherItem_showsWeatherMessage() throws Exception {
        Weather item = new Weather(22.1f, 3, "Jakarta", "Sample Description");

        mMainPresenter.clickWeatherItem(item);
        verify(mMainView).showWeatherClickedMessage(item);
    }

    private List<Weather> generateSampleWeatherList() {
        Weather item1 = new Weather(22.4f, 3, "Jakarta", "Cloudy");
        Weather item2 = new Weather(30.4f, 3, "Singapore", "Raining");

        List<Weather> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);

        return list;
    }
}
