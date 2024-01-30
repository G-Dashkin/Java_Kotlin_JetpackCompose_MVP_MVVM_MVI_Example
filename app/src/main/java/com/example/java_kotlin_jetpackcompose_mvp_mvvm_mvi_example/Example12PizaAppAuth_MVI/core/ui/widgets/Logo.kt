package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.height75
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.width104

private const val CAPITAL_LETTERS_FINDER = "(?<=.)(?=\\p{Lu})"

@Composable
fun Logo(text: String, transformText: Boolean = false) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .width(width104)
                .height(height75),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo)
        )
        if (transformText) {
            /**
             * Код находит заглавные буквы в передаваемой строке. Далее создаются массивы из
             * заглавных и строчных букв. Для заглавных букв применяется один цвет, а для строчных другой,
             * таким образом все заглавные и строчные буквы будут иметь такой же цвет как в дизайне.
             *
             * Можно передавать любой текст, код универсальный.
             */
            /**
             * Код находит заглавные буквы в передаваемой строке. Далее создаются массивы из
             * заглавных и строчных букв. Для заглавных букв применяется один цвет, а для строчных другой,
             * таким образом все заглавные и строчные буквы будут иметь такой же цвет как в дизайне.
             *
             * Можно передавать любой текст, код универсальный.
             */
            val listOfLogo = text.split(CAPITAL_LETTERS_FINDER.toRegex()).map { listOf(it.first(), it.drop(1)) }
            Row {
                listOfLogo.forEach{ list ->
                    list.forEach {
                        if (it.toString().length == 1 && it.toString().first().isUpperCase()){
                            Text(text = it.toString(), color = MaterialTheme.colorScheme.inversePrimary,
                                style = MaterialTheme.typography.headlineLarge)
                        } else {
                            Text(text = it.toString(), color = MaterialTheme.colorScheme.onPrimary,
                                style = MaterialTheme.typography.headlineLarge)
                        }
                    }
                }
            }
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.headlineLarge)
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun LogoPreview() {
//    KiparoPizzaAppTheme {
//        Logo(text = stringResource(id = R.string.kiparo_pizza), transformText = true)
//    }
//}