package com.example.pt6_mariopique;

import com.google.gson.annotations.SerializedName;

public class EquipDetail {
    @SerializedName("team_name")
    private String nom;


    private String escut;

    @SerializedName("titles")
    private String titols;

    @SerializedName("team_stadium")
    private String estadi;

    public EquipDetail() {}

    public EquipDetail(String nom, String escut, String titols, String estadi) {
        this.nom = nom;
        this.escut = escut;
        this.titols = titols;
        this.estadi = estadi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEscut() {
        return escut;
    }

    public void setEscut(String escut) {
        this.escut = escut;
    }

    public int getTitols() {
        return getTitols();
    }

    public void setTitols(String titols) {
        this.titols = titols;
    }

    public String getEstadi() {
        return estadi;
    }

    public void setEstadi(String estadi) {
        this.estadi = estadi;
    }
}
