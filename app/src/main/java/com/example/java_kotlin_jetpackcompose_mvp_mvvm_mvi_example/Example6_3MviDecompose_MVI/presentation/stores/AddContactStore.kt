package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.stores

import com.arkivanov.mvikotlin.core.store.Store

interface AddContactStore: Store<AddContactStore.Intent, AddContactStore.State, Nothing> {
    data class State(
        val userName: String,
        val phone: String
    )

    sealed interface Label {
        object ContactSaved: Label
    }

    sealed interface Intent {
        data class ChangeUsername(val userName: String): Intent
        data class ChangePhone(val phone: String): Intent
        object SaveContact : Intent
    }
}