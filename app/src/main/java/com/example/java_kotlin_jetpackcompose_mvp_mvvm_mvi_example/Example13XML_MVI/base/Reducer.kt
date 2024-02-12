package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base

interface Reducer<State, Action> {

    val initialState: State

    fun reduce(state: State, action: Action): State

}