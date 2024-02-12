package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.BaseFragment
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.BaseViewModel

inline fun <reified T : BaseViewModel<*, *>> BaseFragment<T, *>.createViewModel(
    crossinline viewModelInitializer: () -> T
): T {
    return ViewModelProvider(viewModelStore, object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return viewModelInitializer() as T
        }
    }).get(T::class.java)
}