package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.components


import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.core.componentScope
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.data.RepositoryImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.domain.models.Contact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.domain.usecases.GetContactsUseCase
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.stores.ContactListStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DefaultContactListComponent(
    componentContext: ComponentContext,
    val onEditingContactRequested: (Contact) -> Unit,
    val onAddContactRequested: () -> Unit
): ContactListComponent, ComponentContext by componentContext {

    private lateinit var store: ContactListStore

    init {
        componentScope().launch {
            store.labels.collect {
                when(it) {
                    ContactListStore.Label.AddContact -> {
                        onAddContactRequested
                    }
                    is ContactListStore.Label.EditContact -> {
                        onEditingContactRequested(it.contact)
                    }
                }
            }
        }
    }

//    private val repository = RepositoryImpl
//    private val getContactUseCase = GetContactsUseCase(repository)
//    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

//    init {
//        lifecycle.doOnDestroy {
//            coroutineScope.cancel()
//        }
//    }

//    override val model: StateFlow<ContactListComponent.Model> = getContactUseCase()
//        .map { ContactListComponent.Model(it) }
//        .stateIn(
//            scope = coroutineScope,
//            started = SharingStarted.Lazily,
//            initialValue = ContactListComponent.Model(listOf())
//        )

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<ContactListStore.State>
        get() = store.stateFlow

    override fun onContactLicked(contact: Contact) {
        store.accept(ContactListStore.Intent.SelectContact(contact))
//        onEditingContactRequested(contact)
    }

    override fun onAddContactClicked() {
        store.accept(ContactListStore.Intent.AddContact)
//        onAddContactRequested()
    }
}