package com.example.pt6_mariopique;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;



import android.view.View;

import android.widget.ImageView;
import android.widget.Toast;



import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import com.bumptech.glide.Glide; // per carregar imatges

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String baseUrl = "https://www.vidalibarraquer.net/android/sports/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView imgNba = findViewById(R.id.img_nba);
        ImageView imgNfl = findViewById(R.id.img_nfl);
        ImageView imgNhl = findViewById(R.id.img_nhl);
        ImageView imgMlb = findViewById(R.id.img_mlb);
        ImageView imgMls = findViewById(R.id.img_mls);

        // cargar imatges des de la URL i utilitzem Glide per carregar-les
        cargarImagen(baseUrl + "nba.png", imgNba);
        cargarImagen(baseUrl + "nfl.png", imgNfl);
        cargarImagen(baseUrl + "nhl.png", imgNhl);
        cargarImagen(baseUrl + "mlb.png", imgMlb);
        cargarImagen(baseUrl + "mls.png", imgMls);


        imgNba.setOnClickListener(v -> abrirLliga("nba"));
        imgNfl.setOnClickListener(v -> abrirLliga("nfl"));
        imgNhl.setOnClickListener(v -> abrirLliga("nhl"));
        imgMlb.setOnClickListener(v -> abrirLliga("mlb"));
        imgMls.setOnClickListener(v -> abrirLliga("mls"));




    }

    private void cargarImagen(String url, ImageView iv) {
        Glide.with(this).load(url).into(iv);
    }

    private void abrirLliga(String nombreLliga) {
        // Creamos el Intent para ir a la siguiente Activity
        Intent intent = new Intent(MainActivity.this, LligaActivity.class);


        intent.putExtra("LLIGA_SELECCIONADA", nombreLliga);


        startActivity(intent);
    }


}