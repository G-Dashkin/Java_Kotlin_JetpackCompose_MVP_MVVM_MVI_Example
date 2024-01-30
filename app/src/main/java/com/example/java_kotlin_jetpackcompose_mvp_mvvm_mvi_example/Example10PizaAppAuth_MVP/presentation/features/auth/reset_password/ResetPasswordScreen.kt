package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.presentation.features.auth.reset_password

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
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.PizzaAppGradient
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.PizzaAppTheme
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.height24
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.height32
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.height56
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme.padding16
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets.DefaultButton
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets.DefaultFormTextField
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets.Logo
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.widgets.TextLink
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

@Composable
fun ResetPasswordScreen(
    resetPasswordUiState: ResetPasswordUiState,
    resetPasswordViewModel: ResetPasswordViewModel,
    onNavigateToLogin: () -> Unit
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

        Text(text = stringResource(id = R.string.reset_password),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.background)
        Spacer(modifier = Modifier.height(height32))
        DefaultFormTextField(
            text = resetPasswordUiState.email,
            labelText = stringResource(id = R.string.email),
            isError = resetPasswordUiState.emailError,
            onChange = resetPasswordViewModel::onEmailChange,
            icon = painterResource(id = R.drawable.ic_mail)
        )
        Spacer(modifier = Modifier.height(height56))
        DefaultButton(title = stringResource(id = R.string.send), onClick = resetPasswordViewModel::onResetPasswordSubmit)
        Spacer(modifier = Modifier.height(height24))
        TextLink(sentence = stringResource(id = R.string.already_member_login_here), onLinkClicked = onNavigateToLogin)
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordScreenPreview() {
    PizzaAppTheme {
        val resetPasswordViewModel: ResetPasswordViewModel = viewModel()
        val resetPasswordUiState by resetPasswordViewModel.resetPasswordUiState.collectAsStateWithLifecycle()
        ResetPasswordScreen(
            resetPasswordUiState = resetPasswordUiState,
            resetPasswordViewModel = resetPasswordViewModel,
            onNavigateToLogin = {}
        )
    }
}