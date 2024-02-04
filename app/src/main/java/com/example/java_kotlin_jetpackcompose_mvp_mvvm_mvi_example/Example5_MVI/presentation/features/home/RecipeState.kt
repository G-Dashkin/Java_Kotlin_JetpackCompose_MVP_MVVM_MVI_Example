package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.presentation.features.home

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.data.models.Meal

sealed class RecipeState {
    object Loading: RecipeState()
    data class Success(val recipes: List<Meal>): RecipeState()
    data class Error(val message: String): RecipeState()
}