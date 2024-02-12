package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.login

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen() {

    val viewModel = LoginScreenViewModel()
    val viewState = viewModel.viewState.collectAsState()

    val userName = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }

    val passwordVisible = rememberSaveable { mutableStateOf(false) }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = userName.value,
                onValueChange = { userName.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                label = { Text(text = "Username") },
            )

            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Password") },
                 visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = if (passwordVisible.value) R.drawable.ic_visibility else R.drawable.ic_visibility_off),
                        contentDescription = "password visibility icon",
                        modifier = Modifier.clickable { passwordVisible.value = !passwordVisible.value }
                    )
                }
            )

            Button(
                onClick = { viewModel.login(userName.value, password.value) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 20.dp),
            ) {
                Text("Login")
            }

            Divider()

            Text(viewState.value.userName)
            Box(Modifier.height(10.dp))
            Text(viewState.value.password)
        }
    }
}