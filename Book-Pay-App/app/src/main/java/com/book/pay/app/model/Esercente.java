package com.book.pay.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Esercente implements Parcelable {

    private int idEsercente;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String email;
    private String telefono;
    private String indirizzo;
    private String civico;
    private String cap;
    private String citta;
    private List<NegoziEsercente>listaNegozi;

    public Esercente(){}


    protected Esercente(Parcel in) {
        idEsercente = in.readInt();
        nome = in.readString();
        cognome = in.readString();
        dataNascita = in.readString();
        email = in.readString();
        telefono = in.readString();
        indirizzo = in.readString();
        civico = in.readString();
        cap = in.readString();
        citta = in.readString();
        listaNegozi = in.createTypedArrayList(NegoziEsercente.CREATOR);
        tempoAttesa = in.readString();
        draw = in.createIntArray();
    }

    public static final Creator<Esercente> CREATOR = new Creator<Esercente>() {
        @Override
        public Esercente createFromParcel(Parcel in) {
            return new Esercente(in);
        }

        @Override
        public Esercente[] newArray(int size) {
            return new Esercente[size];
        }
    };

    public String getTempoAttesa() {
        return tempoAttesa;
    }

    public void setTempoAttesa(String tempoAttesa) {
        this.tempoAttesa = tempoAttesa;
    }

    private String tempoAttesa;
    public int getIdEsercente() {
        return idEsercente;
    }

    public void setIdEsercente(int idEsercente) {
        this.idEsercente = idEsercente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public List<NegoziEsercente> getListaNegozi() {
        return listaNegozi;
    }

    public void setListaNegozi(List<NegoziEsercente> listaNegozi) {
        this.listaNegozi = listaNegozi;
    }








    private int[] draw;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idEsercente);
        dest.writeString(nome);
        dest.writeString(cognome);
        dest.writeString(dataNascita);
        dest.writeString(email);
        dest.writeString(telefono);
        dest.writeString(indirizzo);
        dest.writeString(civico);
        dest.writeString(cap);
        dest.writeString(citta);
        dest.writeTypedList(listaNegozi);
        dest.writeString(tempoAttesa);
        dest.writeIntArray(draw);
    }

    public static List<Esercente>creaLista(int nume){


        String[] nome = {"Osvaldo","Emanuel","Federica Quaranta","Gabriele","Armando","Gab","Rico","Peppe",
                        "Ciccio","Franco","Osvaldo","Emanuel","Federica Quaranta","Gabriele"
                        ,"Armando","Gab","Rico","Peppe","Ciccio","Franco"};

        if(nume > nome.length){
            nume = nome.length;
        }
        List<Esercente>lista = new ArrayList<>();

        for (int i =0; i<nume ;i++){
            Esercente esercente = new Esercente();
            esercente.setNome(nome[i]);
            esercente.setCap("00013");
            esercente.setCivico("5");
            esercente.setEmail("prova@prova.it");
            esercente.setIndirizzo("Via Cuoco");
            esercente.setTempoAttesa("Tempo di attesa 15 min.");
            List<NegoziEsercente> listaNegozi = new ArrayList<>();
            NegoziEsercente negoziEsercente = new NegoziEsercente();
            negoziEsercente.setCap("00013");
            negoziEsercente.setNumeNegozio("Barber");
            listaNegozi.add(negoziEsercente);
            esercente.setListaNegozi(listaNegozi);

            lista.add(esercente);
        }

        return lista;
    }



}
