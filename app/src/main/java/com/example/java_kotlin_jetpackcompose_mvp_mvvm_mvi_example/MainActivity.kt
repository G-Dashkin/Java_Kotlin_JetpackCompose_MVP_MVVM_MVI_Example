package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.PizaAppAuthMVI_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.PizaAppAuthMVP_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.PizaAppAuthMVVM_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesList_MVP.screens.employees.EmployeesListMainActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5RecipeFinderApp_MVI.RecipeFinderAppActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_1MviDecompose_MVI.presentation.MviDecompose1MainActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_2MviDecompose_MVI.presentation.MviDecompose2MainActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_3MviDecompose_MVI.presentation.MviDecompose3MainActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleApp_MVP.presentation.SimpleAppMVP_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleApp_MVVM.presentation.SimpleAppMVVM_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.presentation.SimpleAppMVI_Activity
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
        binding.btnExample2.setOnClickListener { "https://www.youtube.com/watch?v=7aEvmkGigOo" }
        binding.btnExample3.setOnClickListener { "https://www.youtube.com/watch?v=7aEvmkGigOo" + "или" + "https://www.youtube.com/watch?v=7Vc2XUiXHgM&list=PL9myac9mW281RV738DvvTDnJSiA26kfUq" }
        binding.btnExample4.setOnClickListener { "https://www.youtube.com/watch?v=T4NGT9DL3qw" }
        binding.btnExample5.setOnClickListener { startActivity(Intent(this@MainActivity, RecipeFinderAppActivity::class.java)) }
        binding.btnExample61.setOnClickListener { startActivity(Intent(this@MainActivity, MviDecompose1MainActivity::class.java)) }
        binding.btnExample62.setOnClickListener { startActivity(Intent(this@MainActivity, MviDecompose2MainActivity::class.java)) }
        binding.btnExample63.setOnClickListener { startActivity(Intent(this@MainActivity, MviDecompose3MainActivity::class.java)) }
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