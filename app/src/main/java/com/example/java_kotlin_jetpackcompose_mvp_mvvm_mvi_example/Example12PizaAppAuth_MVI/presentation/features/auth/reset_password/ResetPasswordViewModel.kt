package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.reset_password

import androidx.lifecycle.ViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.isValidEmail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ResetPasswordViewModel: ViewModel(), ResetPasswordContract {

    private val _uiState = MutableStateFlow(ResetPasswordContract.State.initial())
    private val _effect = MutableStateFlow<ResetPasswordContract.Effect?>(null)

    override val uiState: StateFlow<ResetPasswordContract.State> = _uiState.asStateFlow()
    override val effect: StateFlow<ResetPasswordContract.Effect?> = _effect.asStateFlow()

    override fun event(event: ResetPasswordContract.Event) {
        when (event) {
            is ResetPasswordContract.Event.EmailChangeEvent -> onEmailChange(event.email)
            ResetPasswordContract.Event.LoginEvent -> onLogin()
            ResetPasswordContract.Event.ResetEvent -> onResetPassword()
        }
    }

    fun onEmailChange(email: String) {
        _uiState.update {
            it.copy(
                email = email,
                emailError = email.isNotEmpty() && !email.isValidEmail()
            )
        }
    }

    private fun onLogin() {
        _effect.update {
            ResetPasswordContract.Effect.Login
        }
    }

    override fun consume() {
        _effect.update { null }
    }

    private fun onResetPassword() {
        // доработать
//        val firstName = uiState.value.firstName
//        val email = uiState.value.email
//        val password = uiState.value.password
//        val firstNameValid = firstName.isNotEmpty()
//        val emailValid = email.isNotEmpty() && email.isValidEmail()
//        val passwordValid = password.isNotEmpty() && password.isValidPassword()
//
//        if (emailValid && passwordValid && firstNameValid) {
//            _effect.update {
//                RegisterContract.Effect.Register
//            }
//        } else {
//            _uiState.update {
//                // нужно в notRegistered() что то исправить
//                RegisterContract.State.notRegistered()
//                // это в notRegistered() должно быть
////                it.copy(
////                    firstNameError = firstName.isEmpty(),
////                    emailError = email.isEmpty() || !email.isValidEmail(),
////                    passwordError = password.isEmpty() || !password.isValidPassword()
////                )
//            }
//        }
    }


}