package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.presentation.components.DefaultRootComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.presentation.features.RootContent

class MviDecompose2MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootContent(component = DefaultRootComponent(defaultComponentContext()))
        }
    }
}