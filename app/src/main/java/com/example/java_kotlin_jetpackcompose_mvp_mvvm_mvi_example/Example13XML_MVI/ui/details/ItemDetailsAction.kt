package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.details

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.model.Item

sealed class ItemDetailsAction {

    object None : ItemDetailsAction()
    object Load : ItemDetailsAction()
    data class ItemLoaded(val item: Item) : ItemDetailsAction()
    data class Error(val error: Exception) : ItemDetailsAction()

}
