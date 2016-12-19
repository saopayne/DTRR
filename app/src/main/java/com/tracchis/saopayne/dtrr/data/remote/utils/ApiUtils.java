package com.tracchis.saopayne.dtrr.data.remote.utils;

import com.tracchis.saopayne.dtrr.data.remote.RetrofitClient;
import com.tracchis.saopayne.dtrr.data.remote.service.SOService;

/**
 * Created by saopayne on 12/19/16.
 */
public class ApiUtils {

    public static final String BASE_URL = "https://api.stackexchange.com/2.2";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
