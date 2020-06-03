package com.book.pay.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.book.pay.app.R;
import com.book.pay.app.model.Esercente;
import com.book.pay.app.view.ViewEsercente;

import java.util.List;

public class EsercenteAdapter extends RecyclerView.Adapter<ViewEsercente> {

    private List<Esercente> lista;
    private LayoutInflater inflater;

    public EsercenteAdapter(Context context, List<Esercente>lista){
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewEsercente onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.esercente_item_layout, parent, false);
        ViewEsercente viewEsercente = new ViewEsercente(view,lista);

        return viewEsercente;
    }




    @Override
    public void onBindViewHolder(@NonNull ViewEsercente holder, int position) {

        Esercente contact = lista.get(position);
        holder.getAttesa_text_view().setText(contact.getTempoAttesa());
        if(!contact.getListaNegozi().isEmpty()){
            holder.getEsercente_attivita().setText(contact.getListaNegozi().get(0).getNumeNegozio());
        }

        holder.setCardId(position);
        holder.getEsercente_attivita().setText(contact.getNome());
        //holder.getEsercente_nome().setText(contact.getNomeEsercente());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {

        return lista.size();
    }
}
