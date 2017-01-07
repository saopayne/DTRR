package com.tracchis.saopayne.dtrr.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jubril on 1/4/17.
 */

public class Response {
    @SerializedName("cnt")
    @Expose
    private int cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<WeatherResponse> list = null;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public java.util.List<WeatherResponse> getList() {
        return list;
    }

    public void setList(java.util.List<WeatherResponse> list) {
        this.list = list;
    }
}
