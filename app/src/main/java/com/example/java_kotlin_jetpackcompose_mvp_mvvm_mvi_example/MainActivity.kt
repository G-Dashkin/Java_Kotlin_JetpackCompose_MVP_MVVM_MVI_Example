package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.PizaAppAuthMVI_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.PizaAppAuthMVP_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.PizaAppAuthMVVM_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesListMVP.screens.employees.EmployeesListMainActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.presentation.SimpleAppMVP_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleAppMVVM.presentation.SimpleAppMVVM_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleAppMVI.presentation.SimpleAppMVI_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MVP MovieApp - Java
        // MVVM - Kotlin что то из кипаро ?
        // MVVM - Kotlin что то не из кипаро ?
        // MVVM - Kotlin что то еще...?
        // MVI NoteList - JetpackCompose

        binding.btnExample1.setOnClickListener { startActivity(Intent(this@MainActivity, EmployeesListMainActivity::class.java)) }
        binding.btnExample2.setOnClickListener {  }
        binding.btnExample3.setOnClickListener {  }
        binding.btnExample4.setOnClickListener {  }
        binding.btnExample5.setOnClickListener {  }
        binding.btnExample6.setOnClickListener {  }
        //-----------------------------------SimpleMVAPP--------------------------------------------
        binding.btnExample7.setOnClickListener { startActivity(Intent(this@MainActivity, SimpleAppMVP_Activity::class.java)) }
        binding.btnExample8.setOnClickListener { startActivity(Intent(this@MainActivity, SimpleAppMVVM_Activity::class.java)) }
        binding.btnExample9.setOnClickListener { startActivity(Intent(this@MainActivity, SimpleAppMVI_Activity::class.java)) }
        //-----------------------------------PizaApp AUTH-------------------------------------------
        binding.btnExample10.setOnClickListener { startActivity(Intent(this@MainActivity, PizaAppAuthMVP_Activity::class.java)) }
        binding.btnExample11.setOnClickListener { startActivity(Intent(this@MainActivity, PizaAppAuthMVVM_Activity::class.java)) }
        binding.btnExample12.setOnClickListener { startActivity(Intent(this@MainActivity, PizaAppAuthMVI_Activity::class.java)) }

    }
}