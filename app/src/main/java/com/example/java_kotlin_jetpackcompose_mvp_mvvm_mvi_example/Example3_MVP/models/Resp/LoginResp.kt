package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.Resp

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.obj.User

data class LoginResp (
    val status: String,
    val message: String,
    val user: User
)