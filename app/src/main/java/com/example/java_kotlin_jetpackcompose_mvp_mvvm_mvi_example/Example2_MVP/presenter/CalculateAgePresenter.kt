package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example2_MVP.presenter

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example2_MVP.models.Person
import java.util.*

class CalculateAgePresenter(private val view: View): ICalculateAgePresenter {


    override fun calculateYourAge(name: String, age: String) {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val yourAge = currentYear - age.toInt()
        val person = Person(name, yourAge)
        view.getInfo(person)
    }

    interface View {
        fun getInfo(person: Person)
    }
}