package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeResponse {

    @SerializedName("response")
    @Expose
    private List<Employee> response = null;

    public List<Employee> getResponse() {
        return response;
    }

    public void setResponse(List<Employee> response) {
        this.response = response;
    }

}
