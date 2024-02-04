package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.presenters

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.client.ApiInterface
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.Resp.LeagueResp
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.obj.Leagues
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.daftar_league.LeagueInterface
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LeaguePresenter(val view: LeagueInterface) {

    fun getData(){
        val data : ArrayList<Leagues> = arrayListOf()
        view.showLoading()
        ApiInterface.createAPI().leagueList("application/json","application/json").enqueue(object: Callback, retrofit2.Callback<LeagueResp> {
            override fun onResponse(call: Call<LeagueResp>, response: Response<LeagueResp>) {
                view.hideLoading()
                if (response.isSuccessful){
                    if (response.body()!!.leagues.size == 0){
                        view.showError( "Data belum tersedia")
                    }else {
                        for(item in response.body()!!.leagues){
                            data.add(item)
                        }
                        view.showResult(data)
                    }
                }else {
                    view.showError( "Gagal terhubung ke server")
                }
            }
            override fun onFailure(call: Call<LeagueResp>, t: Throwable) {
                view.hideLoading()
                view.showError( "Connection Time Out")
            }
        })
    }

}