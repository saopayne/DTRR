package com.tracchis.saopayne.dtrr.data.model;

/**
 * Created by saopayne on 12/18/16.
 */
public class Weather {

    private float temperature, windSpeed;
    private String  cityName, weatherDescription;

    public Weather(float temperature, float windSpeed, String cityName, String weatherDescription) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.cityName = cityName;
        this.weatherDescription = weatherDescription;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
