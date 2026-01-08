package com.example.pt6_mariopique;



public class Liga {
    private String name;
    private String liga;
    private String image;

    public Liga(String nom, String liga, String image) {
         this.name = name;
         this.liga = liga;
         this.image = image;

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getLiga() {

        return liga;

    }
    public void setLiga(String liga) {this.liga = liga;}

    public String getImage() {
        return image;
    }
    public void setImage(String image) {this.image = image;}
}
