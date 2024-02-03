package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
