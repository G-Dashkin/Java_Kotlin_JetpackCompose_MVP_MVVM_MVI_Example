package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.data.repository.UserRepositoryImpl
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.usecases.GetUserNameUseCase
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.usecases.SaveUserNameUseCase
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivitySimpleAppMvpBinding

// Наследум интерфейс SimpleAppView для активти, чтобы отображать данные
class SimpleAppMVP_Activity : AppCompatActivity(), SimpleAppView {

    private lateinit var binding: ActivitySimpleAppMvpBinding

    // Создаем юз кейсы на месте, так как фабрики нет.
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = this))
    }
////    private val userRepository = UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = this))
//
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    // Наш презентер
    private val presenter: SimpleAppPresenter = SimpleAppPresenterImpl(
        getUserNameUseCase = getUserNameUseCase,
        saveUserNameUseCase = saveUserNameUseCase,
        // Вот здесь проблема, нужно передать SimpleAppView, но непонятно как... нужно исправить
        view = this
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleAppMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "Activity created")

        binding.apply {

            sendButton.setOnClickListener {
                presenter.save(dataEditText.text.toString())
            }

            receiveButton.setOnClickListener {
                presenter.load()
            }
        }
    }

    // Переопределяем метод showResult()showResult для отображения результата
    override fun showResult(text: String) {
        binding.dataTextView.text = text
    }
}