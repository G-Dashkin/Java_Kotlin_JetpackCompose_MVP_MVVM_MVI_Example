package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.repository

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example14XML_MVI.NewsStates
import kotlinx.coroutines.flow.flow

class RepositoryImpl : Repository {

    override suspend fun getTopHeadlines() = flow {

            emit(NewsStates.Loading)

            val response = RetrofitClient.getInstance().apiService.getTopHeadlines()
            if (response.isSuccessful){
                emit(NewsStates.Success(response.body()!!))
            }else{
                emit(NewsStates.Error(response.errorBody().toString()))
            }

        }
}
