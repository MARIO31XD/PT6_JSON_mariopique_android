package com.example.pt6_mariopique;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.converter.gson:GsonConverterFactory;

public class LligaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lliga);


        String lligaRecibida = getIntent().getStringExtra("LLIGA_SELECCIONADA");
        if (lligaRecibida != null) {

            lligaRecibida = lligaRecibida.toLowerCase();
        }

        recyclerView = findViewById(R.id.recycler_equipos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (isNetworkAvailable()) {
            cargarJson(lligaRecibida);
        } else {
            Toast.makeText(this, "No hi ha internet", Toast.LENGTH_SHORT).show();
        }

    }

    private void cargarJson(String liga) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
       // String baseUrl = prefs.getString("url_pref", "https://www.vidalibarraquer.net/android/sports/");
        String baseUrl = "https://www.vidalibarraquer.net/android/sports/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SportsAPI api = retrofit.create(SportsAPI.class);

        api.getListaEquipos(liga).enqueue(new Callback<RespuestaEquipos>() {
            @Override
            public void onResponse(Call<RespuestaEquipos> call, Response<RespuestaEquipos> response) {
                if (response.isSuccessful() && response.body() != null) {

                    List<Equip> listaDeEquipos = response.body().getTeams();

                    if (listaDeEquipos != null) {

                        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(listaDeEquipos, liga);
                        recyclerView.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(LligaActivity.this, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show();
                }
                }


            @Override
            public void onFailure(Call<RespuestaEquipos> call, Throwable t) {
                Log.e("RETROFIT_ERROR", "Causa: " + t.getMessage());
                Toast.makeText(LligaActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }
}
