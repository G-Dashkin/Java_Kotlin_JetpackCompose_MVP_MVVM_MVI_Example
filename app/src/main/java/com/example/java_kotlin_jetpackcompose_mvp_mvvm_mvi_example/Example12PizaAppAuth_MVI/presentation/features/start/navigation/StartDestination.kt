package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.start.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.start.StartedScreen
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.navigation.PizzaAppNavDestination

object StartDestination: PizzaAppNavDestination {
    override val route = "start"
}

interface StartNavigator{
    fun onNavigateAfterStarted()
}

fun NavGraphBuilder.start(externalNavigator: StartNavigator) {
    composable(route = "start") {
        StartedScreen(onStartClicked = externalNavigator::onNavigateAfterStarted)
    }
}