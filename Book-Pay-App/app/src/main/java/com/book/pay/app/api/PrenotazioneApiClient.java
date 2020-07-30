package com.book.pay.app.api;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrenotazioneApiClient extends ApiClient {



    @Override
    public Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS).addInterceptor(interceptor)
                .readTimeout(20, TimeUnit.SECONDS).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL_PRENOTAZIONE).client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();

        return retrofit;
    }
}
