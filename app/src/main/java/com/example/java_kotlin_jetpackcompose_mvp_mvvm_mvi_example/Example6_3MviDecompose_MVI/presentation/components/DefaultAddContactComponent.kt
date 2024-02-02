package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.core.componentScope
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.stores.AddContactStore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DefaultAddContactComponent(
    componentContext: ComponentContext,
    val onContactSaved: () -> Unit
): AddContactComponent, ComponentContext by componentContext {

//    private val repository = RepositoryImpl
//    private val addContactUseCase = AddContactUseCase(repository)

    private lateinit var store: AddContactStore

    init {
        componentScope().launch {
            store.labels.collect {
                when(it) {
                    AddContactStore.Label.ContactSaved -> {
                        onContactSaved()
                    }
                }
            }
        }
    }

//    init {
//        stateKeeper.register(KEY) {
//            model.value
//        }
//    }

//    private val _model = MutableStateFlow(
//        stateKeeper.consume(KEY) ?: AddContactComponent.Model(userName = "", phone = "")
//    )

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<AddContactComponent.Model>
        get() = store.stateFlow.map {
            AddContactComponent.Model(it.userName, it.phone)
        }.stateIn(
            scope = componentScope(),
            started = SharingStarted.Lazily,
            initialValue = AddContactComponent.Model("", "")
        )

    override fun onUserNameChange(userName: String) {
        store.accept(AddContactStore.Intent.ChangeUsername(userName))
//        _model.value = model.value.copy(userName = userName)
    }

    override fun onPhoneChange(phone: String) {
        store.accept(AddContactStore.Intent.ChangePhone(phone))
//        _model.value = model.value.copy(phone = phone)
    }

    override fun onSaveContactClicked() {
        store.accept(AddContactStore.Intent.SaveContact)
//        val username = model.value.userName
//        val phone = model.value.phone
//        addContactUseCase(username = username, phone = phone)
//        onContactSaved()
    }

//    companion object {
//        private const val KEY = "DefaultAddContactComponent"
//    }
}