package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.statekeeper.consume
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.data.RepositoryImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.domain.usecases.AddContactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DefaultAddContactComponent(
    componentContext: ComponentContext,
    val onContactSaved: () -> Unit
): AddContactComponent, ComponentContext by componentContext {

    private val repository = RepositoryImpl
    private val addContactUseCase = AddContactUseCase(repository)

    init {
        stateKeeper.register(KEY) {
            model.value
        }
    }

    private val _model = MutableStateFlow(
        stateKeeper.consume(KEY) ?: AddContactComponent.Model(userName = "", phone = "")
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
        onContactSaved()
    }

    companion object {
        private const val KEY = "DefaultAddContactComponent"
    }
}