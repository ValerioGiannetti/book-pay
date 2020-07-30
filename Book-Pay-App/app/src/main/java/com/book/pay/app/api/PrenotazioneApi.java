package com.book.pay.app.api;

import com.book.pay.app.dto.DatiPrenotazioneDto;
import com.book.pay.app.model.Esercente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PrenotazioneApi {

    @POST("/api/gestione-prenotazione/prenotazione")
    Call<Boolean> inviaPrenotazione(@Body DatiPrenotazioneDto datiPrenotazioneDto);

}
