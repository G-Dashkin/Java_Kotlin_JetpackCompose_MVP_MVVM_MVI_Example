package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.register

import androidx.lifecycle.ViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.isValidEmail
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.isValidPassword
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel: ViewModel(), RegisterContract {

    private val _uiState = MutableStateFlow(RegisterContract.State.initial())
    private val _effect = MutableStateFlow<RegisterContract.Effect?>(null)

    override val uiState: StateFlow<RegisterContract.State> = _uiState.asStateFlow()
    override val effect: StateFlow<RegisterContract.Effect?> = _effect.asStateFlow()


    override fun event(event: RegisterContract.Event) {
        when (event) {
            is RegisterContract.Event.FirstNameChangeEvent -> onFirstNameChange(event.firstName)
            is RegisterContract.Event.EmailChangeEvent -> onEmailChange(event.email)
            is RegisterContract.Event.PasswordChangeEvent -> onPasswordChange(event.password)
            RegisterContract.Event.LoginEvent -> onLogin()
            RegisterContract.Event.RegisterEvent -> onSignUp()
        }
    }

    private fun onLogin() {
        _effect.update {
            RegisterContract.Effect.Login
        }
    }

    override fun consume() {
        _effect.update { null }
    }

    fun onFirstNameChange(name: String) {
        _uiState.update {
            it.copy(
                firstName = name,
                firstNameError = name.isEmpty()
            )
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

    fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(
                password = password,
                passwordError = password.isNotEmpty() && !password.isValidPassword()
            )
        }
    }

    private fun onSignUp() {
        val firstName = uiState.value.firstName
        val email = uiState.value.email
        val password = uiState.value.password
        val firstNameValid = firstName.isNotEmpty()
        val emailValid = email.isNotEmpty() && email.isValidEmail()
        val passwordValid = password.isNotEmpty() && password.isValidPassword()

        if (emailValid && passwordValid && firstNameValid) {
            _effect.update {
                RegisterContract.Effect.Register
            }
        } else {
            _uiState.update {
                // нужно в notRegistered() что то исправить
                RegisterContract.State.notRegistered()
                // это в notRegistered() должно быть
//                it.copy(
//                    firstNameError = firstName.isEmpty(),
//                    emailError = email.isEmpty() || !email.isValidEmail(),
//                    passwordError = password.isEmpty() || !password.isValidPassword()
//                )
            }
        }
    }
//    }
//
////    private val _signUpUiState = MutableStateFlow(
////        RegisterUiState(
////            name = "",
////            nameError = false,
////            email = "",
////            emailError = false,
////            password = "",
////            passwordError = false
////        )
////    )
//
//    val signUpUiState: StateFlow<RegisterUiState> = _signUpUiState
//
//    fun onNameChange(value: String) {
//        _signUpUiState.update { currentState ->
//            currentState.copy(
//                name = value,
//                nameError = value.isBlank())
//        }
//    }
//
//    fun onEmailChange(email: String) {
//        _signUpUiState.update { currentState ->
//            currentState.copy(
//                email = email,
//                emailError = email.isNotBlank()
//            )
//        }
//    }
//
//    fun onPasswordChange(password: String) {
//        _signUpUiState.update { currentState ->
//            currentState.copy(
//                password = password,
//                passwordError = password.isNotBlank()
//            )
//        }
//    }
//
//    fun onRegisterSubmit() {
//        _signUpUiState.update { currentState ->
//            currentState.copy(
//                nameError = currentState.name.isBlank(),
//                emailError = currentState.email.isBlank(),
//                passwordError = currentState.name.isBlank(),
//            )
//        }
//    }


}