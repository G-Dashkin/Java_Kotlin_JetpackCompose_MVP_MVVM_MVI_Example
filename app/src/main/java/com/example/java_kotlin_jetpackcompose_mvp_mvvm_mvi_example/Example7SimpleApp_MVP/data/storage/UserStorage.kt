package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleApp_MVP.data.storage

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleApp_MVP.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}