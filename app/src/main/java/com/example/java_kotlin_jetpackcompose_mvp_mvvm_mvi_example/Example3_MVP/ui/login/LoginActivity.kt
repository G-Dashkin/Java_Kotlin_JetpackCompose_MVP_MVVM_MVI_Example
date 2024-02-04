package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.screens.employees.Example1MVPActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.presenters.LoginPresenter
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.dashboard.Example3MVPActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginInterface {

    lateinit var binding: ActivityLoginBinding
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this, applicationContext)

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            presenter.checkLogin(username, password)
        }

    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun showError(msg: String) {
        TODO("Not yet implemented")
    }

    override fun showResult(result: Any) {
        Toast.makeText(this, "Berhasil Login",Toast.LENGTH_SHORT).show()
        startActivity(Intent(this@LoginActivity, Example3MVPActivity::class.java))
    }
}
