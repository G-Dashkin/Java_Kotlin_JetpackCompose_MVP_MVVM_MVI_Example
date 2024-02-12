package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.Articles
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.NewsItemBinding

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {

    private var articles = listOf<Articles>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemBinding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun addArticles(articles : List<Articles>){
        this.articles = articles
        notifyDataSetChanged()
    }

}