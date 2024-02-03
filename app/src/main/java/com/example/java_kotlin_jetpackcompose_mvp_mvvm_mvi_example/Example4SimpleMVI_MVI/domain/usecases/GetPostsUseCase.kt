package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.domain.usecases

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.DataState
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.UIComponent
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.domain.network.api.PostApi
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example4SimpleMVI_MVI.domain.models.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetPostsUseCase (
    private val postApi: PostApi
) {
    fun execute(): Flow<DataState<List<Post>>> {
        return flow {
            emit(DataState.Loading(true))
            try {
                val posts = postApi.getPosts()
                emit(DataState.Success(posts))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(DataState.Error(UIComponent.Toast(e.message?:"Unknown error")))
            } finally {
                emit(DataState.Loading(false))
            }
        }
    }
}

