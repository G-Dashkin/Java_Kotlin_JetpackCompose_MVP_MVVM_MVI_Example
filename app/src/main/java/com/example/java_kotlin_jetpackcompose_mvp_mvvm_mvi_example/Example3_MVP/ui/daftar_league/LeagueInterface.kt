package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.daftar_league

interface LeagueInterface {
    fun showLoading()
    fun hideLoading()
    fun showError(msg: String)
    fun showResult(result: Any)
}