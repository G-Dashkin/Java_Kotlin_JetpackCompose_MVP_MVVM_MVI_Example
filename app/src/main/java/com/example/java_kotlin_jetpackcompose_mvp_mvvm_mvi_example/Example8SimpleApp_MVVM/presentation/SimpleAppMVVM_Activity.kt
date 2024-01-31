package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example8SimpleApp_MVVM.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivitySimpleAppMvvmBinding

class SimpleAppMVVM_Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleAppMvvmBinding
    private lateinit var viewModel: SimpleAppMVVM_ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleAppMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "Activity created")

        viewModel = ViewModelProvider(this, SimpleAppMVVM_Factory(this)).get(SimpleAppMVVM_ViewModel::class.java)

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