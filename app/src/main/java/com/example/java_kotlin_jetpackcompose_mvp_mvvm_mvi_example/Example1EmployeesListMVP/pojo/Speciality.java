package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesListMVP.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Speciality {

    @SerializedName("specialty_id")
    @Expose
    private int specialtyId;
    @SerializedName("name")
    @Expose
    private String name;

    public int getSpecialtyId() {
        return specialtyId;
    }
}
