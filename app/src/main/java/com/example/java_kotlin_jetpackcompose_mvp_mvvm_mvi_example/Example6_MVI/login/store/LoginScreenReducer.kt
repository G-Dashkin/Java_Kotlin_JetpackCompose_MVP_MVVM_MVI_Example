package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.login.store

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.store.Reducer

class LoginScreenReducer : Reducer<LoginScreenState, LoginScreenAction> {

    override fun reducer(currentState: LoginScreenState, action: LoginScreenAction): LoginScreenState {
        return when (action) {
            is LoginScreenAction.LoginUser -> {
                currentState.copy(userName = action.userName, password = action.password)
            }
        }
    }
}