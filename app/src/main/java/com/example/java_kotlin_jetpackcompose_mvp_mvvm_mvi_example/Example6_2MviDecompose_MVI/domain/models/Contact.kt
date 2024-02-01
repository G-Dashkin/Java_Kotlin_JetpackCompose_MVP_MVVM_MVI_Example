package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val id: Int = -1,
    val username: String,
    val phone: String
): Parcelable