package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.presenters.RegisterPresenter
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.ui.dashboard.Example3MVPActivity
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity(), RegisterInterface {

    lateinit var binding: ActivityRegisterBinding
    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = RegisterPresenter(this, applicationContext)

        binding.btnRegister.setOnClickListener {
            val name = binding.edtName.text.toString().trim()
            val address = binding.edtAdress.text.toString().trim()
            val phone = binding.edtTelephone.text.toString().trim()
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            presenter.checkRegister(name, address, phone, username, password)
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
        Toast.makeText(this, "Berhasil Register", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this@RegisterActivity, Example3MVPActivity::class.java))
    }
}
