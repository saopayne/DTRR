package com.tracchis.saopayne.dtrr.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jubril on 1/5/17.
 */

public class WeatherResponse {
    @SerializedName("coord")
    @Expose
    private CoordinatesPOJO coord;
    @SerializedName("sys")
    @Expose
    private SunDetailsPOJO sys;
    @SerializedName("weather")
    @Expose
    private java.util.List<Weather> weather = null;
    @SerializedName("main")
    @Expose
    private TemperaturePOJO main;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("weather")
    @Expose
    private List<WindPOJO> windPOJOList;
    @SerializedName("clouds")
    @Expose
    private CloudPOJO clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    public CoordinatesPOJO getCoord() {
        return coord;
    }

    public void setCoord(CoordinatesPOJO coord) {
        this.coord = coord;
    }

    public SunDetailsPOJO getSys() {
        return sys;
    }

    public void setSys(SunDetailsPOJO sys) {
        this.sys = sys;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public TemperaturePOJO getMain() {
        return main;
    }

    public void setMain(TemperaturePOJO main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public List<WindPOJO> getWindPOJOList() {
        return windPOJOList;
    }

    public void setWindPOJOList(List<WindPOJO> windPOJOList) {
        this.windPOJOList = windPOJOList;
    }

    public CloudPOJO getClouds() {
        return clouds;
    }

    public void setClouds(CloudPOJO clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
