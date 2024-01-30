package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.start.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.navigation.PizzaAppNavDestination
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.start.StartedScreen

fun NavGraphBuilder.start(onStartNavigate:() -> Unit) {
    composable(route = "start") {
        StartedScreen(onStartClicked = onStartNavigate)
    }
}

object StartDestination: PizzaAppNavDestination {
    override val route = "start"
}