package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivitySimpleAppMviBinding

class SimpleAppMVI_Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleAppMviBinding
    private lateinit var viewModel: SimpleAppMVI_ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleAppMviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "Activity created")

        viewModel = ViewModelProvider(this, SimpleAppMVI_Factory(this)).get(SimpleAppMVI_ViewModel::class.java)

        viewModel.resultLiveData.observe(this) { state ->
            binding.dataTextView.text = "${state.firstName} ${state.lastName}"
        }

        binding.apply {

            sendButton.setOnClickListener {
                viewModel.send(SaveEvent(text = binding.dataEditText.text.toString()))
            }

            receiveButton.setOnClickListener {
                viewModel.send(LoadEvent())
            }

        }
    }
}