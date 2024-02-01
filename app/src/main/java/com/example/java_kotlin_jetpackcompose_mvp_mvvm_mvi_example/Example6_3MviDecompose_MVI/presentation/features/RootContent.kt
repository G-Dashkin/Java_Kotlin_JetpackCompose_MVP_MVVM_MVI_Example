package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.features

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.components.DefaultRootComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.components.RootComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.features.contact_detail.AddContact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.features.contact_detail.EditContact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.features.contact_list.Contacts

@Composable
fun RootContent (
    component: DefaultRootComponent
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Children(stack = component.stack) {
            when(val instance = it.instance) {
                is RootComponent.Child.AddContact -> {
                    AddContact(component = instance.component)
                }
                is RootComponent.Child.ContactList -> {
                    Contacts(component = instance.component)
                }
                is RootComponent.Child.EditContact -> {
                    EditContact(component = instance.component)
                }
            }
        }
    }
}