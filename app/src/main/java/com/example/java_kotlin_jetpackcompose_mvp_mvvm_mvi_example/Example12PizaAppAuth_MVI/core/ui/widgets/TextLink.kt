package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme.bodyLargeBold

@Composable
fun TextLink(
    modifier: Modifier = Modifier,
    sentence: String,
    enterMarker: String = "{{",
    endMarker: String = "}}",
    defaultStyle: SpanStyle = SpanStyle(
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
        fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
        color = MaterialTheme.colorScheme.background
    ),
    linkStyle: SpanStyle = SpanStyle(
        fontSize = bodyLargeBold.fontSize,
        fontFamily = bodyLargeBold.fontFamily,
        fontWeight = bodyLargeBold.fontWeight,
        color = MaterialTheme.colorScheme.background
    ),
    onLinkClicked: () -> Unit = { }
){
    val source = sentence
    val link = remember { source.substringAfter(enterMarker).substringBefore(endMarker) }
    val entryStart = remember { source.indexOf(enterMarker) }
    val entryEnd = remember { source.indexOf(endMarker) + endMarker.length }
    val sentenceStart = remember { source.take(entryStart) }
    val sentenceEnd = remember { source.takeLast(source.length - entryEnd) }

    val annotatedString = buildAnnotatedString {
        withStyle(defaultStyle) { append (sentenceStart) }
        withStyle(linkStyle) {
            pushStringAnnotation(tag = link, annotation = link)
            append(link)
        }
        withStyle(defaultStyle) { append(sentenceEnd) }
    }

    Box(modifier = modifier) {
        ClickableText(text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.let { span ->
                    onLinkClicked()
                }
            })
    }
}

//@Preview
//@Composable
//fun TextLinkPreview(){
//    KiparoPizzaAppTheme {
//        TextLink(
//            sentence = stringResource(id = R.string.not_member_register_here),
//            onLinkClicked = {})
//    }
//}