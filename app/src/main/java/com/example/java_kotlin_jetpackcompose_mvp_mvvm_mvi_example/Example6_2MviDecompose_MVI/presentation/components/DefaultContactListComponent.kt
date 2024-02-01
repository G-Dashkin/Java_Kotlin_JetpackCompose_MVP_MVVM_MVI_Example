package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.presentation.components


import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.data.RepositoryImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.models.Contact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.usecases.GetContactsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DefaultContactListComponent(
    componentContext: ComponentContext,
    val onEditingContactRequested: (Contact) -> Unit,
    val onAddContactRequested: () -> Unit
): ContactListComponent, ComponentContext by componentContext {

    private val repository = RepositoryImpl
    private val getContactUseCase = GetContactsUseCase(repository)
    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    init {
        lifecycle.doOnDestroy {
            coroutineScope.cancel()
        }
    }

    override val model: StateFlow<ContactListComponent.Model> = getContactUseCase()
        .map { ContactListComponent.Model(it) }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = ContactListComponent.Model(listOf())
        )

    override fun onContactLicked(contact: Contact) {
        onEditingContactRequested(contact)
    }

    override fun onAddContactClicked() {
        onAddContactRequested()
    }
}