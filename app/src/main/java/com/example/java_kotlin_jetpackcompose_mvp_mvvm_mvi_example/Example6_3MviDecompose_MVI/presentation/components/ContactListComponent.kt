package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.components

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.domain.models.Contact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.stores.ContactListStore
import kotlinx.coroutines.flow.StateFlow

interface ContactListComponent {

//    val model: StateFlow<Model>
    val model: StateFlow<ContactListStore.State>

    fun onContactLicked(contact: Contact)

    fun onAddContactClicked()

//    data class Model(val contactList: List<Contact>)
}