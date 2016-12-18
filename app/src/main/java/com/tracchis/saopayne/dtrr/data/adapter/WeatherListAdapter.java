package com.tracchis.saopayne.dtrr.data.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tracchis.saopayne.dtrr.R;
import com.tracchis.saopayne.dtrr.data.model.Weather;
import com.tracchis.saopayne.dtrr.util.MathUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saopayne on 12/18/16.
 */
public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder> {

    private final Context mContext;
    private final WeatherItemListener mListener;

    private List<Weather> mList = new ArrayList<>();

    public WeatherListAdapter(Context context, WeatherItemListener listener) {
        mContext = context;

        mListener = listener;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        Weather weather = mList.get(position);

        // \u00B0 is degree symbol
        String temp = MathUtil.getNoDecimal(weather.getTemperature()) + "\u00B0";
        String windSpeed = "Wind "+ MathUtil.getNoDecimal(weather.getWindSpeed()) +" m/s";

        holder.mTvCity.setText(weather.getCityName());
        holder.mTvTemp.setText(temp);
        holder.mTvWindSpeed.setText(windSpeed);
        holder.mTvWeatherDesc.setText(weather.getWeatherDescription());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void replaceData(List<Weather> weathers) {
        mList = weathers;
        notifyDataSetChanged();
    }

    protected class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mTvTemp;
        private final TextView mTvCity;
        private final TextView mTvWeatherDesc;
        private final TextView mTvWindSpeed;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTvTemp = (TextView) itemView.findViewById(R.id.tv_temp);
            mTvCity = (TextView) itemView.findViewById(R.id.tv_city);
            mTvWeatherDesc = (TextView) itemView.findViewById(R.id.tv_weather_desc);
            mTvWindSpeed = (TextView) itemView.findViewById(R.id.tv_wind_speed);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Weather weather = mList.get(position);

            mListener.onWeatherItemClick(weather);
        }
    }

    public interface WeatherItemListener {
        void onWeatherItemClick(Weather item);
    }
}
