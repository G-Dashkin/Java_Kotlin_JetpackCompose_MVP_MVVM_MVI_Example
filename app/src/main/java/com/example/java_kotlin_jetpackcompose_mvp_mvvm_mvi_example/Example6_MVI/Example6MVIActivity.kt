package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

class Example6MVIActivity : AppCompatActivity() {

    // https://www.youtube.com/watch?v=wTJX_lWdh60
    // https://github.com/AdamMc331/MVIExample
    // https://www.youtube.com/watch?v=MqWV_230cVY
    // https://www.youtube.com/watch?v=R2w9enSqeso
    // -------------------------------------------
    // https://www.youtube.com/watch?v=CRpewfVa5XA
    // https://www.youtube.com/watch?v=PwOSwMDdEMM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {

            }
        }
    }
}