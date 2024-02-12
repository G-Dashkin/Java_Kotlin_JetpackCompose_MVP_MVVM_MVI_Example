package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.store

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * A [Store] represents state container for a screen
 * @param[initialState] initial state of screen
 * @param[reducer] transforms current state with action into new state for screen
 */

class Store<S: State, A: Action>(
    initialState: S, private val reducer: Reducer<S, A>) {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state.asStateFlow()

    private val currentState get() = _state.value

    fun dispatch(action: A) {
        val newState = reducer.reducer(currentState, action)
        _state.value = newState
    }

}