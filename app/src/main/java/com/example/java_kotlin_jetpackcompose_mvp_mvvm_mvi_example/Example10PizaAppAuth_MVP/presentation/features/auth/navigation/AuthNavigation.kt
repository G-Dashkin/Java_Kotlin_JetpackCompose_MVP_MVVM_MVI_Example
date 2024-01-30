package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.navigation.PizzaAppNavDestination
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.register.RegisterScreen
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.login.LoginScreen
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.login.LoginViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.register.RegisterViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.reset_password.ResetPasswordScreen
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.reset_password.ResetPasswordViewModel

const val AUTH_GRAPH = "authentication"

fun NavHostController.navigateToResetPassword() {
    navigate(ResetPasswordDestination.route)
}

fun NavHostController.navigateToSignUp() {
    navigate(RegisterDestination.route)
}

fun NavHostController.navigateToLogin() {
    navigate(LoginDestination.route)
}

fun NavGraphBuilder.authentication(
    onLoginClicked: () -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToResetPassword: () -> Unit,
    onNavigateToSignUp: () -> Unit
){
    navigation(startDestination = LoginDestination.route, route = AUTH_GRAPH){

        composable(route = LoginDestination.route) {

            val loginViewModel: LoginViewModel = viewModel()
            val loginUiState by loginViewModel.loginUiState.collectAsStateWithLifecycle()
            LoginScreen(
                loginUiState = loginUiState,
                loginViewModel = loginViewModel,
                onLoginClicked = onLoginClicked,
                onNavigateToSignUp = onNavigateToSignUp,
                onNavigateToResetPassword = onNavigateToResetPassword
            )
        }
        composable(route = RegisterDestination.route) {

            val signUpViewModel: RegisterViewModel = viewModel()
            val signUpUiState by signUpViewModel.signUpUiState.collectAsStateWithLifecycle()
            RegisterScreen(
                registerUiState = signUpUiState,
                registerViewModel = signUpViewModel,
                onNavigateToLogin = onNavigateToLogin
            )
        }
        composable(route = ResetPasswordDestination.route) {

            val resetPasswordViewModel: ResetPasswordViewModel = viewModel()
            val resetPasswordUiState by resetPasswordViewModel.resetPasswordUiState.collectAsStateWithLifecycle()
            ResetPasswordScreen(
                resetPasswordUiState = resetPasswordUiState,
                resetPasswordViewModel = resetPasswordViewModel,
                onNavigateToLogin = onNavigateToLogin
            )
        }

    }
}

private object LoginDestination: PizzaAppNavDestination {
    override val route = "login"
}

private object RegisterDestination: PizzaAppNavDestination {
    override val route = "register"
}

private object ResetPasswordDestination: PizzaAppNavDestination {
    override val route = "reset_password"
}