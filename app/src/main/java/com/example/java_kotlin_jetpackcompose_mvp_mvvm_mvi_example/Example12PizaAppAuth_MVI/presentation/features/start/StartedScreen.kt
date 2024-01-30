package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.start.navigation.FoodCircle
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.PizzaAppGradient
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.PizzaAppTheme
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.height32
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.height40
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.padding48
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets.DefaultButton
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets.Logo

@Composable
fun StartedScreen(
    onStartClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = PizzaAppGradient)
            .padding(start = padding48, end = padding48),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(height32))
        Logo(text = stringResource(id = R.string.kiparo_pizza), transformText = true)
        Spacer(modifier = Modifier.height(height32))
        FoodCircle()
        Spacer(modifier = Modifier.height(height32))
        Text(text = stringResource(id = R.string.enjoy),
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(text = stringResource(id = R.string.your_meal),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(height40))
        DefaultButton(title = stringResource(id = R.string.get_started), onClick = onStartClicked)
    }
}

@Preview(showBackground = true)
@Composable
fun StartedScreenPreview() {
    PizzaAppTheme {
        StartedScreen(onStartClicked = {})
    }
}