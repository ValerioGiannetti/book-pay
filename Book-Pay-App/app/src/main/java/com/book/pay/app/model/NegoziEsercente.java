package com.book.pay.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NegoziEsercente implements Parcelable {

    @SerializedName("fkIdEsercente")
    private int fkIdEsercente;
    @SerializedName("idEsercenteNegozio")
    private String idEsercenteNegozio;
    @SerializedName("numeNegozio")
    private String numeNegozio;
    @SerializedName("email")
    private String email;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("indirizzo")
    private String indirizzo;
    @SerializedName("civico")
    private String civico;
    @SerializedName("cap")
    private String cap;
    @SerializedName("citta")
    private String citta;
    @SerializedName("latitudine")
    private String latitudine;
    @SerializedName("longitudine")
    private String longitudine;

    public NegoziEsercente(){}


    protected NegoziEsercente(Parcel in) {
        fkIdEsercente = in.readInt();
        idEsercenteNegozio = in.readString();
        numeNegozio = in.readString();
        email = in.readString();
        telefono = in.readString();
        indirizzo = in.readString();
        civico = in.readString();
        cap = in.readString();
        citta = in.readString();
        latitudine = in.readString();
        longitudine = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(fkIdEsercente);
        dest.writeString(idEsercenteNegozio);
        dest.writeString(numeNegozio);
        dest.writeString(email);
        dest.writeString(telefono);
        dest.writeString(indirizzo);
        dest.writeString(civico);
        dest.writeString(cap);
        dest.writeString(citta);
        dest.writeString(latitudine);
        dest.writeString(longitudine);
        dest.writeTypedList(listaStaff);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NegoziEsercente> CREATOR = new Creator<NegoziEsercente>() {
        @Override
        public NegoziEsercente createFromParcel(Parcel in) {
            return new NegoziEsercente(in);
        }

        @Override
        public NegoziEsercente[] newArray(int size) {
            return new NegoziEsercente[size];
        }
    };

    public List<EsercenteNegozioStaff> getListaStaff() {
        return listaStaff;
    }

    public void setListaStaff(List<EsercenteNegozioStaff> listaStaff) {
        this.listaStaff = listaStaff;
    }

    private List<EsercenteNegozioStaff> listaStaff;


    public int getFkIdEsercente() {
        return fkIdEsercente;
    }

    public void setFkIdEsercente(int fkIdEsercente) {
        this.fkIdEsercente = fkIdEsercente;
    }

    public String getIdEsercenteNegozio() {
        return idEsercenteNegozio;
    }

    public void setIdEsercenteNegozio(String idEsercenteNegozio) {
        this.idEsercenteNegozio = idEsercenteNegozio;
    }

    public String getNumeNegozio() {
        return numeNegozio;
    }

    public void setNumeNegozio(String numeNegozio) {
        this.numeNegozio = numeNegozio;
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

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }
}
