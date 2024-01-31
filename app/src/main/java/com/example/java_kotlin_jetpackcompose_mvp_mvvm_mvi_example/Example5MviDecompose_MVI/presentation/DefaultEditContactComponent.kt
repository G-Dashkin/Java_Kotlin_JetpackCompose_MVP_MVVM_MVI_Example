package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5MviDecompose_MVI.presentation

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5MviDecompose_MVI.data.RepositoryImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5MviDecompose_MVI.domain.models.Contact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5MviDecompose_MVI.domain.usecases.EditContactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DefaultEditContactComponent(
    private val contact: Contact
): EditContactComponent {

    private val repository = RepositoryImpl
    private val editContactUseCase = EditContactUseCase(repository)

    private val _model = MutableStateFlow(
        EditContactComponent.Model(userName = contact.username, phone = contact.phone)
    )
    override val model: StateFlow<EditContactComponent.Model>
        get() = _model.asStateFlow()

    override fun onUserNameChange(userName: String) {
        _model.value = model.value.copy(userName = userName)
    }

    override fun onPhoneChange(phone: String) {
        _model.value = model.value.copy(phone = phone)
    }

    override fun onSaveContactClicked() {
        val userName = model.value.userName
        val phone = model.value.phone
        editContactUseCase(
            contact.copy(
                username = userName,
                phone = phone
            )
        )
    }

    // 12:46
}