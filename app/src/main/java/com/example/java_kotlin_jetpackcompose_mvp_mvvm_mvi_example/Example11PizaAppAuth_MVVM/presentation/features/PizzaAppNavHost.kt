package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.start.navigation.start
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.auth.navigation.AUTH_GRAPH
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.auth.navigation.authentication
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.auth.navigation.navigateToLogin
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.auth.navigation.navigateToResetPassword
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.auth.navigation.navigateToSignUp
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.start.navigation.StartDestination

@Composable
fun PizzaAppNavHost() {

    val navController: NavHostController = rememberNavController()
    val startDestination = AUTH_GRAPH

    NavHost(
        navController = navController,
        startDestination = StartDestination.route
    ) {
        start(
            onStartNavigate = {
                navController.popBackStack()
                navController.navigate(startDestination)
            }
        )
        authentication(
            onLoginClicked = {},
            onNavigateToLogin = navController::navigateToLogin,
            onNavigateToResetPassword = navController::navigateToResetPassword,
            onNavigateToSignUp = navController::navigateToSignUp
        )
    }
}