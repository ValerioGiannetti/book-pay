package com.book.pay.app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.book.pay.app.MainActivity;
import com.book.pay.app.R;
import com.book.pay.app.adapter.EsercenteAdapter;
import com.book.pay.app.fragment.NavigationDrawerFragment;
import com.book.pay.app.model.Esercente;
import com.book.pay.app.util.Coordinate;
import com.book.pay.app.util.LocationUtil;

import java.util.Collections;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Esercente> lista;
    private ProgressBar progressBar;

    private static final String PREFS_ = "PREFS_";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocationAsynTask locationAsynTask = new LocationAsynTask();
        LocationUtil locationUtil = new LocationUtil(this);
        locationAsynTask.execute(locationUtil);

    }

    private class LocationAsynTask extends AsyncTask<LocationUtil,Integer, Coordinate> {

        private Integer count = 0;
        @Override
        protected Coordinate doInBackground(LocationUtil... locationUtils) {
            Coordinate coordinate = new Coordinate();
            while(coordinate.getLatitudine() == null){

                locationUtils[0].getLocationTask(coordinate);
                if(coordinate.getLatitudine() != null && coordinate.getLongitudine() != null){
                    return coordinate;
                }else{
                    count++;
                    publishProgress(count);
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

            //SharedPreferences preferences = getSharedPreferences(PREFS_, MODE_PRIVATE);

            setContentView(R.layout.activity_main);

            RecyclerView rvEsercente = (RecyclerView) findViewById(R.id.recycler_view);
            rvEsercente.setHasFixedSize(true);
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
