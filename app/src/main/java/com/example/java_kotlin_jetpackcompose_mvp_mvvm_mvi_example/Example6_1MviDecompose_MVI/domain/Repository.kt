package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.domain

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.domain.models.Contact
import kotlinx.coroutines.flow.Flow

interface Repository {
    val contacts: Flow<List<Contact>>

    fun saveContact(contact: Contact)
}