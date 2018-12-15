package com.assesment.topan.anews.api;

import com.assesment.topan.anews.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory
                    (GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
