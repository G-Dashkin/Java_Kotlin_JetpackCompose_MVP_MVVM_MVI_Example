package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.PizzaAppTheme
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.PizzaAppNavHost

class PizaAppAuthMVP_Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            PizzaAppTheme {
                PizzaAppNavHost()
            }
        }
    }
}

