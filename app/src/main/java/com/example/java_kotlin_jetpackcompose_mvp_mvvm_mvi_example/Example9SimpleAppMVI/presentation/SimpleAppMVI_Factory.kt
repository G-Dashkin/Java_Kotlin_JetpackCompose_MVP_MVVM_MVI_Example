package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.data.repository.UserRepositoryImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.usecases.GetUserNameUseCase
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.domain.usecases.SaveUserNameUseCase

class SimpleAppMVI_Factory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SimpleAppMVI_ViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }

}