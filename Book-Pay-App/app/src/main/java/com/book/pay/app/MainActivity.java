package com.book.pay.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.book.pay.app.adapter.EsercenteAdapter;
import com.book.pay.app.fragment.NavigationDrawerFragment;
import com.book.pay.app.model.Esercente;
import com.book.pay.app.util.Coordinate;
import com.book.pay.app.util.LocationUtil;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Collections;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity  {

    private List<Esercente>lista;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocationAsynTask locationAsynTask = new LocationAsynTask();
        LocationUtil locationUtil = new LocationUtil(this);
        locationAsynTask.execute(locationUtil);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private class LocationAsynTask extends AsyncTask<LocationUtil,Integer, Coordinate> {

        private Integer count = 0;
        @Override
        protected Coordinate doInBackground(LocationUtil... locationUtils) {
            Coordinate coordinate = new Coordinate();
            while(coordinate.getLatitudine() == null){

                if(locationUtils[0].getLocationTask(coordinate)){
                    if(coordinate.getLatitudine() != null && coordinate.getLongitudine() != null){
                        return coordinate;
                    }else{
                        count++;
                        publishProgress(count);
                    }
                }


            }

            return coordinate;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar = new ProgressBar(getApplicationContext());

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Coordinate coordinate) {
            super.onPostExecute(coordinate);

            setContentView(R.layout.activity_main);

            RecyclerView rvEsercente = (RecyclerView) findViewById(R.id.recycler_view);
            rvEsercente.setHasFixedSize(true);
            if(coordinate != null){

                lista = Esercente.creaLista(20);



                EsercenteAdapter adapter = new EsercenteAdapter(getApplicationContext(),lista);
                rvEsercente.setAdapter(adapter);
                rvEsercente.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                LinearLayout layout = findViewById(R.id.bottom_app_bar_content_container);

                layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                        navigationDrawerFragment.show(getSupportFragmentManager(),"TAG");
                    }
                });

                Toast.makeText(getApplicationContext(),
                        "LATITUDE :" + coordinate.getLatitudine() + " LONGITUDE :" + coordinate.getLongitudine(),
                        Toast.LENGTH_LONG).show();

            }

        }
    }
}
