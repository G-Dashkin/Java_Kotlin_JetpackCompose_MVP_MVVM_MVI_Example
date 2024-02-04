package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.presenters

import android.content.Context
import android.widget.Toast
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.register.RegisterInterface

class RegisterPresenter(val view: RegisterInterface, val context: Context) {

    fun checkRegister(name: String, address: String, phone: String, username: String, password: String){
        if(name.isEmpty() || address.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()){
//            view.showError("Pastikan form tidak boleh kosong")
            Toast.makeText(context, "Pastikan form tidak boleh kosong", Toast.LENGTH_LONG).show()
        }else {
            doRegister(name, address, phone, username, password)
        }
    }

    private fun doRegister(name: String, address: String, phone: String, username: String, password: String){
        view.showResult("Ini Nama")
        view.showLoading()
//        val request = LoginRequest(username, password)
//        ApiInterface.createAPI().postLogin("application/json","application/json", request).enqueue(object: Callback, retrofit2.Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                view.hideLoading()
//                if (response.isSuccessful){
//                    val body = response.body()!!
//                    if (body.sttCode.equals("200")){
//                        view.showResult(username)
//                        val nama = body.nama
//                        view.showProfile(nama)
//                    }else {
//                        view.showError(body.msg)
//                    }
//                }else {
//                    view.showError("Error 404")
//                }
//            }
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                view.hideLoading()
//                view.showError(t.message.toString())
//            }
//        })
    }

}