package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.login

import androidx.lifecycle.ViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.login.store.LoginScreenAction
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.login.store.LoginScreenReducer
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.login.store.LoginScreenState
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.store.Store
import kotlinx.coroutines.flow.StateFlow

class LoginScreenViewModel : ViewModel() {

    private val store = Store(
        initialState = LoginScreenState(), reducer = LoginScreenReducer()
    )

    val viewState: StateFlow<LoginScreenState> = store.state

    fun login(userName: String, password: String) {
        val action = LoginScreenAction.LoginUser(userName, password)
        store.dispatch(action)
    }

}