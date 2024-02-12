package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.model.Item

sealed class ItemListAction {

    object None : ItemListAction()
    object LoadItems : ItemListAction()
    data class ItemsLoaded(val items: List<Item>) : ItemListAction()
    data class Error(val error: Exception) : ItemListAction()

    //For test purposes
    data class Test(val testData: String) : ItemListAction()

}
