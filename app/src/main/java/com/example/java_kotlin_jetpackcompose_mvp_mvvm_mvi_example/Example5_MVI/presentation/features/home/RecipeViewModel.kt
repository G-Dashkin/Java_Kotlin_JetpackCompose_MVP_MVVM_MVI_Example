package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.presentation.features.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.data.api.MealApiClient
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    private val _state = mutableStateOf<RecipeState>(RecipeState.Loading)
    val state: State<RecipeState> = _state

    fun processIntent(intent: RecipeViewIntent) {
        when(intent) {
            is RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
            is RecipeViewIntent.SearchRecipes -> searchRecipe(intent.query)
        }
    }

    private fun loadRandomRecipe() {
        viewModelScope.launch {
            _state.value = RecipeState.Loading

            try {
                _state.value = RecipeState.Success(
                    MealApiClient.getRandomRecipe()
                )
            } catch(e: Exception) {
                _state.value = RecipeState.Error("Error fetching recipe")
            }
        }
    }

    private fun searchRecipe(query: String) {
        viewModelScope.launch {
            _state.value = RecipeState.Loading
            try {
                _state.value = RecipeState.Success(
                    MealApiClient.getSearchedRecipe(query)
                )
            } catch (e: Exception) {
                _state.value = RecipeState.Error("Error fetching recipes")
            }
        }
    }

}