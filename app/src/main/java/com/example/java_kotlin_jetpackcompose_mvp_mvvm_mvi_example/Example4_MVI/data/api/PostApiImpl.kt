package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4_MVI.data.api

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4_MVI.domain.network.api.PostApi
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4_MVI.domain.models.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class PostApiImpl(
    private val httpClient: HttpClient
): PostApi {
    override suspend fun getPosts(): List<Post> {
        return httpClient.get {
            url("https://jsonplaceholder.typicode.com/posts")
        }.body()
    }
}