package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.presentation.features.auth.reset_password

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@Immutable
data class ResetPasswordUiState(
    val email: String,
    val emailError: Boolean
)

class ResetPasswordViewModel: ViewModel() {

    private val _resetPasswordUiState = MutableStateFlow(
        ResetPasswordUiState(
            email = "",
            emailError = false
        )
    )

    val resetPasswordUiState: StateFlow<ResetPasswordUiState> = _resetPasswordUiState

    fun onEmailChange(email: String) {
        _resetPasswordUiState.update { currentState ->
            currentState.copy(
                email = email,
                emailError = email.isNotBlank()
            )
        }
    }

    fun onResetPasswordSubmit() {
        _resetPasswordUiState.update { currentState ->
            currentState.copy(
                emailError = currentState.email.isBlank()
            )
        }
    }
}