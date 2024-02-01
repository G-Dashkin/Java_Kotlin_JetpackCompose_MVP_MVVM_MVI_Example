package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.domain.usecases

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.domain.Repository
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.domain.models.Contact

class EditContactUseCase(
    private val repository: Repository
) {

    operator fun invoke(
        contact: Contact
    ) {
        repository.saveContact(contact)
    }
}