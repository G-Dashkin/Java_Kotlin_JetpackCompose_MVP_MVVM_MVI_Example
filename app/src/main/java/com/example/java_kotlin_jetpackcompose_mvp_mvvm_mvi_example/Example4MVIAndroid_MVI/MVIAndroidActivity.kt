package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4MVIAndroid_MVI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4MVIAndroid_MVI.ui.theme.MVIAndroidTheme
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

class MVIAndroidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVIAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                }
            }
        }
    }
}