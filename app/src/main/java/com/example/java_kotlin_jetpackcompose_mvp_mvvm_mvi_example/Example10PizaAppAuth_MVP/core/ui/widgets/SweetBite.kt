package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

@Composable
fun SweetBite(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.sweet_bite),
            contentDescription = "Sweet bite",
            contentScale = ContentScale.Fit
        )
    }
}

//@Preview
//@Composable
//fun SweetBitePreview() {
//    KiparoPizzaAppTheme {
//        SweetBite()
//    }
//}