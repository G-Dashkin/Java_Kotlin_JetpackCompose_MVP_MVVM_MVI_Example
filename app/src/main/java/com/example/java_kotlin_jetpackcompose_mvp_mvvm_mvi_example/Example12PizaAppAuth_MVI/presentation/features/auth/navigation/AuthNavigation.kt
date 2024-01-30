package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.login.LoginScreen
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.base.useEffects
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.navigation.PizzaAppNavDestination
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.navigation.navigateSingleTopTo
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.login.LoginContract
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.login.LoginViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.register.RegisterScreen
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.register.RegisterViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.register.RegisterContract
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.reset_password.ResetPasswordContract
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.reset_password.ResetPasswordScreen
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.reset_password.ResetPasswordViewModel

const val AUTH_ROUTE = "authentication"

fun NavHostController.navigateToAuth() {
    navigateSingleTopTo(AUTH_ROUTE)
}

fun NavHostController.navigateToRegister() {
    navigate(RegisterDestination.route)
}

fun NavHostController.navigateToReset() {
    navigate(ResetPasswordDestination.route)
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

interface AuthNavigator {
    fun onNavigateToRegister()
    fun onNavigateToReset()
    fun onNavigateUp()
}

fun NavGraphBuilder.authentication(externalNavigator: AuthNavigator) {
    navigation(startDestination = LoginDestination.route, route = AUTH_ROUTE) {
        login(
            onLogin = {},
            onNavigateToRegister = externalNavigator::onNavigateToRegister,
            onNavigateToReset = externalNavigator::onNavigateToReset,
        )
        register(onNavigateToLogin = externalNavigator::onNavigateUp)
        resetPassword(onNavigateToLogin = externalNavigator::onNavigateUp)
    }
}

private fun NavGraphBuilder.login(
    onLogin: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onNavigateToReset: () -> Unit
) {
    composable(route = LoginDestination.route) {
        val viewModel: LoginViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val effects by viewModel.effect.collectAsStateWithLifecycle()

        viewModel.useEffects {
            when(effects) {
                LoginContract.Effect.Register -> onNavigateToRegister()
                LoginContract.Effect.Reset -> onNavigateToReset()
                LoginContract.Effect.Login -> onLogin()
                null -> Unit
            }
        }

        LoginScreen(
            loginUiState = uiState,
            onLoginClick = {viewModel.event(LoginContract.Event.LoginEvent)},
            onRegisterClick = {viewModel.event(LoginContract.Event.RegisterEvent)},
            onResetClick = {viewModel.event(LoginContract.Event.ResetEvent)},
            onEmailChange = {email -> viewModel.event(LoginContract.Event.EmailChangeEvent(email))},
            onPasswordChange = {password -> viewModel.event(LoginContract.Event.PasswordChangeEvent(password))}
        )
    }
}

private fun NavGraphBuilder.register(onNavigateToLogin:() -> Unit) {
    composable(route = RegisterDestination.route) {
        val viewModel: RegisterViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val effects by viewModel.effect.collectAsStateWithLifecycle()

        viewModel.useEffects {
            when(effects) {
                RegisterContract.Effect.Register -> {}
                RegisterContract.Effect.Login -> onNavigateToLogin()
                null -> Unit
                else -> {}
            }
        }

        RegisterScreen(
            registerUiState = uiState,
            onNameChange = { firstName -> viewModel.event(RegisterContract.Event.FirstNameChangeEvent(firstName)) },
            onEmailChange = { email -> viewModel.event(RegisterContract.Event.EmailChangeEvent(email)) },
            onPasswordChange = { password -> viewModel.event(RegisterContract.Event.PasswordChangeEvent(password)) },
            onRegisterClick = { viewModel.event(RegisterContract.Event.RegisterEvent) },
            onNavigateToLogin = { viewModel.event(RegisterContract.Event.LoginEvent) },
        )
    }
}

private fun NavGraphBuilder.resetPassword(onNavigateToLogin:() -> Unit) {
    composable(route = ResetPasswordDestination.route) {
        val viewModel: ResetPasswordViewModel = viewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val effects by viewModel.effect.collectAsStateWithLifecycle()

        viewModel.useEffects {
            when(effects) {
                ResetPasswordContract.Effect.Login -> onNavigateToLogin()
                null -> Unit
            }
        }

        ResetPasswordScreen(
            resetPasswordUiState = uiState,
            onEmailChange = { email -> viewModel.event(ResetPasswordContract.Event.EmailChangeEvent(email)) },
            onResetClick = { viewModel.event(ResetPasswordContract.Event.ResetEvent) },
            onLoginClick = { viewModel.event(ResetPasswordContract.Event.LoginEvent) }
        )
    }
}