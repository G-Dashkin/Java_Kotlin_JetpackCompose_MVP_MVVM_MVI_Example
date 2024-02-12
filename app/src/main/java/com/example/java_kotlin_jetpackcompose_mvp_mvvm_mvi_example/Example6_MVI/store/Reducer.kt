package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.store

interface Reducer<S: State, A: Action> {

    fun reducer(currentState: S, action: A): S

}