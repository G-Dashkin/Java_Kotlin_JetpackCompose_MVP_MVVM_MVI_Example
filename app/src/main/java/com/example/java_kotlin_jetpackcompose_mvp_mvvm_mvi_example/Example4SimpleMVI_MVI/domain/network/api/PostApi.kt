package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.domain.network.api

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.data.api.PostApiImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.domain.models.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


interface PostApi {
    suspend fun getPosts(): List<Post>

    companion object {
        val httpClient = HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    Json {
                        this.ignoreUnknownKeys = true
                    }
                    // 17:50
                )
            }
        }
        fun providePostApi(): PostApi = PostApiImpl(httpClient)
    }
}