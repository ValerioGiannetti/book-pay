package com.book.pay.app;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.book.pay.app.adapter.EsercenteAdapter;
import com.book.pay.app.adapter.PlaceAdapter;
import com.book.pay.app.api.EsercenteApi;
import com.book.pay.app.api.EsercenteApiClient;
import com.book.pay.app.fragment.NavigationDrawerFragment;
import com.book.pay.app.model.Esercente;
import com.book.pay.app.ui.login.LoginActivity;
import com.book.pay.app.util.Coordinate;
import com.book.pay.app.util.LocationUtil;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import androidx.navigation.NavController;
//import androidx.navigation.NavDestination;

public class MainActivity extends AppCompatActivity {

    private List<Esercente> lista;
    private ProgressBar progressBar;
    private RecyclerView rvEsercente;
    private EsercenteApi api;
    private LocationUtil locationUtil;
    private Coordinate coordinateInstance;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private PlacesClient placesClient;

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Attiva Localizzazione")
                        .setMessage("Per poter utilizzare l'app bisogna attivare la localizzazione")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Places.initialize(getApplicationContext(), "AIzaSyCxGRr-AB1hgz5L9r2BHuaiNVJSVVDdQvU");

        this.placesClient = Places.createClient(this);



        /*SharedPreferences sp= this.getSharedPreferences("Login", MODE_PRIVATE);

        String token=sp.getString("token", null);
        if(token == null || token.equals("")){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }*/
        checkLocationPermission();

        LocationAsynTask locationAsynTask = new LocationAsynTask();
        locationUtil = new LocationUtil(this);
        locationAsynTask.execute(locationUtil);

    }

    @Override
    protected void onResume() {

        super.onResume();
        setContentView(R.layout.activity_main);

        if (locationUtil != null && locationUtil.getCoordinate() != null) {
            SharedPreferences preferences = this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);
            preferences.edit().putString("Latitudine", locationUtil.getCoordinate().getLatitudine());

            rvEsercente = (RecyclerView) findViewById(R.id.recycler_view);
            rvEsercente.setHasFixedSize(true);
        }

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        if ((this.lista == null || this.lista.isEmpty()) && this.locationUtil.lastLocation(coordinateInstance)) {

            EsercenteApiClient esercenteApiClient = new EsercenteApiClient();
            api = esercenteApiClient.getClient().create(EsercenteApi.class);
            api.esercenteAllList().enqueue(new Callback<List<Esercente>>() {
                @Override
                public void onResponse(Call<List<Esercente>> call, Response<List<Esercente>> response) {
                    lista = response.body();
                    EsercenteAdapter adapter = new EsercenteAdapter(getApplicationContext(), lista);
                    rvEsercente.setAdapter(adapter);
                    rvEsercente.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                    LinearLayout layout = findViewById(R.id.bottom_app_bar_content_container);

                    layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                            navigationDrawerFragment.show(getSupportFragmentManager(), "TAG");
                        }
                    });

                    //        Toast.makeText(getApplicationContext(),"RISULTATO:",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<List<Esercente>> call, Throwable t) {
                    Toast.makeText(getBaseContext(), "Return" + t.toString(), Toast.LENGTH_LONG).show();
                    Log.d("RITORNO", t.toString());

                }
            });
        }

    }

    private class LocationAsynTask extends AsyncTask<LocationUtil, Integer, Coordinate> {

        private Integer count = 0;

        @Override
        protected Coordinate doInBackground(final LocationUtil... locationUtils) {
            Coordinate coordinate = new Coordinate();

            /*while (coordinate.getLatitudine() == null) {

                if (locationUtils[0].getLocationTask(coordinate)) {
                    if (coordinate.getLatitudine() != null && coordinate.getLongitudine() != null) {
                        return coordinate;
                    } else {
                        count++;
                        publishProgress(count);
                    }
                }

            }*/
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
        protected void onPostExecute(final Coordinate coordinate) {
            super.onPostExecute(coordinate);

            setContentView(R.layout.activity_main);

            rvEsercente = findViewById(R.id.recycler_view);
            rvEsercente.setHasFixedSize(true);

            List<Place.Field> placeFields = Collections.singletonList(Place.Field.NAME);
            List<Place.Field> fields = Arrays.asList(Place.Field.NAME, Place.Field.ADDRESS);

            FindCurrentPlaceRequest request = FindCurrentPlaceRequest.builder(fields).build();

            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Task<FindCurrentPlaceResponse> placeResponse = placesClient.findCurrentPlace(request);

            placeResponse.addOnCompleteListener(new OnCompleteListener<FindCurrentPlaceResponse>() {
                @Override
                public void onComplete(@NonNull Task<FindCurrentPlaceResponse> task) {
                    if(task.isSuccessful()){
                        FindCurrentPlaceResponse response = task.getResult();

                        PlaceAdapter adapter = new PlaceAdapter(getApplicationContext(), response.getPlaceLikelihoods());
                        rvEsercente.setAdapter(adapter);
                        rvEsercente.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                        LinearLayout layout = findViewById(R.id.bottom_app_bar_content_container);
                        progressBar.setVisibility(View.GONE);
                        progressBar.invalidate();
                        layout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                                navigationDrawerFragment.show(getSupportFragmentManager(), "TAG");
                            }
                        });

                        //        Toast.makeText(getApplicationContext(),"RISULTATO:",Toast.LENGTH_LONG).show();


                        int position = 0;
                        for (PlaceLikelihood placeLikelihood : response.getPlaceLikelihoods()) {

                            Log.i("TAG", String.format("Place '%s' has likelihood: %f",
                                    placeLikelihood.getPlace().getName(),
                                    placeLikelihood.getLikelihood()));

                            Log.i("TAG",String.format("ADDRES '%s' PHONE '%s' RATING '%s'",
                                    placeLikelihood.getPlace().getAddress(),
                                    placeLikelihood.getPlace().getPhoneNumber(),
                                    placeLikelihood.getPlace().getRating()
                                    )
                            );
                        }

                    }else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            ApiException apiException = (ApiException) exception;
                            Log.e("TAG", "Place not found: " + apiException.getStatusCode());
                        }
                    }

                }
            });



       /*     if (lista == null || lista.isEmpty()) {
                EsercenteApiClient esercenteApiClient = new EsercenteApiClient();
                api = esercenteApiClient.getClient().create(EsercenteApi.class);
                api.esercenteAllList().enqueue(new Callback<List<Esercente>>() {
                    @Override
                    public void onResponse(Call<List<Esercente>> call, Response<List<Esercente>> response) {
                        lista = response.body();
                        EsercenteAdapter adapter = new EsercenteAdapter(getApplicationContext(), lista);
                        rvEsercente.setAdapter(adapter);
                        rvEsercente.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                        LinearLayout layout = findViewById(R.id.bottom_app_bar_content_container);
                        progressBar.setVisibility(View.GONE);
                        progressBar.invalidate();
                        layout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                                navigationDrawerFragment.show(getSupportFragmentManager(), "TAG");
                            }
                        });

                        //        Toast.makeText(getApplicationContext(),"RISULTATO:",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<List<Esercente>> call, Throwable t) {
                        Toast.makeText(getBaseContext(), "Return" + t.toString(), Toast.LENGTH_LONG).show();
                        Log.d("RITORNO", t.toString());

                    }
                });
            }*/


            //  setContentView(R.layout.activity_main);
            //  rvEsercente = (RecyclerView) findViewById(R.id.recycler_view);
            //  rvEsercente.setHasFixedSize(true);

            if (coordinate != null) {
                coordinateInstance = coordinate;
                //lista = Esercente.creaLista(20);

            }

        }
    }
}
