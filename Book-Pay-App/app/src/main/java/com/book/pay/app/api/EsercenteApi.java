package com.book.pay.app.api;

import com.book.pay.app.model.Esercente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface EsercenteApi {

    @GET("api/gestione-esercente/lista-esercenti")
    Call<List<Esercente>> esercenteAllList();

    Call<List<Esercente>> esercenteListFromLatAndLongi(String latitudine,String longitudine);

}
