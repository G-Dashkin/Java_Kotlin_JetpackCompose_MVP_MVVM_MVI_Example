package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivitySimpleAppMvpBinding

class SimpleAppMVP_Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleAppMvpBinding
    private lateinit var viewModel: SimpleAppMVP_ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleAppMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "Activity created")

        viewModel = ViewModelProvider(this, SimpleAppMVP_Factory(this)).get(SimpleAppMVP_ViewModel::class.java)

        viewModel.resultLiveData.observe(this) { text ->
            binding.dataTextView.text = text
        }

        binding.apply {

            sendButton.setOnClickListener {
                viewModel.save(dataEditText.text.toString())
            }

            receiveButton.setOnClickListener {
                viewModel.load()
            }

        }
    }
}