package com.example.pt6_mariopique;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface SportsAPI {

    @GET("{liga}.json")
    Call<RespuestaEquipos> getListaEquipos(@Path("liga") String liga);

    @GET("{liga}/{equipo}.json")
    Call<EquipResponse> getDetalleEquipo(@Path("liga") String liga, @Path("equipo") String equipo);
}
