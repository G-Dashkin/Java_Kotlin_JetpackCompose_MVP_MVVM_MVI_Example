package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.Resp

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.obj.Address
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.obj.Company

data class MahasiswaResp (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)