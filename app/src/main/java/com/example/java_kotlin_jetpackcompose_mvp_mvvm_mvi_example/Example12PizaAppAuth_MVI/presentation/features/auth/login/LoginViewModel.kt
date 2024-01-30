package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.login

import androidx.lifecycle.ViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.isValidEmail
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.isValidPassword
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//@Immutable
//data class LoginUiState(
//    val email: String,
//    val emailError: Boolean,
//    val password: String,
//    val passwordError: Boolean
//)

class LoginViewModel: ViewModel(), LoginContract {

    private val _uiState = MutableStateFlow(LoginContract.State.initial())
    private val _effect = MutableStateFlow<LoginContract.Effect?>(null)

    override val uiState: StateFlow<LoginContract.State> = _uiState.asStateFlow()
    override val effect: StateFlow<LoginContract.Effect?> = _effect.asStateFlow()

    override fun event(event: LoginContract.Event) {
        when(event) {
            is LoginContract.Event.EmailChangeEvent -> onEmailChange(event.email)
            is LoginContract.Event.PasswordChangeEvent -> onPasswordChange(event.password)
            LoginContract.Event.RegisterEvent -> onRegister()
            LoginContract.Event.ResetEvent -> onReset()
            LoginContract.Event.LoginEvent -> onSignIn()
        }
    }

    private fun onReset() {
        _effect.update {
            LoginContract.Effect.Reset
        }
    }

    private fun onRegister() {
        _effect.update {
            LoginContract.Effect.Register
        }
    }

    override fun consume() {
        _effect.update { null }
    }

    private fun onEmailChange(email: String) {
        _uiState.update {
            it.copy(
                login = email,
                loginError = email.isNotEmpty() && !email.isValidEmail()
            )
        }
    }

    private fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(
                password = password,
                passwordError = password.isNotEmpty() && !password.isValidPassword()
            )
        }
    }

    private fun onSignIn() {
        val email = uiState.value.login
        val password = uiState.value.password
        val emailValid = email.isNotEmpty() && email.isValidEmail()
        val passwordValid = password.isNotEmpty() && password.isValidPassword()
        if (emailValid && passwordValid) {
            _effect.update {
                LoginContract.Effect.Login
            }
        } else {
            _uiState.update {
                LoginContract.State.notAuthorized()
                it.copy(
                    loginError = email.isEmpty() || !email.isValidEmail(),
                    passwordError = password.isEmpty() || !password.isValidPassword()
                )
            }
        }
    }

//    private val _loginUiState = MutableStateFlow(
//        LoginUiState(
//            email = "",
//            emailError = false,
//            password = "",
//            passwordError = false
//        )
//    )
//
//    val loginUiState: StateFlow<LoginUiState> = _loginUiState
//
//    fun onEmailChange(email: String) {
//        _loginUiState.update { currentState ->
//            currentState.copy(
//                email = email,
//                emailError = email.isNotBlank()
//            )
//        }
//    }
//
//    fun onPasswordChange(password: String) {
//        _loginUiState.update { currentState ->
//            currentState.copy(
//                password = password,
//                passwordError = password.isNotBlank()
//            )
//        }
//    }
}