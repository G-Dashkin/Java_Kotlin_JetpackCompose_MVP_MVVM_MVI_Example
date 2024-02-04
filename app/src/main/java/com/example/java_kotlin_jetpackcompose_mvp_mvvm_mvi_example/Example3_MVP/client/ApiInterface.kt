package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.client

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.Resp.LeagueResp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import java.util.concurrent.TimeUnit

interface ApiInterface {
    @GET("v1/json/1/all_leagues.php")
    fun leagueList(@Header("Accept") accept: String,
                   @Header("Content-Type") content: String): Call<LeagueResp>

    companion object {
        fun createAPI(): ApiInterface {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(StethoInterceptor())
                .connectTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }

    }
}