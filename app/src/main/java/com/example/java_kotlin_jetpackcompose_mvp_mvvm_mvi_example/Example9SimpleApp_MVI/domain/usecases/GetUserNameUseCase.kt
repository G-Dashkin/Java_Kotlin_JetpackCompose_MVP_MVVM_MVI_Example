package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.domain.usecases

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.domain.model.UserName
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.domain.repository.UserRepository


class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}