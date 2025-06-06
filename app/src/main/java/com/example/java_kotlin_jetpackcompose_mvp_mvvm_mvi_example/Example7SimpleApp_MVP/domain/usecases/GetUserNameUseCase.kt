package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleApp_MVP.domain.usecases

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleApp_MVP.domain.model.UserName
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleApp_MVP.domain.repository.UserRepository


class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}