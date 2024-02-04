package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.daftar_league.LeagueActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivityExample3MvpBinding

class Example3MVPActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExample3MvpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExample3MvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDaftarLeague.setOnClickListener {
            startActivity(Intent(this@Example3MVPActivity, LeagueActivity::class.java))
        }

    }
}