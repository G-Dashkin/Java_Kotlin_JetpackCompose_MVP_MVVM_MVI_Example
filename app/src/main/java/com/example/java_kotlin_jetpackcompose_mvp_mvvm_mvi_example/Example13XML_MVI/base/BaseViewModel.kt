package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.util.delegate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<State, Action>(
    private val interactors: Set<Interactor<State, Action>>,
    private val reducer: Reducer<State, Action>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    private var stateValue by mutableState.delegate()
    val state: LiveData<State> = mutableState

    @MainThread
    protected fun action(action: Action) {
        stateValue = reducer.reduce(stateValue, action)
        interactors.filter { it.canHandle(action) }.forEach { interactor ->
            viewModelScope.launch(Dispatchers.IO) {
                val result = interactor.invoke(stateValue, action)
                withContext(Dispatchers.Main) {
                    action(result)
                }
            }
        }
    }

}