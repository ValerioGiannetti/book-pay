package com.book.pay.app.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.pay.app.R;
import com.book.pay.app.activity.DetailActivity;
import com.book.pay.app.model.Esercente;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class ViewEsercente extends RecyclerView.ViewHolder implements View.OnClickListener {

    private MaterialTextView esercente_nome;
    private MaterialTextView esercente_attivita;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    private int cardId;
    public MaterialTextView getAttesa_text_view() {
        return attesa_text_view;
    }

    private MaterialTextView attesa_text_view;
    private MaterialCardView cardEsercenteView;

    private ImageView imageView;
    private int position;
    private Esercente model;
    private List<Esercente> lista;


    @SuppressLint("WrongViewCast")
    public ViewEsercente(@NonNull View itemView, List<Esercente>lista) {
        super(itemView);
        cardEsercenteView = (MaterialCardView) itemView.findViewById(R.id.card_view);

       // esercente_nome = (TextView) itemView.findViewById(R.id.nome_esercente);
        esercente_attivita =  itemView.findViewById(R.id.nome_attivita);
        this.attesa_text_view = itemView.findViewById(R.id.attesa_text_view);
        this.lista = lista;
        cardEsercenteView.setOnClickListener(this);

        // itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(v.getContext(), DetailActivity.class);
        Esercente esercente = this.lista.get(getAdapterPosition());
        intent.putExtra("esercente", (Parcelable) esercente);
        v.getContext().startActivity(intent);
        Toast.makeText(v.getContext(),"hai cliccato la card ESERCENTE CARD"+getAdapterPosition(),Toast.LENGTH_SHORT).show();
    }

    public void setData(Esercente current, int position) {
        this.model = current;
        this.position = position;
    }

    public TextView getEsercente_nome() {
        return esercente_nome;
    }

    public void setEsercente_nome(MaterialTextView esercente_nome) {
        this.esercente_nome = esercente_nome;
    }

    public TextView getEsercente_attivita() {
        return esercente_attivita;
    }

    public void setEsercente_attivita(MaterialTextView esercente_attivita) {
        this.esercente_attivita = esercente_attivita;
    }

}
