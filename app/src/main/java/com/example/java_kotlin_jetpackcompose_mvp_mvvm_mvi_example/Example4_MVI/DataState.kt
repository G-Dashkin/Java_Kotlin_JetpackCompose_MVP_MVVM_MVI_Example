package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4_MVI

sealed class DataState<T> {
    data class Loading<T>(val isLoading: Boolean): DataState<T>()
    data class Success<T>(val data: T): DataState<T>()
    data class Error<T>(val uiComponent: UIComponent): DataState<T>()
}

sealed class UIComponent {

    data class Toast(val text: String): UIComponent()

    data class SnackBar(val text: String): UIComponent()

    data class Dialog(val title: String, val message: String): UIComponent()

}