package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.borderRadius8
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.height60
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.itemSize24
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.shape8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultFormTextField(
    modifier: Modifier = Modifier,
    text: String,
    labelText: String,
    isError: Boolean,
    icon: Painter,
    onChange: (value: String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(shape8))
            .background(color = MaterialTheme.colorScheme.background)
            .height(height60),
        value = text,
        leadingIcon = {
            Image(modifier = Modifier.size(itemSize24), painter = icon, contentDescription = text)
        },
        onValueChange = onChange,
        shape = RoundedCornerShape(borderRadius8),
        label = {
            Text(modifier = Modifier,
                text = labelText, style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface)
        },
        textStyle = MaterialTheme.typography.labelMedium,
        isError = isError
    )
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultFormTextFieldPreview() {
//    val textState = remember { mutableStateOf("") }
//    val onTextChange = { text : String -> textState.value = text }
//    KiparoPizzaAppTheme {
//        DefaultFormTextField(
//            modifier = Modifier.fillMaxWidth(),
//            text = textState.value,
//            onChange = onTextChange,
//            labelText = stringResource(id = R.string.email),
//            isError = false,
//            icon = painterResource(id = R.drawable.ic_mail),
//        )
//    }
//}