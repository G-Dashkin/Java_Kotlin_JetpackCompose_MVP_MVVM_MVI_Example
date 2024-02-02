package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5RecipeFinderApp_MVI.presentation.features.home

sealed class RecipeViewIntent {
    object LoadRandomRecipe : RecipeViewIntent()
    data class SearchRecipes(val query: String) : RecipeViewIntent()
}