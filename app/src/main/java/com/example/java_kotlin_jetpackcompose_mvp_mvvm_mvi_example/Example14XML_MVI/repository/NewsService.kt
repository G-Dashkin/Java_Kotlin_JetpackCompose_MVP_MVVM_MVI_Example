package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.repository

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.NewsData
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.Constants
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {

    @GET("top-headlines?lang=en&token=${Constants.API_KEY}")
    suspend fun getTopHeadlines() : Response<NewsData>


}