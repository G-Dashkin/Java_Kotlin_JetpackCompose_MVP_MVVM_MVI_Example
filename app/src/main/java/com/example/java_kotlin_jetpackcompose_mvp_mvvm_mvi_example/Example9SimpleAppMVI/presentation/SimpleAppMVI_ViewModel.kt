package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.model.SaveUserNameParam
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.model.UserName
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.usecases.GetUserNameUseCase
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.usecases.SaveUserNameUseCase

class SimpleAppMVI_ViewModel (
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    private var stateLiveData = MutableLiveData<SimpleAppMVI_State>()
    val resultLiveData: LiveData<SimpleAppMVI_State> = stateLiveData

    init {
        Log.d("MyLog", "ViewModel created")
        stateLiveData.value = SimpleAppMVI_State(saveResult = false, firstName = "", lastName = "")
    }

    override fun onCleared() {
        Log.d("MyLog", "ViewModel cleared")
        super.onCleared()
    }

    fun send(event: SimpleAppMVI_Event) {
        when(event) {
            is SaveEvent -> {
                save(text = event.text)
            }
            is LoadEvent -> {
                load()
            }
        }

    }

    private fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        stateLiveData.value = SimpleAppMVI_State(
            saveResult = resultData,
            firstName = stateLiveData.value!!.firstName,
            lastName = stateLiveData.value!!.lastName
        )
    }

    private fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        stateLiveData.value = SimpleAppMVI_State(
            saveResult = stateLiveData.value!!.saveResult,
            firstName = userName.firstName,
            lastName = userName.lastName
        )
    }

}