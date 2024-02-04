package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.pojo.api;


import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.pojo.EmployeeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("testTask.json")
    Observable<EmployeeResponse> getEmployees();
}
