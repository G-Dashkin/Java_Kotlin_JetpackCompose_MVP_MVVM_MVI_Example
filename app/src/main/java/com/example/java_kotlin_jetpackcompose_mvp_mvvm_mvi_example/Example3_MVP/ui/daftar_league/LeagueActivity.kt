package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.daftar_league

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.adapter.LeagueAdapter
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.obj.Leagues
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.presenters.LeaguePresenter
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivityLeagueBinding

class LeagueActivity : AppCompatActivity(), LeagueInterface {

    lateinit var binding: ActivityLeagueBinding
    lateinit var presenter : LeaguePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LeaguePresenter(this)
        presenter.getData()
    }

    override fun showLoading() {
        binding.loadingBar.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.loadingBar.progressBar.visibility = View.GONE
    }

    override fun showError(msg: String) {
        binding.bgError.visibility = View.VISIBLE
        binding.recycleBottom.visibility = View.GONE

        binding.txtErrorCode.text = "404"
        binding.txtErrorMsg.text = msg

    }

    override fun showResult(result: Any) {
        binding.bgError.visibility = View.GONE
        binding.recycleBottom.visibility = View.VISIBLE

        val data = result as ArrayList<Leagues>
        val adapdter = LeagueAdapter(data)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.recycleBottom.adapter = adapdter
        binding.recycleBottom.layoutManager = layoutManager
        (binding.recycleBottom.adapter as LeagueAdapter).notifyDataSetChanged()
    }
}
