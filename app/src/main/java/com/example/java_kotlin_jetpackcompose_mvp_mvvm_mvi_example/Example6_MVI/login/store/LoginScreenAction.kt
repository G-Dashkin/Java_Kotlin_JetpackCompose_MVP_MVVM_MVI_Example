package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.login.store

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.store.Action


sealed class LoginScreenAction : Action {
    data class LoginUser(val userName: String, val password: String) : LoginScreenAction()
}