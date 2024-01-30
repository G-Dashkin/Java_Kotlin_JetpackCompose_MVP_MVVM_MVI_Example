package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.start.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.core.navigation.PizzaAppNavDestination
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.start.StartedScreen

fun NavGraphBuilder.start(onStartNavigate:() -> Unit) {
    composable(route = "start") {
        StartedScreen(onStartClicked = onStartNavigate)
    }
}

object StartDestination: PizzaAppNavDestination {
    override val route = "start"
}