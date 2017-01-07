package com.tracchis.saopayne.dtrr.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jubril on 1/4/17.
 */

public class WindPOJO {
    @SerializedName("speed")
    @Expose
    private Integer speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;
    @SerializedName("gust")
    @Expose
    private Double gust;
    @SerializedName("var_beg")
    @Expose
    private Integer varBeg;
    @SerializedName("var_end")
    @Expose
    private Integer varEnd;

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Double getGust() {
        return gust;
    }

    public void setGust(Double gust) {
        this.gust = gust;
    }

    public Integer getVarBeg() {
        return varBeg;
    }

    public void setVarBeg(Integer varBeg) {
        this.varBeg = varBeg;
    }

    public Integer getVarEnd() {
        return varEnd;
    }

    public void setVarEnd(Integer varEnd) {
        this.varEnd = varEnd;
    }
}
