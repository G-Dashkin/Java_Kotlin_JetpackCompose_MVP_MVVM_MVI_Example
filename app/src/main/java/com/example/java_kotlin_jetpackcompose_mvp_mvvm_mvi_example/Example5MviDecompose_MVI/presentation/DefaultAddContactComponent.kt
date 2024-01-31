package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5MviDecompose_MVI.presentation

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5MviDecompose_MVI.data.RepositoryImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5MviDecompose_MVI.domain.usecases.AddContactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DefaultAddContactComponent: AddContactComponent {

    private val repository = RepositoryImpl
    private val addContactUseCase = AddContactUseCase(repository)

    private val _model = MutableStateFlow(
        AddContactComponent.Model(userName = "", phone = "")
    )

    override val model: StateFlow<AddContactComponent.Model>
        get() = _model.asStateFlow()

    override fun onUserNameChange(userName: String) {
        _model.value = model.value.copy(userName = userName)
    }

    override fun onPhoneChange(phone: String) {
        _model.value = model.value.copy(phone = phone)
    }

    override fun onSaveContactClicked() {
        val username = model.value.userName
        val phone = model.value.phone
        addContactUseCase(username = username, phone = phone)
    }
}