package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.login

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.PizzaAppGradient
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.PizzaAppTheme
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.height24
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.height32
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.height8
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.padding16
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets.DefaultButton
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets.DefaultFormTextField
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets.Logo
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets.TextLink

@Composable
fun LoginScreen(
    loginUiState: LoginUiState,
    loginViewModel: LoginViewModel,
    onLoginClicked: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    onNavigateToResetPassword: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = PizzaAppGradient)
            .padding(start = padding16, end = padding16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(height32))
        Logo(text = stringResource(id = R.string.kiparo_pizza), transformText = true)
        Spacer(modifier = Modifier.height(height32))

        Text(text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.background
        )
        Spacer(modifier = Modifier.height(height32))
        DefaultFormTextField(
            text = loginUiState.email,
            labelText = stringResource(id = R.string.email),
            isError = loginUiState.emailError,
            onChange = loginViewModel::onEmailChange,
            icon = painterResource(id = R.drawable.ic_mail)
        )
        Spacer(modifier = Modifier.height(height24))
        DefaultFormTextField(
            text = loginUiState.password,
            labelText = stringResource(id = R.string.password),
            isError = loginUiState.passwordError,
            onChange = loginViewModel::onPasswordChange,
            icon = painterResource(id = R.drawable.ic_key)
        )
        Spacer(modifier = Modifier.height(height24))
        DefaultButton(title = stringResource(id = R.string.login), onClick = {})
        Spacer(modifier = Modifier.height(height24))
        TextLink(sentence = stringResource(id = R.string.not_member_register_here), onLinkClicked = onNavigateToSignUp)
        Spacer(modifier = Modifier.height(height8))
        TextLink(sentence = stringResource(id = R.string.forgot_password_reset_here), onLinkClicked = onNavigateToResetPassword)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PizzaAppTheme {
        val loginViewModel: LoginViewModel = viewModel()
        val loginUiState by loginViewModel.loginUiState.collectAsStateWithLifecycle()
        LoginScreen(
            loginUiState = loginUiState,
            loginViewModel = loginViewModel,
            onLoginClicked = {},
            onNavigateToSignUp = {},
            onNavigateToResetPassword = {}
        )
    }
}