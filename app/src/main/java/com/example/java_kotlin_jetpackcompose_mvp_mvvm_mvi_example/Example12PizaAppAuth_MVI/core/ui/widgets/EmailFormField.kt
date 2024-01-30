package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

@Composable
fun EmailFormField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange:(String)->Unit
) {
    FormField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        text = "Email",
        leadingIconResId = R.drawable.ic_mail
    )
}