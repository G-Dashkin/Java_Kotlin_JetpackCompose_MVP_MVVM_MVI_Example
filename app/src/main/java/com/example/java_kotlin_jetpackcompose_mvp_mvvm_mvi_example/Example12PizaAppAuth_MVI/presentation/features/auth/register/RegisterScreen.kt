package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.presentation.features.auth.register

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.PizzaAppGradient
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.height24
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.height32
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.height56
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.padding16
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets.DefaultButton
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets.DefaultFormTextField
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets.Logo
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets.TextLink
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

@Composable
fun RegisterScreen(
    registerUiState: RegisterContract.State,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
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

        Text(text = stringResource(id = R.string.sign_up),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.background)
        Spacer(modifier = Modifier.height(height32))
        DefaultFormTextField(
            text = registerUiState.firstName,
            labelText = stringResource(id = R.string.firs_name),
            isError = registerUiState.firstNameError,
            onChange = onNameChange,
            icon = painterResource(id = R.drawable.ic_person)
        )
        Spacer(modifier = Modifier.height(height24))
        DefaultFormTextField(
            text = registerUiState.email,
            labelText = stringResource(id = R.string.email),
            isError = registerUiState.emailError,
            onChange = onEmailChange,
            icon = painterResource(id = R.drawable.ic_mail)
        )
        Spacer(modifier = Modifier.height(height24))
        DefaultFormTextField(
            text = registerUiState.password,
            labelText = stringResource(id = R.string.password),
            isError = registerUiState.passwordError,
            onChange = onPasswordChange,
            icon = painterResource(id = R.drawable.ic_key)
        )
        Spacer(modifier = Modifier.height(height56))
        DefaultButton(title = stringResource(id = R.string.signup), onClick = onRegisterClick)
        Spacer(modifier = Modifier.height(height24))
        TextLink(sentence = stringResource(id = R.string.already_member_login_here), onLinkClicked = onNavigateToLogin)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SignUpScreenPreview() {
//    PizzaAppTheme {
//        val registerViewModel: RegisterViewModel = viewModel()
//        val registerUiState by registerViewModel.signUpUiState.collectAsStateWithLifecycle()
//        RegisterScreen(
//            registerUiState = registerUiState,
//            registerViewModel = registerViewModel,
//            onNavigateToLogin = {}
//        )
//    }
//}