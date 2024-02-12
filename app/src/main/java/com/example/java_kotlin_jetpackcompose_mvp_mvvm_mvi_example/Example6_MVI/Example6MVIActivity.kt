package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.login.LoginScreen

class Example6MVIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                LoginScreen()
            }
        }
    }
}