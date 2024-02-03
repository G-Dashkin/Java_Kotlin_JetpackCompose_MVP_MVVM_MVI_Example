package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.domain.models

data class PostState (
    val progressBar: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null
)