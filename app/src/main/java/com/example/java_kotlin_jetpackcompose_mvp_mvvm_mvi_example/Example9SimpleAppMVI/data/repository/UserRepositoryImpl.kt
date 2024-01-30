package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.data.repository

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.data.storage.UserStorage
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.data.storage.models.User
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.model.SaveUserNameParam
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.model.UserName
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    // Эти map-методы превращающий одну модель в другую модель.
    // В методе будет возвращаться класс UserName и приниматься класс User
    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}