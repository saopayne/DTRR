package com.tracchis.saopayne.dtrr.data.remote.service;

import android.os.AsyncTask;

import com.tracchis.saopayne.dtrr.data.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saopayne on 12/18/16.
 */
public class WeatherServiceImpl implements WeatherApi {

    protected final static String API_URL = "http://api.openweathermap.org/data/2.5/group?id=4362438,4369964,4373104,4373349,4385018,4394870,4397340,4428495,4270356,4303012,4326868,4350288,4354163,4360201,4262045,5134453,4140963,4148757,4151824,4160023,4167694,4177679,4184845,4259418,4259671,1880252,5128581,524901,703448,2643743,1642911&units=metric&APPID=81d9dfb9ffd6803adafaa96c52231d75";

    @Override
    public void getAllWeathers(WeatherServiceCallback callback) {
        new LoadWeatherAsyncTask(callback).execute();
    }

    protected class LoadWeatherAsyncTask extends AsyncTask<Void, Void, List<Weather>> {

        private final WeatherServiceCallback mCallback;

        public LoadWeatherAsyncTask(WeatherServiceCallback callback) {
            mCallback = callback;
        }

        @Override
        protected List<Weather> doInBackground(Void... params) {
            try {
                URL url = new URL(API_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                StringBuilder content = new StringBuilder();

                String line;
                while ((line = in.readLine()) != null) {
                    content.append(line);
                }

                JSONArray list = new JSONObject(content.toString()).getJSONArray("list");

                List<Weather> weathers = new ArrayList<>();

                JSONObject object;

                for (int i = 0; i < list.length(); i++) {
                    object = list.getJSONObject(i);

                    float temp = BigDecimal.valueOf(object.getJSONObject("main").getDouble("temp")).floatValue();
                    float windSpeed = BigDecimal.valueOf(object.getJSONObject("wind").getDouble("speed")).floatValue();

                    weathers.add(new Weather(temp, windSpeed, object.getString("name"), object.getJSONArray("weather").getJSONObject(0).getString("description")));
                }

                return weathers;

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Weather> weathers) {

            if (weathers != null) {
                mCallback.onSuccess(weathers);
            } else {
                mCallback.onFailure();
            }
        }
    }
}
