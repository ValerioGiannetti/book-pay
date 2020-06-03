package com.book.pay.app.api;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public abstract class ApiClient {

    protected static Retrofit retrofit = null;
    protected static final String API_BASE_URL_ESERCENTE = "http://192.168.1.10:7050/";
    protected static final String API_BASE_URL_PRENOTAZIONE = "http://192.168.1.10:5050/";

    public abstract  Retrofit getClient();

    protected OkHttpClient getOkHttpClient() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(0,1, TimeUnit.NANOSECONDS))
                .build();
        return okHttpClient;
    }


}
