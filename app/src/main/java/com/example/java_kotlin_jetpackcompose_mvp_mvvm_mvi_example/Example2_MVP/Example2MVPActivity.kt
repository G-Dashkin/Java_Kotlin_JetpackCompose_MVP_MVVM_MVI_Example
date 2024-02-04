package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example2_MVP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example2_MVP.models.Person
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example2_MVP.presenter.CalculateAgePresenter
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example2_MVP.presenter.ICalculateAgePresenter
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivityExample2MvpBinding

class Example2MVPActivity : AppCompatActivity(), CalculateAgePresenter.View {

    private lateinit var binding: ActivityExample2MvpBinding
    lateinit var calculateAgePresenter: ICalculateAgePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExample2MvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculateAgePresenter = CalculateAgePresenter(this)

        binding.buttonCalculateAge.setOnClickListener {
            calculateAgePresenter.calculateYourAge(
                name = binding.editTextName.text.trim().toString(),
                age = binding.editTextAge.text.trim().toString()
            )
        }
    }

    override fun getInfo(person: Person) {
        binding.textViewYourAge.text = "${person.name} your age: ${person.age}"
    }
}