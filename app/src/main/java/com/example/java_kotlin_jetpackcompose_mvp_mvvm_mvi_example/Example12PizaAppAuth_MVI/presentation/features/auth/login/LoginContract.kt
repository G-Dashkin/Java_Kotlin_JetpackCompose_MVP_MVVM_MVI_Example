package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.login

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.base.UnidirectionalViewModel

interface LoginContract : UnidirectionalViewModel<LoginContract.Event, LoginContract.State, LoginContract.Effect?> {

    data class State(
        val login: String,
        val loginError: Boolean,
        val password: String,
        val passwordError: Boolean
    ) {
        companion object {
            fun initial(): State = State(
                login = "",
                loginError = false,
                password = "",
                passwordError = false
            )
            fun notAuthorized(): State = State(
                login = "",
                loginError = false,
                password = "",
                passwordError = false
            )
        }
    }

    sealed interface Event{
        data object LoginEvent: Event
        data object RegisterEvent: Event
        data object ResetEvent: Event
        data class EmailChangeEvent(val email: String): Event
        data class PasswordChangeEvent(val password: String): Event

    }

    sealed interface Effect {

        data object Register : Effect
        data object Reset : Effect
        data object Login : Effect
    }

}