package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.features

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components.AddContactComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components.ContactListComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components.DefaultRootComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components.EditContactComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components.RootComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.features.contact_detail.AddContact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.features.contact_detail.EditContact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.features.contact_list.Contacts

@Composable
fun RootContent (
    component: DefaultRootComponent
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Children(stack = component.stack) {
            when(val instance = it.instance) {
                is RootComponent.Config.AddContact -> {
                    AddContact(component = instance.component)
                }
                is RootComponent.Config.ContactList -> {
                    Contacts(component = instance.component)
                }
                is RootComponent.Config.EditContact -> {
                    EditContact(component = instance.component)
                }
            }
        }
    }
}