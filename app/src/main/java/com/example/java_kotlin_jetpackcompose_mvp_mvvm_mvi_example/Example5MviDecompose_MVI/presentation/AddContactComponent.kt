package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5MviDecompose_MVI.presentation

import kotlinx.coroutines.flow.StateFlow

interface AddContactComponent {

    val model: StateFlow<Model>

    fun onUserNameChange(userName: String)

    fun onPhoneChange(phone: String)

    fun onSaveContactClicked()

    data class Model(
        val userName: String,
        val phone: String
    )
}