package com.example.pt6_mariopique;


import com.google.gson.annotations.SerializedName;

public class Equip {

    @SerializedName("team_name")
    private String nom;

    @SerializedName("team_id")
    private String codi;

    @SerializedName("team_abbreviation")
    private String escut;

    public Equip(){}

    public Equip(String nom, String codi, String escut) {
        this.nom = nom;
        this.codi = codi;
        this.escut = escut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getEscut() {
        return escut;
    }

    public void setEscut(String escut) {
        this.escut = escut;
    }
}
