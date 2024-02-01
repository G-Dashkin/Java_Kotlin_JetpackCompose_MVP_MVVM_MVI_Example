package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components

import android.os.Parcelable
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.domain.models.Contact
import kotlinx.parcelize.Parcelize

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {

        class AddContact(val component: AddContactComponent) : Child

        class ContactList(val component: ContactListComponent) : Child

        class EditContact(val component: EditContactComponent) : Child
    }


}