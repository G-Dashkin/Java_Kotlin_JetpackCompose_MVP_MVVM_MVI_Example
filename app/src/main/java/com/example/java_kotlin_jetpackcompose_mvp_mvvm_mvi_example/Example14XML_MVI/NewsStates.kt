package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI

sealed class NewsStates {
    data class Success(val news: NewsData) : NewsStates()
    data class Error(val errorMessage: String) : NewsStates()
    object Loading : NewsStates()
}