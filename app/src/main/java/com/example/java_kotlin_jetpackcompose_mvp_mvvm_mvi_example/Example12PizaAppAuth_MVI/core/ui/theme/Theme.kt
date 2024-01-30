package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = DarkLilac,
    primaryContainer = Lilac,
    onPrimary = White,
    secondary = Orange,
    background = White,
    onBackground = Black,
    surface = LightGray,
    onSurface = Gray,
    inversePrimary = Yellow
)

private val lightColorScheme = lightColorScheme(
    primary = DarkLilac,
    primaryContainer = Lilac,
    onPrimary = White,
    secondary = Orange,
    background = White,
    onBackground = Black,
    surface = LightGray,
    onSurface = Gray,
    inversePrimary = Yellow
)

@Composable
fun PizzaAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}