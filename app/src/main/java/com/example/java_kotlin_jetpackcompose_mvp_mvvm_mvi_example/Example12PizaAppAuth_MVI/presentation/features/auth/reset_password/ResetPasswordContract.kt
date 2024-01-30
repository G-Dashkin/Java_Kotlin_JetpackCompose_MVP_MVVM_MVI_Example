package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.reset_password

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.base.UnidirectionalViewModel

interface ResetPasswordContract : UnidirectionalViewModel<ResetPasswordContract.Event, ResetPasswordContract.State, ResetPasswordContract.Effect?> {

    data class State(
        val email: String,
        val emailError: Boolean,
    ) {
        companion object {
            fun initial(): State = State(
                email = "",
                emailError = false,
            )
            fun notRegistered(): State = State(
                email = "",
                emailError = false,
//                firstNameError = firstName.isEmpty(),
//                emailError = email.isEmpty() || !email.isValidEmail(),
//                passwordError = password.isEmpty() || !password.isValidPassword()
            )
        }
    }



    sealed interface Event{
        data object ResetEvent: Event
        data object LoginEvent: Event
        data class EmailChangeEvent(val email: String): Event
    }

    sealed interface Effect {
        data object Login : Effect
    }
}