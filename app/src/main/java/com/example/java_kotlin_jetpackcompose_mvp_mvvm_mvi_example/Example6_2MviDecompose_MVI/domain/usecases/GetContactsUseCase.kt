package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.usecases

import kotlinx.coroutines.flow.Flow
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.Repository
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.models.Contact

class GetContactsUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<Contact>> = repository.contacts
}