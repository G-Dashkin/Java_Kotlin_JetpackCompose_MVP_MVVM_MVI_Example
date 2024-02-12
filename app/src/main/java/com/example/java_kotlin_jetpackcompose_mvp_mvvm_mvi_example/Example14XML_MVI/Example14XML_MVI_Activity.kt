package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.ui.NewsAdapter
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.ActivityExample14XmlMviBinding
import kotlinx.coroutines.launch

class Example14XML_MVI_Activity : AppCompatActivity(){

    private val newsViewModel : NewsViewModel by viewModels()

    private val newsAdapter = NewsAdapter()

    private lateinit var binding: ActivityExample14XmlMviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExample14XmlMviBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = newsAdapter
        }

        lifecycleScope.launch {
            newsViewModel.newsChannel.send(NewsIntents.TopHeadlinesIntent)
        }

        lifecycleScope.launch {
            lifecycleScope.launchWhenStarted {
                newsViewModel.newsStates.collect {
                    when(it){
                        is NewsStates.Success -> {
                            binding.progressBar.visibility = View.GONE
                            newsAdapter.addArticles(it.news.articles)
                        }
                        is NewsStates.Error -> {
                            binding.progressBar.visibility = View.GONE
                        }
                        is NewsStates.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }


}