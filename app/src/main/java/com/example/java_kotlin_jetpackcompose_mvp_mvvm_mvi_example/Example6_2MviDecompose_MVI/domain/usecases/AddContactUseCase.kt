package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.usecases

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.Repository
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.models.Contact

class AddContactUseCase(
    private val repository: Repository
) {

    operator fun invoke(
        username: String,
        phone: String
    ) {
        val contact = Contact(
            username = username,
            phone = phone
        )
        repository.saveContact(contact)
    }
}