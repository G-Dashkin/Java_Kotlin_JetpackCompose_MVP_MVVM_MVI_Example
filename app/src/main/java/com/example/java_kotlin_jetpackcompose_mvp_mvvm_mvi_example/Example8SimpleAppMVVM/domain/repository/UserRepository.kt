package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleAppMVVM.domain.repository

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleAppMVVM.domain.model.SaveUserNameParam
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleAppMVVM.domain.model.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName

}