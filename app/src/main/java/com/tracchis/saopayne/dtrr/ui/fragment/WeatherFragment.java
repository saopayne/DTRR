package com.tracchis.saopayne.dtrr.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tracchis.saopayne.dtrr.R;
import com.tracchis.saopayne.dtrr.data.adapter.WeatherListAdapter;
import com.tracchis.saopayne.dtrr.data.model.Weather;
import com.tracchis.saopayne.dtrr.data.remote.service.WeatherServiceImpl;
import com.tracchis.saopayne.dtrr.ui.activities.MainView;
import com.tracchis.saopayne.dtrr.ui.presenter.MainPresenterImpl;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment implements MainView, WeatherListAdapter.WeatherItemListener {

    private MainPresenterImpl mPresenter;

    private WeatherListAdapter mWeatherListAdapter;
    private SwipeRefreshLayout mSrl;

    View rootView;

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_weather, container, false);

        mPresenter = new MainPresenterImpl(this, new WeatherServiceImpl());

        initRecyclerView();
        initSwipeRefreshLayout();

        return rootView;
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        mPresenter.loadWeatherData();
//    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                mPresenter.loadWeatherData();
                break;
        }
        return true;
    }

    @Override
    public void showProgress() {
        if(!mSrl.isRefreshing()) {
            // make sure setRefreshing() is called after the layout done everything else
            mSrl.post(new Runnable() {
                @Override
                public void run() {
                    mSrl.setRefreshing(true);
                }
            });
        }
    }

    @Override
    public void hideProgress() {
        if(mSrl.isRefreshing()) {
            mSrl.setRefreshing(false);
        }
    }

    @Override
    public void showWeatherClickedMessage(Weather s) {
        Toast.makeText(this.getActivity(), String.format(getString(R.string.main_toast_weather_item_click), s.getCityName()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showWeathers(List<Weather> weathers) {
        mWeatherListAdapter.replaceData(weathers);
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this.getActivity(), R.string.main_error_connection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWeatherItemClick(Weather item) {
        mPresenter.clickWeatherItem(item);

    }

    private void initSwipeRefreshLayout() {

        mSrl = (SwipeRefreshLayout)rootView.findViewById(R.id.srl);
        mSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadWeatherData();
            }
        });

    }

    private void initRecyclerView() {
        mWeatherListAdapter = new WeatherListAdapter(this.getActivity(), this);

        RecyclerView rvWeatherList = (RecyclerView)rootView.findViewById(R.id.rv_main);
        rvWeatherList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvWeatherList.setAdapter(mWeatherListAdapter);
    }


}
