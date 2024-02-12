package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base

interface Interactor<State, Action> {

    suspend operator fun invoke(state: State, action: Action): Action

    fun canHandle(action: Action): Boolean

}