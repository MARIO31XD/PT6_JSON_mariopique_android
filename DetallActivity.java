package com.example.pt6_mariopique;

import androidx.appcompat.app.AppCompatActivity;




import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.preference.PreferenceManager;
import com.bumptech.glide.Glide;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall);


        String liga = getIntent().getStringExtra("liga");
        String codi = getIntent().getStringExtra("codi");

        if (codi != null) {
            cargarDetalle(liga, codi.toLowerCase());
        }
    }

    private void cargarDetalle(String liga, String codi) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String baseUrl = prefs.getString("url_pref", "https://www.vidalibarraquer.net/android/sports/");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SportsAPI api = retrofit.create(SportsAPI.class);


        api.getDetalleEquipo(liga, codi).enqueue(new Callback<EquipResponse>() {
            @Override
            public void onResponse(Call<EquipResponse> call, Response<EquipResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    EquipDetail d = response.body().getData().get(0);


                    ((TextView) findViewById(R.id.txt_nom_detall)).setText(d.getNom());
                    ((TextView) findViewById(R.id.txt_estadi)).setText("Estadi: " + d.getEstadi());
                    ((TextView) findViewById(R.id.txt_titols)).setText("Títulos: " + d.getTitols());


                    Glide.with(DetallActivity.this)
                            .load(d.getEscut())
                            .placeholder(R.drawable.ic_launcher_background) // Imagen temporal mientras carga
                            .into((ImageView) findViewById(R.id.img_escut_detall));
                }
            }
            @Override
            public void onFailure (Call<EquipResponse> call, Throwable t) {
            }
        });

}
}
