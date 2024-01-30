package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.core.ui.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    text: String,
    @DrawableRes leadingIconResId: Int,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    hasError: Boolean = false
) {
    TextField(
        value = value,
        shape = RoundedCornerShape(8.dp),
        modifier =
        modifier
            .height(56.dp),
        placeholder = {
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        visualTransformation = visualTransformation,
        onValueChange = onValueChange,
        leadingIcon = {
            Image(
                modifier = androidx.compose.ui.Modifier
                    .height(24.dp)
                    .width(24.dp),
                painter = painterResource(id = leadingIconResId),
                contentDescription = "form icon",
                contentScale = ContentScale.None
            )

        },
        trailingIcon = {
            if(hasError){
                Image(
                    modifier = androidx.compose.ui.Modifier
                        .height(24.dp)
                        .width(24.dp),
                    painter = painterResource(id = R.drawable.ic_error),
                    contentDescription = "form error icon",
                    contentScale = ContentScale.None
                )
            }
        },
//        colors = TextFieldDefaults.colors(
//            focusedContainerColor = MaterialTheme.colorScheme.background,
//            unfocusedContainerColor = MaterialTheme.colorScheme.background
//        )
    )
}


//@Preview(showBackground = true)
//@Composable
//fun FormFieldPreview() {
//    KiparoPizzaAppTheme {
//        FormField(
//            value = "test@test.ru",
//            placeholderResId = R.string.email_placeholder,
//            leadingIconResId = R.drawable.ic_mail,
//            onValueChange = {},
//            hasError = true
//        )
//    }
//}