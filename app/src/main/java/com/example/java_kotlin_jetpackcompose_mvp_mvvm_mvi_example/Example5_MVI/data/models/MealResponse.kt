package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MealResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)