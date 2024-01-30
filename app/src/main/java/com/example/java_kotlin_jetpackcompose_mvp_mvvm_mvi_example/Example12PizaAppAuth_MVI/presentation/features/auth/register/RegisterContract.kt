package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.register

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.base.UnidirectionalViewModel

interface RegisterContract : UnidirectionalViewModel<RegisterContract.Event, RegisterContract.State, RegisterContract.Effect?> {

    data class State(
        val firstName: String,
        val firstNameError: Boolean,
        val email: String,
        val emailError: Boolean,
        val password: String,
        val passwordError: Boolean
    ) {
        companion object {
            fun initial(): State = State(
                firstName = "",
                firstNameError = false,
                email = "",
                emailError = false,
                password = "",
                passwordError = false
            )
            fun notRegistered(): State = State(
                firstName = "",
                firstNameError = false,
                email = "",
                emailError = false,
                password = "",
                passwordError = false
//                firstNameError = firstName.isEmpty(),
//                emailError = email.isEmpty() || !email.isValidEmail(),
//                passwordError = password.isEmpty() || !password.isValidPassword()
            )
        }
    }



    sealed interface Event{
        data object RegisterEvent: Event
        data object LoginEvent: Event
        data class FirstNameChangeEvent(val firstName: String): Event
        data class EmailChangeEvent(val email: String): Event
        data class PasswordChangeEvent(val password: String): Event
    }

    sealed interface Effect {
        data object Register : Effect
        data object Reset : Effect
        data object Login : Effect
    }
}