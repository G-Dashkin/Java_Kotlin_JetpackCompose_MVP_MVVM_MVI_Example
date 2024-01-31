package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleApp_MVVM.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleApp_MVVM.data.repository.UserRepositoryImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleApp_MVVM.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleApp_MVVM.domain.usecases.GetUserNameUseCase
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleApp_MVVM.domain.usecases.SaveUserNameUseCase

class SimpleAppMVVM_Factory(context: Context) : ViewModelProvider.Factory {

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
        return SimpleAppMVVM_ViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }

}