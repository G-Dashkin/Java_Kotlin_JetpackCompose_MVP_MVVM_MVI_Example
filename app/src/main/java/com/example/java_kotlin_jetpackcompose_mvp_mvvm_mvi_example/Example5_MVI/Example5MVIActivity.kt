package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.presentation.features.home.HomeScreen
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.presentation.features.home.RecipeViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.ui.theme.RecipeFinderAppTheme

class Example5MVIActivity : ComponentActivity() {
    private val recipeViewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeFinderAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(recipeViewModel = recipeViewModel)
                }
            }
        }
    }
}