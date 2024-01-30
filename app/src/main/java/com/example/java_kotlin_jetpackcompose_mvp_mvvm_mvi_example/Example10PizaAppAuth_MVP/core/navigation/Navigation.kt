package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

interface PizzaAppNavDestination {
    val route: String
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