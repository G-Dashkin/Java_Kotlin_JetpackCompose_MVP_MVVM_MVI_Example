package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5RecipeFinderApp_MVI.presentation.features.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5RecipeFinderApp_MVI.presentation.components.ErrorComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5RecipeFinderApp_MVI.presentation.components.LoadingComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5RecipeFinderApp_MVI.presentation.components.SuccessComponent

@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel) {
    val state by recipeViewModel.state

    when(state) {
        is RecipeState.Loading -> LoadingComponent()
        is RecipeState.Success -> {
            val recipes = (state as RecipeState.Success).recipes
            SuccessComponent(recipes = recipes, onSearchClicked = {query ->
                recipeViewModel.processIntent(RecipeViewIntent.SearchRecipes(query))
            })
        }
        is RecipeState.Error -> {
            val message = (state as RecipeState.Error).message
            ErrorComponent(message = message, onRefreshClicked = {
                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            })
        }
    }

    LaunchedEffect(Unit) {
        recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }
}