package com.book.pay.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.book.pay.app.R;
import com.book.pay.app.view.ViewPlace;
import com.google.android.libraries.places.api.model.PlaceLikelihood;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<ViewPlace>  {

    private List<PlaceLikelihood> listaPlace;
    private LayoutInflater inflater;

    public PlaceAdapter(Context context, List<PlaceLikelihood> listaPlace){
        this.listaPlace = listaPlace;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewPlace onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.esercente_item_layout, parent, false);
        ViewPlace viewPlace = new ViewPlace(view,listaPlace);

        return viewPlace;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPlace holder, int position) {

        PlaceLikelihood place = listaPlace.get(position);
        //holder.getAttesa_text_view().setText(contact.getTempoAttesa());


        holder.setCardId(position);
        holder.getEsercente_attivita().setText(place.getPlace().getName());
        holder.getEsercente_nome().setText(place.getPlace().getAddress());
        holder.getAttesa_text_view().setText(String.valueOf(place.getLikelihood()));
        //holder.getEsercente_nome().setText(contact.getNomeEsercente());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public int getItemCount() {
        return listaPlace.size();
    }
}
