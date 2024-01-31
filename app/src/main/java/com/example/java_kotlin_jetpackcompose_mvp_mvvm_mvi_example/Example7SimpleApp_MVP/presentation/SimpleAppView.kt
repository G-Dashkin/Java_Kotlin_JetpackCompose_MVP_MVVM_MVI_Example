package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleApp_MVP.presentation

// Здесь нужны методы которые помогут отобразить информцию об актвити
interface SimpleAppView {
    fun showResult(text: String)
}