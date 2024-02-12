package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI

data class NewsData(val totalArticles: Int, val articles: List<Articles>)

data class Articles(val title: String,val description: String,val content: String, val url: String,
    val image:String, val publishedAt: String, val source: Source)

data class Source(val name:String, val url: String)