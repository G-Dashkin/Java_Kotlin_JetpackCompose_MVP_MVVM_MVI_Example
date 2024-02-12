package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.Articles
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.NewsItemBinding

class NewsViewHolder(private val newsItemBinding: NewsItemBinding) : RecyclerView.ViewHolder(newsItemBinding.root) {

    fun bind(article : Articles) {
        newsItemBinding.title.text = article.title
        newsItemBinding.description.text = article.description
    }
}