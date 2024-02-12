package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.repository

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.NewsStates
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getTopHeadlines() : Flow<NewsStates>
}