package com.book.pay.app.api;

import com.book.pay.app.model.Esercente;
import com.book.pay.app.util.Constanti;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface EsercenteApi {

    @GET(Constanti.URL_LISTA_ESERCENTI)
    Call<List<Esercente>> esercenteAllList();

    Call<List<Esercente>> esercenteListFromLatAndLongi(String latitudine,String longitudine);

}
