package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components

import android.os.Parcelable
import kotlinx.coroutines.flow.StateFlow
import kotlinx.parcelize.Parcelize

interface EditContactComponent {

    val model: StateFlow<Model>

    fun onUserNameChange(userName: String)

    fun onPhoneChange(phone: String)

    fun onSaveContactClicked()

    @Parcelize
    data class Model(
        val userName: String,
        val phone: String
    ): Parcelable
}