package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.usecases

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.model.UserName
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.repository.UserRepository


class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}