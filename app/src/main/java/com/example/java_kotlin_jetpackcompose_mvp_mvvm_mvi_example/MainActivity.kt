package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.ui.theme.Java_Kotlin_JetpackCompose_MVP_MVVM_MVI_ExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Java_Kotlin_JetpackCompose_MVP_MVVM_MVI_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    // Разделы
                    // MVP MovieApp - Java
                    // MVVM - Kotlin что то из кипаро ?
                    // MVVM - Kotlin что то не из кипаро ?
                    // MVVM - Kotlin что то еще...?
                    // MVI NoteList - JetpackCompose
                    // ----
                    // MVP - ТемофейExample Kotlin
                    // MVVM - ТемофейExample Kotlin
                    // MVI - ТемофейExample Kotlin
                    // ----
                    // MVP - PizaApp (AUTH Чать)
                    // MVVM - PizaApp (AUTH Чать)
                    // MVI  - PizaApp (AUTH Чать)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Java_Kotlin_JetpackCompose_MVP_MVVM_MVI_ExampleTheme {
        Greeting("Android")
    }
}