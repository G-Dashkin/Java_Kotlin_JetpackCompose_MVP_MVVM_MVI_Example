package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.features.contact_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.domain.models.Contact
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components.AddContactComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.components.EditContactComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContact(
    component: AddContactComponent
) {

    val model by component.model.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = model.userName,
            placeholder = {
                Text(text = "Username:")
            },
            onValueChange = { component.onUserNameChange(it) }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = model.phone,
            placeholder = {
                Text(text = "Phone:")
            },
            onValueChange = { component.onPhoneChange(it) }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
               component.onSaveContactClicked()
            }
        ) {
            Text(text = "Save")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContact(
    component: EditContactComponent
) {
    val model by component.model.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = model.userName,
            placeholder = {
                Text(text = "Username:")
            },
            onValueChange = { component.onUserNameChange(it) }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = model.phone,
            placeholder = {
                Text(text = "Phone:")
            },
            onValueChange = { component.onPhoneChange(it) }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                component.onSaveContactClicked()
            }
        ) {
            Text(text = "Save")
        }
    }
}