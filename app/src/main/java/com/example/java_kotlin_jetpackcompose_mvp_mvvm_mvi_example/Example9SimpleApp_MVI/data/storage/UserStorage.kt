package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.data.storage

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}