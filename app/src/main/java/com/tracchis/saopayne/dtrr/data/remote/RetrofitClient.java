package com.tracchis.saopayne.dtrr.data.remote;



import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


/**
 * Created by saopayne on 12/19/16.
 */
public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
