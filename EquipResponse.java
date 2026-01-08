package com.example.pt6_mariopique;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EquipResponse {

    @SerializedName("data")
    private List<EquipDetail> data;

    public List<EquipDetail> getData() {
        return data;
    }
}
