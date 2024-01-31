package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.domain.usecases

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.domain.model.SaveUserNameParam
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }

}