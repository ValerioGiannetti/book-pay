package com.book.pay.app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.book.pay.app.R;
import com.book.pay.app.adapter.EsercenteAdapter;
import com.book.pay.app.model.Esercente;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<Esercente>lista;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        RecyclerView rvEsercente = (RecyclerView) root.findViewById(R.id.recycler_view);
        rvEsercente.setHasFixedSize(true);
        lista = Esercente.creaLista(1);

        EsercenteAdapter adapter = new EsercenteAdapter(getContext(),lista);
        rvEsercente.setAdapter(adapter);
        rvEsercente.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }
}
