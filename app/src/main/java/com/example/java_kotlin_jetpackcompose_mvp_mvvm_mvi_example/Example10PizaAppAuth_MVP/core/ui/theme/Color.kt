package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.core.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val DarkLilac = Color(0xFF4506C2)
val Orange = Color(0xFFE8900C)
val Yellow = Color(0xFFFFF500)
val Green = Color(0xFF288E05)
val Lilac = Color(0xFF6936CF)
val Red = Color(0xFFB3261E)

val White = Color(0xFFFFFFFF)
val LightGray = Color(0xFFEDEBF2)
val Gray = Color(0xFFA09BAC)
val Black = Color(0xFF0B0A0D)

val PizzaAppGradient = Brush.linearGradient(
    colors = listOf(
        Lilac,
        DarkLilac
    ),
    start = Offset(0f, 0f)
)