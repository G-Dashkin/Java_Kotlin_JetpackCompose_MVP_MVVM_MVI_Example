package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.stores

import com.arkivanov.mvikotlin.core.store.Store
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.domain.models.Contact

interface ContactListStore: Store<ContactListStore.Intent, ContactListStore.State, ContactListStore.Label> {

    data class State(val contactList: List<Contact>)

    sealed interface Intent {
        data class SelectContact(val contact: Contact) : Intent
        object AddContact : Intent
    }

    sealed interface Label {
        data class EditContact(val contact: Contact) : Label
        object AddContact: Label
    }
}