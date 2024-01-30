package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.core.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.core.ui.theme.borderRadius16
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.core.ui.theme.height40

@Composable
fun DefaultButton(
    title: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(height40)
            .background(color = MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(
                borderRadius16
            )),
        onClick = onClick,
        shape = RoundedCornerShape(borderRadius16),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Text(
            modifier = Modifier.wrapContentSize(unbounded = true),
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.background
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultButtonPreview() {
//    KiparoPizzaAppTheme {
//        DefaultButton(
//            title = "",
//            onClick = {}
//        )
//    }
//}