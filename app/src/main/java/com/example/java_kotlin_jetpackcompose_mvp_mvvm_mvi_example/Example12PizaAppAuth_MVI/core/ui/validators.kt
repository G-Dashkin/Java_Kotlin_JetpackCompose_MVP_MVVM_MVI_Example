package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.ui

fun String.isValidEmail(): Boolean {
    return matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex())
}

// Alphanumeric string of minimum 6 items
fun String.isValidPassword(): Boolean {
    return isNotEmpty() &&
            matches("^[a-zA-Z0-9]{6,}\$".toRegex())
}