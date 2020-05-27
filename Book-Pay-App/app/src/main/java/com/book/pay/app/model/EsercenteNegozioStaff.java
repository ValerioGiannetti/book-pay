package com.book.pay.app.model;

import android.os.Parcel;
import android.os.Parcelable;

public class EsercenteNegozioStaff implements Parcelable {


    private int fkIdEsercente;
    private int fkIdEsercenteNegozio;
    private int idEsercenteNegozioStaff;
    private String nome;
    private String cognome;
    private String numeroAppuntamentiOra;

    protected EsercenteNegozioStaff(Parcel in) {
        fkIdEsercente = in.readInt();
        fkIdEsercenteNegozio = in.readInt();
        idEsercenteNegozioStaff = in.readInt();
        nome = in.readString();
        cognome = in.readString();
        numeroAppuntamentiOra = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(fkIdEsercente);
        dest.writeInt(fkIdEsercenteNegozio);
        dest.writeInt(idEsercenteNegozioStaff);
        dest.writeString(nome);
        dest.writeString(cognome);
        dest.writeString(numeroAppuntamentiOra);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EsercenteNegozioStaff> CREATOR = new Creator<EsercenteNegozioStaff>() {
        @Override
        public EsercenteNegozioStaff createFromParcel(Parcel in) {
            return new EsercenteNegozioStaff(in);
        }

        @Override
        public EsercenteNegozioStaff[] newArray(int size) {
            return new EsercenteNegozioStaff[size];
        }
    };

    public int getFkIdEsercente() {
        return fkIdEsercente;
    }

    public void setFkIdEsercente(int fkIdEsercente) {
        this.fkIdEsercente = fkIdEsercente;
    }

    public int getFkIdEsercenteNegozio() {
        return fkIdEsercenteNegozio;
    }

    public void setFkIdEsercenteNegozio(int fkIdEsercenteNegozio) {
        this.fkIdEsercenteNegozio = fkIdEsercenteNegozio;
    }

    public int getIdEsercenteNegozioStaff() {
        return idEsercenteNegozioStaff;
    }

    public void setIdEsercenteNegozioStaff(int idEsercenteNegozioStaff) {
        this.idEsercenteNegozioStaff = idEsercenteNegozioStaff;
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

    public String getNumeroAppuntamentiOra() {
        return numeroAppuntamentiOra;
    }

    public void setNumeroAppuntamentiOra(String numeroAppuntamentiOra) {
        this.numeroAppuntamentiOra = numeroAppuntamentiOra;
    }
}
