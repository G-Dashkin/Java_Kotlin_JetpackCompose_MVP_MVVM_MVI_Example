package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.navigation.AuthNavigator
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.navigation.navigateToAuth
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.navigation.navigateToRegister
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.navigation.navigateToReset
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.start.navigation.StartNavigator

interface PizzaAppNavDestination {
    val route: String
}

fun NavHostController.startNavigator(): StartNavigator =
    object : StartNavigator {
        override fun onNavigateAfterStarted() {
            popBackStack()
            navigateToAuth()
        }
    }

fun NavHostController.authNavigator(): AuthNavigator = object : AuthNavigator {

    override fun onNavigateToRegister() {
        navigateToRegister()
    }

    override fun onNavigateToReset() {
        navigateToReset()
    }

    override fun onNavigateUp() {
        popBackStack()
    }
}

fun NavHostController.navigateSingleTopTo(route: String) {
    navigate(route) {
        popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}