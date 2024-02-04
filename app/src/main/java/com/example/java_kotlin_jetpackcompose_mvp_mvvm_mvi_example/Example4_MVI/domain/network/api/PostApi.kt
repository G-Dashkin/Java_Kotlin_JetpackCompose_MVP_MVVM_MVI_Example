package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4_MVI.domain.network.api

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4_MVI.data.api.PostApiImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4_MVI.domain.models.Post
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


interface PostApi {
    suspend fun getPosts(): List<Post>

    companion object {
        private val httpClient = HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    Json {
                        this.ignoreUnknownKeys = true
                    }
                )
            }
        }
        fun providePostApi(): PostApi = PostApiImpl(httpClient)
    }
}