package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.repository

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.model.SaveUserNameParam
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.model.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName

}