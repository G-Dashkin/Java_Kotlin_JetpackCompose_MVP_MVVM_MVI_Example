package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.PizaAppAuthMVI_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example10PizaAppAuth_MVP.PizaAppAuthMVP_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example11PizaAppAuth_MVVM.PizaAppAuthMVVM_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.Example13XML_MVI_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.Example14XML_MVI_Activity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.screens.employees.Example1MVPActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example2_MVP.Example2MVPActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.login.LoginActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4_MVI.Example4MVIActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example5_MVI.Example5MVIActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example6_MVI.Example6MVIActivity
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

        //------------------------------------MVP---------------------------------------------------
        binding.btnExample1.setOnClickListener { startActivity(Intent(this@MainActivity, Example1MVPActivity::class.java)) }
        binding.btnExample2.setOnClickListener { startActivity(Intent(this@MainActivity, Example2MVPActivity::class.java)) }
        binding.btnExample3.setOnClickListener { startActivity(Intent(this@MainActivity, LoginActivity::class.java)) }
        //------------------------------------MVI---------------------------------------------------
        binding.btnExample4.setOnClickListener { startActivity(Intent(this@MainActivity, Example4MVIActivity::class.java)) }
        binding.btnExample5.setOnClickListener { startActivity(Intent(this@MainActivity, Example5MVIActivity::class.java)) }
        binding.btnExample6.setOnClickListener { startActivity(Intent(this@MainActivity, Example6MVIActivity::class.java)) }
        //-----------------------------------SimpleMVapp--------------------------------------------
        binding.btnExample7.setOnClickListener { startActivity(Intent(this@MainActivity, SimpleAppMVP_Activity::class.java)) }
        binding.btnExample8.setOnClickListener { startActivity(Intent(this@MainActivity, SimpleAppMVVM_Activity::class.java)) }
        binding.btnExample9.setOnClickListener { startActivity(Intent(this@MainActivity, SimpleAppMVI_Activity::class.java)) }
        //-----------------------------------PizaApp AUTH-------------------------------------------
        binding.btnExample10.setOnClickListener { startActivity(Intent(this@MainActivity, PizaAppAuthMVP_Activity::class.java)) }
        binding.btnExample11.setOnClickListener { startActivity(Intent(this@MainActivity, PizaAppAuthMVVM_Activity::class.java)) }
        binding.btnExample12.setOnClickListener { startActivity(Intent(this@MainActivity, PizaAppAuthMVI_Activity::class.java)) }
        //-----------------------------------XML MVI-------------------------------------------
        binding.btnExample13.setOnClickListener { startActivity(Intent(this@MainActivity, Example13XML_MVI_Activity::class.java)) }
        binding.btnExample14.setOnClickListener { startActivity(Intent(this@MainActivity, Example14XML_MVI_Activity::class.java)) }
    }
}