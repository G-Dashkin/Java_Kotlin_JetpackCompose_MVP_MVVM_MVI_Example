package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.core.componentScope
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.domain.models.Contact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.stores.EditContactStore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DefaultEditContactComponent(
    componentContext: ComponentContext,
    private val contact: Contact,
    private val onContactSave: () -> Unit
): EditContactComponent, ComponentContext by componentContext {

    private lateinit var store: EditContactStore

//    private val repository = RepositoryImpl
//    private val editContactUseCase = EditContactUseCase(repository)

    init {
        componentScope().launch{
            store.labels.collect{
                when(it) {
                    EditContactStore.Label.ContactSaved -> {
                        onContactSave()
                    }
                }
            }
        }
//        stateKeeper.register(KEY){
//            model.value
//        }
    }

//    private val _model = MutableStateFlow(
//        stateKeeper.consume(KEY) ?: EditContactComponent.Model(userName = contact.username, phone = contact.phone)
//    )
//    override val model: StateFlow<EditContactComponent.Model>
//        get() = _model.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<EditContactStore.State>
        get() = store.stateFlow

    override fun onUserNameChange(userName: String) {
        store.accept(EditContactStore.Intent.ChangeUsername(userName))
//        _model.value = model.value.copy(userName = userName)
    }

    override fun onPhoneChange(phone: String) {
        store.accept(EditContactStore.Intent.ChangePhone(phone))
//        _model.value = model.value.copy(phone = phone)
    }

    override fun onSaveContactClicked() {
        store.accept(EditContactStore.Intent.SaveContact)
//        val userName = model.value.userName
//        val phone = model.value.phone
//        editContactUseCase(
//            contact.copy(
//                username = userName,
//                phone = phone
//            )
//        )
//        onContactSave()
    }

//    companion object {
//        private const val KEY = "DefaultEditContactComponent"
//    }
}